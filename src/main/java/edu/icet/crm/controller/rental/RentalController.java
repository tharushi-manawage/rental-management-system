package edu.icet.crm.controller.rental;

import edu.icet.crm.model.Rental;
import edu.icet.crm.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rental")
@RequiredArgsConstructor
@CrossOrigin
public class RentalController {
    private final RentalService rentalService;

    @PostMapping("/add-rental")
    void addRental(@RequestBody Rental rental) {
        rentalService.addRental(rental);
    }

    @GetMapping("/get-all-rentals")
    List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }

    @PutMapping("/update-rental")
    void updateRental(@RequestBody Rental rental) {
        rentalService.updateRental(rental);
    }

    @DeleteMapping("/delete-rental/{id}")
    boolean deleteRental(@PathVariable Long id) {
        return rentalService.deleteRental(id);
    }

    @GetMapping("/find-rental-by-id/{id}")
    Rental searchRentalById(@PathVariable Long id) {
        return rentalService.searchRentalById(id);
    }
}