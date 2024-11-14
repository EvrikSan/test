package com.github.vanchikov.demo.service;

import com.github.vanchikov.demo.entity.PurchaseType;
import com.github.vanchikov.demo.model.PurchaseTypeDTO;
import com.github.vanchikov.demo.repository.PurchaseTypeRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
public class PurchaseTypeService {
    @Autowired
    private PurchaseTypeRepository purchaseTypeRepository;

    @Transactional
    public void save(PurchaseTypeDTO purchaseTypeDTO) {
        purchaseTypeRepository.save(
                PurchaseType.builder()
                        .name(purchaseTypeDTO.getName())
                        .build());
    }

    public PurchaseTypeDTO getPurchaseType(long id) {
        var result = purchaseTypeRepository.findById(id);
        return PurchaseTypeDTO.builder()
                .name(result.get().getName())
                .build();
    }

    public Page<PurchaseType> findall(Pageable pageable) {
        return purchaseTypeRepository.findAll(pageable);
    }
}
