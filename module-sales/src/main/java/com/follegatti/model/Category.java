package com.follegatti.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
//
// @Table(name = "tb_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idCategory;
    @Column(nullable = false, length = 50)
    private String name; //camelCase -> lowerCamelCase | DB: snake_
    @Column(nullable = false, length = 50)
    private String description;
    @Column(nullable = false)
    private boolean enabled;
}
