package com.micro.inventoryservice.repository;

import com.micro.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {


    Optional<Inventory> findBySkuCode(String skuCOde);

    List<Inventory> findBySkuCodeIn(List<String> skuCOde);
}
