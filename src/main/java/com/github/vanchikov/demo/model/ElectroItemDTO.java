package com.github.vanchikov.demo.model;

import com.github.vanchikov.demo.entity.ElectroType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ElectroItemDTO {
    private String name;
    private ElectroType electroType;
    private long price;
    private int count;
    private boolean archive;
    private String description;
}
