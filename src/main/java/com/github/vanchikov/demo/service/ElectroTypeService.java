package com.github.vanchikov.demo.service;

import com.github.vanchikov.demo.entity.ElectroType;
import com.github.vanchikov.demo.model.ElectroTypeDTO;
import com.github.vanchikov.demo.repository.ElectroTypeRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
public class ElectroTypeService {
    private ElectroTypeRepository electroTypeRepository;

    public void saveElectroType(ElectroTypeDTO electroTypeDTO) {
        electroTypeRepository.save(
                ElectroType.builder()
                        .name(electroTypeDTO.getName())
                        .build());
    }

    public ElectroTypeDTO getElectroType(long id) {
        var result = electroTypeRepository.findById(id);
        return ElectroTypeDTO.builder()
                .name(result.get().getName())
                .build();
    }
}
