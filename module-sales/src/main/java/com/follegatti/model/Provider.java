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
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    public Integer idProvider;
    @Column(length = 30, nullable = false)
    public String name;
    @Column(length = 150, nullable = false)
    public String address;
    @Column(nullable = false)
    public String enabled;
}
