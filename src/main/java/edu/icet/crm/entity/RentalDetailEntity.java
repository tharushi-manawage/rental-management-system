package edu.icet.crm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rental_detail")
public class RentalDetailEntity {
    @Column(name = "TotalItemCost")
    private double totalItemCost;

    @Column(name = "QTY")
    private Integer qty;
}