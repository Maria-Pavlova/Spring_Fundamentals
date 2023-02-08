package com.example.battleships.services;

import com.example.battleships.models.dto.bindingModels.AddShipModel;
import com.example.battleships.models.dto.viewModels.AllShipsViewModel;
import com.example.battleships.models.dto.viewModels.ShipViewModel;
import com.example.battleships.models.entities.Ship;
import com.example.battleships.repositories.CategoryRepository;
import com.example.battleships.repositories.ShipRepository;
import com.example.battleships.repositories.UserRepository;
import com.example.battleships.security.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipService {
    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;


    public ShipService(ShipRepository shipRepository, ModelMapper modelMapper,
                       CategoryRepository categoryRepository, UserRepository userRepository,
                       CurrentUser currentUser) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    public void addShip(AddShipModel shipModel) {
        Ship ship = modelMapper.map(shipModel, Ship.class);

        ship.setCategory(categoryRepository.findByName(shipModel.getCategory()));
        ship.setUser(userRepository.findByUsername(currentUser.getUsername()).get());

        shipRepository.save(ship);
    }

    public List<AllShipsViewModel> findAllShips() {
       return shipRepository.findAllByOrderByHealthAscNameDescPowerAsc()
                .stream()
                .map(ship -> modelMapper.map(ship, AllShipsViewModel.class))
                .toList();
    }

    public List<ShipViewModel> findAllShipsOwnedByAttacker() {
       return shipRepository.
               findAllByUser(userRepository.findByUsername(currentUser.getUsername()).get())
               .stream().map(ship -> modelMapper.map(ship, ShipViewModel.class))
               .toList();
    }

    public List<ShipViewModel> findAllShipsOwnedByDefender() {
        return shipRepository.
                findAllByUserIsNot(userRepository.findByUsername(currentUser.getUsername()).get())
                .stream().map(ship -> modelMapper.map(ship, ShipViewModel.class))
                .toList();
    }
}
