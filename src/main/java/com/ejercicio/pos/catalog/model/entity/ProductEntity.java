package com.ejercicio.pos.catalog.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany
    private List<CategoryEntity> categories;

    @Column
    private String barCode;

    @Column
    private String description;

    @Column
    private Double price;

    @Column
    private Double specialPrice;

    @Column
    private Double cost;

    @Column
    private Integer quantity;

}