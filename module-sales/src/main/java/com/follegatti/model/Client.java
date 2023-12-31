package com.follegatti.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idClient;
    @Column(length = 100, nullable = false)
    private String firstName;
    @Column(length = 100, nullable = false)
    private String lastName;
    @Column(length = 8, nullable = false, unique = true)
    private String cardId;
    @Column(length = 10, nullable = false)
    private String phoneNumber;
    @Column(length = 50, nullable = false)
    private String email;
    @Column(length = 100, nullable = false)
    private String address;
    @Column(length = 35, nullable = false)
    private String country;
}
