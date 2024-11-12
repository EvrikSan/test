package com.github.vanchikov.demo.service;

import com.github.vanchikov.demo.entity.Purchase;
import com.github.vanchikov.demo.model.PurchaseDTO;
import com.github.vanchikov.demo.repository.PurchaseRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
public class PurchaseService {
    private PurchaseRepository purchaseRepository;

    public void savePurchase(PurchaseDTO purchaseDTO) {
        purchaseRepository.save(
                Purchase.builder()
                        .electroItem(purchaseDTO.getElectroItem())
                        .employee(purchaseDTO.getEmployee())
                        .shop(purchaseDTO.getShop())
                        .purchaseDate(purchaseDTO.getPurchaseDate())
                        .purchaseType(purchaseDTO.getPurchaseType())
                        .build());
    }

    public PurchaseDTO getPurchase(long id) {
        var result = purchaseRepository.findById(id);
        return PurchaseDTO.builder()
                .electroItem(result.get().getElectroItem())
                .employee(result.get().getEmployee())
                .shop(result.get().getShop())
                .purchaseDate(result.get().getPurchaseDate())
                .purchaseType(result.get().getPurchaseType())
                .build();
    }
}
