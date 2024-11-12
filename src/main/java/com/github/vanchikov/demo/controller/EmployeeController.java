package com.github.vanchikov.demo.controller;

import com.github.vanchikov.demo.model.EmployeeDTO;
import com.github.vanchikov.demo.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.saveEmployee(employeeDTO);
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeDTO getEmployee(@PathVariable("id") long id) {
        return employeeService.getEmployee(id);
    }

    public EmployeeDTO getBestEmployee() {
        return null;
    }

    public EmployeeDTO getJuniorConsultSeller() {
        return null;
    }
}
