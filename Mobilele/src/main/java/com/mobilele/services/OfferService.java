package com.mobilele.services;

import com.mobilele.models.dtos.AddOfferModel;
import com.mobilele.models.dtos.BrandDto;
import com.mobilele.models.dtos.views.OfferDetailsDto;
import com.mobilele.models.dtos.views.OffersView;
import com.mobilele.models.entities.Model;
import com.mobilele.models.entities.Offer;
import com.mobilele.models.entities.User;
import com.mobilele.repositories.ModelRepository;
import com.mobilele.repositories.OfferRepository;
import com.mobilele.repositories.UserRepository;
import com.mobilele.user.CurrentUser;
import com.mobilele.utils.mapper.OfferMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private final OfferMapper offerMapper;
    private final UserRepository userRepository;
    private final ModelRepository modelRepository;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;

    public OfferService(OfferRepository offerRepository, OfferMapper offerMapper,
                        UserRepository userRepository, ModelRepository modelRepository,
                        CurrentUser currentUser, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.offerMapper = offerMapper;
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }

    public void addOffer(AddOfferModel addOfferModel) {

        Offer newOffer = modelMapper.map(addOfferModel, Offer.class);
        // Offer newOffer =
        //offerMapper.addOfferModelToOffer(addOfferModel);
        //TODO check current user logged in
        User user = userRepository.findByUsername(currentUser.getUsername())
                .orElseThrow();

        Model model = modelRepository.findById(addOfferModel.getModelId())
                .orElseThrow();

        newOffer.setModel(model);
        newOffer.setSeller(user);

        offerRepository.save(newOffer);
    }

    public List<OffersView> getAllOffers() {
        return offerRepository.findAll()
                .stream()
                .map(offer -> {
                    OffersView view = modelMapper.map(offer, OffersView.class);
                    view.setModel(offer.getModel().getName());
                    view.setBrand(offer.getModel().getBrand().getName());
                    return view;
                })
                .toList();
    }

    public OfferDetailsDto findById(String id) {
     return offerRepository.findById(id)
                .map(offer -> {
                    OfferDetailsDto detailsDto = modelMapper.map(offer, OfferDetailsDto.class);
                    detailsDto.setSeller(offer.getSeller().getFirstName()+" "+ offer.getSeller().getLastName());
                    detailsDto.setModel(offer.getModel().getName());
                    detailsDto.setBrand(offer.getModel().getBrand().getName());
                    return detailsDto;
                }).get();

    }

    public void deleteOffer(String id) {
        offerRepository.deleteById(id);
    }
}
