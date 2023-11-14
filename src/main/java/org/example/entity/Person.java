package org.example.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "persons")

public class Person {
    String phone;
@Transient
    private String login;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@Transient
    private String nickname;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;



}

