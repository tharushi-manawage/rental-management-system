package edu.icet.crm.controller.item;

import edu.icet.crm.model.HardwareItem;
import edu.icet.crm.service.HardwareItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
@CrossOrigin
public class HardwareItemController {
    private final HardwareItemService itemService;

    @PostMapping("/add-item")
    void addItem(@RequestBody HardwareItem item) {
        itemService.addItem(item);
    }

    @GetMapping("/get-all-items")
    List<HardwareItem> getAllItems() {
        return itemService.getAllItems();
    }

    @PutMapping("/update-item")
    void updateItem(@RequestBody HardwareItem item) {
        itemService.updateItem(item);
    }

    @DeleteMapping("/delete-item/{id}")
    boolean deleteItem(@PathVariable Long id) {
        return itemService.deleteItem(id);
    }

    @GetMapping("/find-item-by-id/{id}")
    HardwareItem searchItemById(@PathVariable Long id) {
        return itemService.searchItemById(id);
    }
}