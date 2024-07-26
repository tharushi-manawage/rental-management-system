package edu.icet.crm.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "rental")
@Getter
@Setter
public class RentalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RentID")
    private Long id;

    @Column(name = "RentalDate")
    private Date rentalDate;

    @Column(name = "DueDate")
    private Date dueDate;

    @Column(name = "ExpectedDate")
    private Date expectedDate;

    @Column(name = "ReturnDate")
    private Date returnDate;

    @Column(name = "TotalCost")
    private double totalCost;

    @Column(name = "Fine")
    private double fine;
}