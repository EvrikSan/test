package com.github.vanchikov.demo.service;

import com.github.vanchikov.demo.entity.PositionType;
import com.github.vanchikov.demo.model.PositionTypeDTO;
import com.github.vanchikov.demo.repository.PositionTypeRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
public class PositionTypeService {
    @Autowired
    private PositionTypeRepository positionTypeRepository;

    @Transactional
    public void savePositionType(PositionTypeDTO positionTypeDTO) {
        positionTypeRepository.save(
                PositionType.builder()
                        .job_name(positionTypeDTO.getJob_name())
                        .build());
    }

    public PositionTypeDTO getPositionType(long id) {
        var result = positionTypeRepository.findById(id);
        return PositionTypeDTO.builder()
                .job_name(result.get().getJob_name())
                .build();
    }
}
