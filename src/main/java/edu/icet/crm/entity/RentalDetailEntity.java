package edu.icet.crm.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rental_detail")
@Getter
@Setter
public class RentalDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RentalDetailID")
    private Long id;

    @Column(name = "TotalItemCost")
    private double totalItemCost;

    @Column(name = "QTY")
    private Integer qty;
}