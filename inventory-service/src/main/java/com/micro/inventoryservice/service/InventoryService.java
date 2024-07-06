package com.micro.inventoryservice.service;

import com.micro.inventoryservice.dto.InventoryResponse;
import com.micro.inventoryservice.model.Inventory;
import com.micro.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly=true)
    public List<InventoryResponse> isInStock(List<String> skuCOde){
       return inventoryRepository.findBySkuCodeIn(skuCOde).stream().map(this::mapTODto).toList();
    }

    private InventoryResponse mapTODto(Inventory inventory) {
        InventoryResponse inventoryResponse=new InventoryResponse();
        inventoryResponse.setInStock(inventory.getQuantity()>0);
        inventoryResponse.setSkuCOde(inventory.getSkuCode());

        return inventoryResponse;
    }
}
