package com.example.exam.services;

import com.example.exam.models.dtos.bindingModels.AddOfferModel;
import com.example.exam.models.dtos.viewModels.BoughtItemsView;
import com.example.exam.models.dtos.viewModels.OfferViewModel;
import com.example.exam.models.entities.Offer;
import com.example.exam.models.entities.User;
import com.example.exam.repositories.OfferRepository;
import com.example.exam.security.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class OfferService {
    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final ConditionService conditionService;
    private final UserService userService;
    private final CurrentUser currentUser;

    public OfferService(OfferRepository offerRepository, ModelMapper modelMapper,
                        ConditionService conditionService, UserService userService, CurrentUser currentUser) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.conditionService = conditionService;
        this.userService = userService;
        this.currentUser = currentUser;
    }

    public void addOffer(AddOfferModel offerModel) {
        Offer offer = modelMapper.map(offerModel, Offer.class);
        offer.setCondition(conditionService.findByName(offerModel.getCondition()));

        User user = userService.findByUsername(currentUser.getUsername()).get();

        offer.setSeller(user);
        offerRepository.saveAndFlush(offer);

        user.getOffers().add(offer);
        userService.saveUser(user);


    }

    public List<OfferViewModel> findLoggedUserOffers() {
        List<OfferViewModel> offerViewModels = Objects.requireNonNull(offerRepository.findAllBySeller_Username(currentUser.getUsername())
                        .orElse(null))
                .stream()
                .map(offer -> modelMapper.map(offer, OfferViewModel.class))
                .toList();
        return offerViewModels;
    }

    public List<OfferViewModel> findOtherUsersOffers() {
        return Objects.requireNonNull(offerRepository.findAllBySeller_UsernameNot(currentUser.getUsername())
                        .orElse(null))
                .stream()
                .map(offer -> modelMapper.map(offer, OfferViewModel.class))
                .toList();
    }

    @Transactional
    public void removeOfferById(Long id) {
        Offer offer = offerRepository.findById(id).get();
        User seller = offer.getSeller();
        offerRepository.delete(offer);
        seller.getOffers().remove(offer);
        userService.saveUser(seller);
    }

    @Transactional
    public void buy(Long id) {
        Offer offer = offerRepository.findById(id).get();
        User seller = offer.getSeller();
        User buyer = userService.findByUsername(currentUser.getUsername()).get();
        offer.setBuyer(buyer);
        offer.setSeller(null);
        seller.getOffers().remove(offer);
        Set<Offer> boughtOffers = buyer.getBoughtOffers();
        boughtOffers.add(offer);
        userService.saveUser(buyer);
        userService.saveUser(seller);
    }


    public List<BoughtItemsView> findBoughtItems() {
        return Objects.requireNonNull(offerRepository.findAllByBuyer_Username(currentUser.getUsername())
                        .orElse(null))
                .stream()
                .map(offer -> modelMapper.map(offer, BoughtItemsView.class)).toList();
    }
}
