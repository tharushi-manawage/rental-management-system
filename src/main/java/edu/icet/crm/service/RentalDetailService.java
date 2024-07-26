package edu.icet.crm.service;

import edu.icet.crm.model.RentalDetail;

import java.util.List;

public interface RentalDetailService {
    void addRentalDetail(RentalDetail rentalDetail);

    List<RentalDetail> getAllRentalDetails();

    void updateRentalDetail(RentalDetail rentalDetail);

    boolean deleteRentalDetail(Long id);

    RentalDetail searchRentalDetailById(Long id);
}