package com.github.vanchikov.demo.service;

import com.github.vanchikov.demo.entity.ElectroItem;
import com.github.vanchikov.demo.model.ElectroItemDTO;
import com.github.vanchikov.demo.repository.ElectroItemRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
public class ElectroItemService {
    private ElectroItemRepository electroItemRepository;

    public void saveElectroItem(ElectroItemDTO electroItemDTO) {
        electroItemRepository.save(
                ElectroItem.builder()
                        .name(electroItemDTO.getName())
                        .electroType(electroItemDTO.getElectroType())
                        .price(electroItemDTO.getPrice())
                        .count(electroItemDTO.getCount())
                        .archive(electroItemDTO.isArchive())
                        .description(electroItemDTO.getDescription())
                        .build());
    }

    public ElectroItemDTO getElectroItem(long id) {
        var result = electroItemRepository.findById(id);
        return ElectroItemDTO.builder()
                .name(result.get().getName())
                .electroType(result.get().getElectroType())
                .price(result.get().getPrice())
                .count(result.get().getCount())
                .archive(result.get().isArchive())
                .description(result.get().getDescription())
                .build();
    }
}
