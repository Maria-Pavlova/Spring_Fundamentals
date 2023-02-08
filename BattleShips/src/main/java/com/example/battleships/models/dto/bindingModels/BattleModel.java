package com.example.battleships.models.dto.bindingModels;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BattleModel {

    @NotNull
    private String attackerName;
    @NotNull
    private String defenderName;
}
