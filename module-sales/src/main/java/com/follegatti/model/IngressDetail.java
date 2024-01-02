package com.follegatti.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@IdClass(IngressDetailPK.class)
public class IngressDetail {
    @Id
    private Ingress ingress;
    @Id
    private Product product;
}
