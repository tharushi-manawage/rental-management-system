package edu.icet.crm.service;

import edu.icet.crm.model.Rental;

import java.util.List;

public interface RentalService {
    void addRental(Rental rental);

    List<Rental> getAllRentals();

    void updateRental(Rental rental);

    boolean deleteRental(Long id);

    Rental searchRentalById(Long id);
}