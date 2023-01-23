package com.mobilele.models.entities;

import com.mobilele.models.enums.Engine;
import com.mobilele.models.enums.Transmission;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "offers")
public class Offer {

        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        private String id;

        @Column(columnDefinition = "TEXT")
        private String description;

        @Enumerated(EnumType.STRING)
        private Engine engine;

        @Column(name = "image_url")
        private String imageUrl;

        @Column(nullable = false)
        private Integer mileage;

        @Column(nullable = false)
        private Integer price;

        @Enumerated(EnumType.STRING)
        private Transmission transmission;

        @Column(nullable = false)
        private Integer year;

        @ManyToOne
        private Model model;

        @ManyToOne
        private User seller;

            }
