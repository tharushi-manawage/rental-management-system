package edu.icet.crm.service.impl.rental;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.crm.entity.RentalEntity;
import edu.icet.crm.model.Rental;
import edu.icet.crm.repository.RentalRepository;
import edu.icet.crm.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {
    private final RentalRepository rentalRepository;
    private final ObjectMapper mapper;

    @Override
    public void addRental(Rental rental) {
        RentalEntity rentalEntity = mapper.convertValue(rental, RentalEntity.class);
        rentalRepository.save(rentalEntity);
    }

    @Override
    public List<Rental> getAllRentals() {
        List<Rental> rentalList = new ArrayList();
        Iterable<RentalEntity> all = rentalRepository.findAll();

        all.forEach(rentalEntity -> {
            Rental rental = mapper.convertValue(rentalEntity, Rental.class);
            rentalList.add(rental);
        });
        return rentalList;
    }

    @Override
    public void updateRental(Rental rental) {
        if (rentalRepository.existsById(rental.getId())) {
            RentalEntity rentalEntity = mapper.convertValue(rental, RentalEntity.class);
            rentalRepository.save(rentalEntity);
        }
    }

    @Override
    public boolean deleteRental(Long id) {
        if (rentalRepository.existsById(id)) {
            rentalRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Rental searchRentalById(Long id) {
        if (rentalRepository.existsById(id)) {
            Optional<RentalEntity> byId = rentalRepository.findById(id);
            return mapper.convertValue(byId, Rental.class);
        }
        return null;
    }
}