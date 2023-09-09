package com.ejercicio.pos.catalog.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "warehouse_product")
public class WarehouseProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private WarehouseEntity warehouse;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductEntity product;

    @Column
    private Integer quantity;

    @Column
    private LocalDate expirationDate;

    @Column
    private String invima;
}

