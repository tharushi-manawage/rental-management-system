package edu.icet.crm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Table(name = "rental_detail")
@Getter
@Setter
public class RentalDetailEntity {
    @Column(name = "TotalItemCost")
    private double totalItemCost;

    @Column(name = "QTY")
    private Integer qty;
}