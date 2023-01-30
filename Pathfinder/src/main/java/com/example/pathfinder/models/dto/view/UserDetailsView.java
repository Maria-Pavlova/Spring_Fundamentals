package com.example.pathfinder.models.dto.view;

import com.example.pathfinder.models.enums.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsView {

    private String fullName;
    private String username;
    private Integer age;
    private Level level;
}
