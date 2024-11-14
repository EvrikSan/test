package com.github.vanchikov.demo.controller;

import com.github.vanchikov.demo.entity.Employee;
import com.github.vanchikov.demo.model.EmployeeDTO;
import com.github.vanchikov.demo.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Operation(summary = "Adding new employee to the database")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.saveEmployee(employeeDTO);
    }

    @Operation(summary = "Retrieving targeted employee by id")
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeDTO getEmployee(@PathVariable("id") long id) {
        return employeeService.getEmployee(id);
    }

    /*
    public EmployeeDTO getBestEmployee() {
        return null;
    }

    public EmployeeDTO getJuniorConsultSeller() {
        return null;
    }
     */

    @Operation(summary = "Retrieving all employees with pageable and sort")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Employee> findAll(Pageable pageable) {
        return employeeService.findAll(pageable);
    }
}
