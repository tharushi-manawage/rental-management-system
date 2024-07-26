package edu.icet.crm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hardware_item")
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