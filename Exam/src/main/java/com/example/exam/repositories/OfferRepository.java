package com.example.exam.repositories;

import com.example.exam.models.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    Optional<List<Offer>> findAllBySeller_Username(String username);

    Optional<List<Offer>> findAllByBuyer_Username(String username);

    Optional<List<Offer>> findAllBySeller_UsernameNot(String username);

}
