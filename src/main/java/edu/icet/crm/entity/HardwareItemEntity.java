package edu.icet.crm.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "hardware_item")
@Getter
@Setter
public class HardwareItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ItemID")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "RentalPerDay")
    private double rentalPerDay;

    @Column(name = "FinePerDay")
    private double finePerDay;

    @Column(name = "Availability")
    private boolean availability;
}