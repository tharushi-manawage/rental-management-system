package edu.icet.crm.service.impl.rental;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.crm.entity.RentalDetailEntity;
import edu.icet.crm.model.RentalDetail;
import edu.icet.crm.repository.RentalDetailRepository;
import edu.icet.crm.service.RentalDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RentalDetailServiceImpl implements RentalDetailService {
    private final RentalDetailRepository rentalDetailRepository;
    private final ObjectMapper mapper;

    @Override
    public void addRentalDetail(RentalDetail rentalDetail) {
        RentalDetailEntity rentalDetailEntity = mapper.convertValue(rentalDetail, RentalDetailEntity.class);
        rentalDetailRepository.save(rentalDetailEntity);
    }

    @Override
    public List<RentalDetail> getAllRentalDetails() {
        List<RentalDetail> rentalDetailList = new ArrayList();
        Iterable<RentalDetailEntity> all = rentalDetailRepository.findAll();

        all.forEach(rentalDetailEntity -> {
            RentalDetail rentalDetail = mapper.convertValue(rentalDetailEntity, RentalDetail.class);
            rentalDetailList.add(rentalDetail);
        });
        return rentalDetailList;
    }

    @Override
    public void updateRentalDetail(RentalDetail rentalDetail) {
        if (rentalDetailRepository.existsById(rentalDetail.getId())) {
            RentalDetailEntity rentalDetailEntity = mapper.convertValue(rentalDetail, RentalDetailEntity.class);
            rentalDetailRepository.save(rentalDetailEntity);
        }
    }

    @Override
    public boolean deleteRentalDetail(Long id) {
        if (rentalDetailRepository.existsById(id)) {
            rentalDetailRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public RentalDetail searchRentalDetailById(Long id) {
        if (rentalDetailRepository.existsById(id)) {
            Optional<RentalDetailEntity> byId = rentalDetailRepository.findById(id);
            return mapper.convertValue(byId, RentalDetail.class);
        }
        return null;
    }
}