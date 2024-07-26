package edu.icet.crm.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customer")
@Getter
@Setter
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CustomerID")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "City")
    private String city;

    @Column(name = "Contact")
    private String contact;
}