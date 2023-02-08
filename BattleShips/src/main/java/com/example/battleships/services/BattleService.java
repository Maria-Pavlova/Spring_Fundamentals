package com.example.battleships.services;

import com.example.battleships.models.dto.bindingModels.BattleModel;
import com.example.battleships.models.entities.Ship;
import com.example.battleships.repositories.ShipRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BattleService {
    private final ShipRepository shipRepository;

    public BattleService(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }


    public void fire(BattleModel battleModel) {

        Optional<Ship> attackerShip = shipRepository.findByName(battleModel.getAttackerName());
        Optional<Ship> defenderShip = shipRepository.findByName(battleModel.getDefenderName());

        if (attackerShip.isEmpty() || defenderShip.isEmpty()){
            throw new NoSuchElementException("Ship is not present");
        }
        Ship defender = defenderShip.get();
        Ship attacker = attackerShip.get();

        if (defender.getHealth() <= 0){
            shipRepository.delete(defender);
        }else {
            defender.setHealth(defender.getHealth() - attacker.getPower());
            shipRepository.save(defender);
        }
    }
}
