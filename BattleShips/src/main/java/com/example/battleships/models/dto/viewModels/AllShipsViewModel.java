package com.example.battleships.models.dto.viewModels;

import lombok.Data;

import java.io.Serializable;

@Data
public class AllShipsViewModel implements Serializable {
    private String name;
    private Long health;
    private Long power;
}
