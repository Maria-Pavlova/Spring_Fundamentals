package com.example.battleships.models.dto.viewModels;

import lombok.Data;

import java.io.Serializable;

@Data
public class ShipViewModel implements Serializable {
    private Long id;
    private String name;
    private Long health;
    private Long power;
}
