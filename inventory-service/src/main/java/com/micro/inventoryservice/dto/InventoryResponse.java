package com.micro.inventoryservice.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class InventoryResponse {
    private String skuCOde;
    private boolean isInStock;
}
