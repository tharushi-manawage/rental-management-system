package edu.icet.crm.controller.rental;

import edu.icet.crm.model.Rental;
import edu.icet.crm.model.RentalDetail;
import edu.icet.crm.service.RentalDetailService;
import edu.icet.crm.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rental-detail")
@RequiredArgsConstructor
@CrossOrigin
public class RentalDetailController {
    private final RentalDetailService rentalDetailService;

    @PostMapping("/add-rental-detail")
    void addRentalDetail(@RequestBody RentalDetail rentalDetail) {
        rentalDetailService.addRentalDetail(rentalDetail);
    }

    @GetMapping("/get-all-rental-details")
    List<RentalDetail> getAllRentalDetails() {
        return rentalDetailService.getAllRentalDetails();
    }

    @PutMapping("/update-rental-details")
    void updateRentalDetails(@RequestBody RentalDetail rentalDetail) {
        rentalDetailService.updateRentalDetail(rentalDetail);
    }

    @DeleteMapping("/delete-rental-detail/{id}")
    boolean deleteRentalDetail(@PathVariable Long id) {
        return rentalDetailService.deleteRentalDetail(id);
    }

    @GetMapping("/find-rental-detail-by-id/{id}")
    RentalDetail searchRentalDetailById(@PathVariable Long id) {
        return rentalDetailService.searchRentalDetailById(id);
    }
}