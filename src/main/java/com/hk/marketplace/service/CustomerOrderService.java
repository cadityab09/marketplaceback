package com.hk.marketplace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.marketplace.entity.CustomerOrder;
import com.hk.marketplace.entity.InventoryItem;
import com.hk.marketplace.repository.CustomerOrderRepository;
import com.hk.marketplace.repository.InventoryRepository;

@Service
public class CustomerOrderService {

    @Autowired
    private CustomerOrderRepository orderRepo;

    @Autowired
    private InventoryRepository inventoryRepo;

    public CustomerOrder placeOrder(CustomerOrder order) {
        InventoryItem item = inventoryRepo.findByItem(order.getItemName());

        if (item == null || item.getQuantity() < order.getQuantity()) {
            throw new RuntimeException("Item not available or quantity insufficient");
        }

        item.setQuantity(item.getQuantity() - order.getQuantity());
        inventoryRepo.save(item);

        return orderRepo.save(order);
    }
}
