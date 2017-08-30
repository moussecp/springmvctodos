package com.hermes.training.spring.mvc.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    @SequenceGenerator(name = "USER_SEQ")
    private Long id;

    @NotNull
    @Column(name = "CREATION_DATE")
    private final LocalDateTime dateTime = LocalDateTime.now();

    @Size(min = 3, message = "Enter at least 3 characters")
    @NotNull
    @Column(unique = true)
    private String username;

    public User(String username) {
        this.username = username;
    }

    public User(Long id, String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
