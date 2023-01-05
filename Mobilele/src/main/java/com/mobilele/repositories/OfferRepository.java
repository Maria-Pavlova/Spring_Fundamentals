package com.mobilele.repositories;

import com.mobilele.models.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, String> {
}
