package com.socialfeed.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class UserAccount {
    @Id
    @SequenceGenerator(name = "user_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @Column(name = "user_id")
    private Long id;
    @Size(max = 100)
    private String name;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isValidUser() {
        return name != null && password != null;
    }
}
