package com.example.pathfinder.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mesaages")
public class Message extends BaseEntity{

    @Column(name = "date_time")
    private LocalDateTime dateTime;

   // @Lob
    @Column(name = "text_content", columnDefinition = "LONGTEXT")
    private String textContent;

    @ManyToOne
    private User author;

    @ManyToOne
    private User recipient;
}
