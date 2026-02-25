package com.example.quiz;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="userdetails")
@Data
public class Userdetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String username;
    private String email;

    public void setName(String name){ this.name = name; }
    public void setUsername(String username){ this.username = username; }
    public void setEmail(String email){ this.email = email; }
}