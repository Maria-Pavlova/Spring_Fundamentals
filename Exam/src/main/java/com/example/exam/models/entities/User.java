package com.example.exam.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "seller")
    @Fetch(FetchMode.JOIN)
    private Set<Offer> offers = new HashSet<>();

    @OneToMany(mappedBy = "buyer")
    @Fetch(FetchMode.JOIN)
    private Set<Offer> boughtOffers = new HashSet<>();


    public void addOffer(Offer offer){
        this.offers.add(offer);
    }


}
