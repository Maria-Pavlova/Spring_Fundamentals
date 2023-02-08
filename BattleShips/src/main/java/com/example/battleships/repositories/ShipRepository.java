package com.example.battleships.repositories;

import com.example.battleships.models.entities.Ship;
import com.example.battleships.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

    List<Ship> findAllByOrderByHealthAscNameDescPowerAsc();

    List<Ship> findAllByUser(User user);

    List<Ship> findAllByUserIsNot(User user);

    Optional<Ship> findByName(String name);
}
