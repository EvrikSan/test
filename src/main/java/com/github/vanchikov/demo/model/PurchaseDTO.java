package com.github.vanchikov.demo.model;

import com.github.vanchikov.demo.entity.ElectroItem;
import com.github.vanchikov.demo.entity.Employee;
import com.github.vanchikov.demo.entity.PurchaseType;
import com.github.vanchikov.demo.entity.Shop;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseDTO {
    private ElectroItem electroItem;
    private Employee employee;
    private Shop shop;
    private Date purchaseDate;
    private PurchaseType purchaseType;
}
