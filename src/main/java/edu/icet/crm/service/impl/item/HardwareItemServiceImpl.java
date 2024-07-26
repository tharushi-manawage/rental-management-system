package edu.icet.crm.service.impl.item;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.crm.entity.HardwareItemEntity;
import edu.icet.crm.model.HardwareItem;
import edu.icet.crm.repository.HardwareItemRepository;
import edu.icet.crm.service.HardwareItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HardwareItemServiceImpl implements HardwareItemService {
    private final HardwareItemRepository itemRepository;
    private final ObjectMapper mapper;

    @Override
    public void addItem(HardwareItem item) {
        HardwareItemEntity itemEntity = mapper.convertValue(item, HardwareItemEntity.class);
        itemRepository.save(itemEntity);
    }

    @Override
    public List<HardwareItem> getAllItems() {
        List<HardwareItem> itemList = new ArrayList();
        Iterable<HardwareItemEntity> all = itemRepository.findAll();

        all.forEach(itemEntity -> {
            HardwareItem item = mapper.convertValue(itemEntity, HardwareItem.class);
            itemList.add(item);
        });
        return itemList;
    }

    @Override
    public void updateItem(HardwareItem item) {
        if (itemRepository.existsById(item.getId())) {
            HardwareItemEntity itemEntity = mapper.convertValue(item, HardwareItemEntity.class);
            itemRepository.save(itemEntity);
        }
    }

    @Override
    public boolean deleteItem(Long id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public HardwareItem searchItemById(Long id) {
        if (itemRepository.existsById(id)) {
            Optional<HardwareItemEntity> byId = itemRepository.findById(id);
            return mapper.convertValue(byId, HardwareItem.class);
        }
        return null;
    }
}