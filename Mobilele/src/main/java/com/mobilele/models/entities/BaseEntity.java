package com.mobilele.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime modified;

    @PrePersist
    public void prePersist(){
        setCreated(LocalDateTime.now());
        setModified(LocalDateTime.now());
    }

    @PreUpdate
    public void preUpdate(){
        setModified(LocalDateTime.now());
    }
}
