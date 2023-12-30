package com.follegatti.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//
// @Table(name = "tb_category")
public class Category {
    @Id
    private Integer idCategory;
    @Column(nullable = false, length = 50)
    private String name; //camelCase -> lowerCamelCase | DB: snake_
    @Column(nullable = false, length = 50)
    private String description;
    @Column(nullable = false)
    private boolean enabled;
}
