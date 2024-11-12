package com.github.vanchikov.demo.model;

import com.github.vanchikov.demo.entity.ElectroType;
import com.github.vanchikov.demo.entity.PositionType;
import com.github.vanchikov.demo.entity.Shop;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {
    private String lastName;
    private String firstName;
    private String patronymic;
    private Date birthDate;
    private PositionType position;
    private Shop shop;
    private boolean gender;
    List<ElectroType> electroTypes;
}
