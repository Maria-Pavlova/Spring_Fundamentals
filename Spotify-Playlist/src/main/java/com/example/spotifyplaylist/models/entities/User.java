package com.example.spotifyplaylist.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Song> playlist = new HashSet<>();


    public void addSongToPlaylist(Song song) {
        this.playlist.add(song);
    }

    public void removeAll(Set<Song> playlist) {
        this.playlist.removeAll(playlist);
    }

}
