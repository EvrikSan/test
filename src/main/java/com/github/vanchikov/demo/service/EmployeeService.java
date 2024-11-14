package com.github.vanchikov.demo.service;

import com.github.vanchikov.demo.entity.Employee;
import com.github.vanchikov.demo.model.EmployeeDTO;
import com.github.vanchikov.demo.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public void saveEmployee(EmployeeDTO employeeDTO) {
        employeeRepository.save(
                Employee.builder()
                        .lastName(employeeDTO.getLastName())
                        .firstName(employeeDTO.getFirstName())
                        .patronymic(employeeDTO.getPatronymic())
                        .birthDate(employeeDTO.getBirthDate())
                        .position(employeeDTO.getPosition())
                        .shop(employeeDTO.getShop())
                        .gender(employeeDTO.isGender())
                        .electroTypes(employeeDTO.getElectroTypes())
                        .build());


    }

    public EmployeeDTO getEmployee(long id) {
        var result = employeeRepository.findById(id);
        return EmployeeDTO.builder()
                .lastName(result.get().getLastName())
                .firstName(result.get().getFirstName())
                .patronymic(result.get().getPatronymic())
                .birthDate(result.get().getBirthDate())
                .position(result.get().getPosition())
                .shop(result.get().getShop())
                .gender(result.get().isGender())
                .electroTypes(result.get().getElectroTypes())
                .build();
    }

    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }
}
