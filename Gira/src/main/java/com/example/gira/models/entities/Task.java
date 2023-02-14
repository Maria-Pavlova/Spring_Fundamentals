package com.example.gira.models.entities;

import com.example.gira.models.enums.Progress;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Progress progress;
    @Column(name = "due_date")
    private LocalDate dueDate;
    @ManyToOne(fetch = FetchType.EAGER)
    private Classification classification;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
}
