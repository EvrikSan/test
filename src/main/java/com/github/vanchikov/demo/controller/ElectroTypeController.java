package com.github.vanchikov.demo.controller;

import com.github.vanchikov.demo.entity.ElectroType;
import com.github.vanchikov.demo.model.ElectroTypeDTO;
import com.github.vanchikov.demo.service.ElectroTypeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/electroType")
@AllArgsConstructor
public class ElectroTypeController {
    @Autowired
    private ElectroTypeService electroTypeService;

    @Operation(summary = "Adding new electro type to the database")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody ElectroTypeDTO electroTypeDTO) {
        electroTypeService.saveElectroType(electroTypeDTO);
    }

    @Operation(summary = "Retrieving targeted electro type by id")
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ElectroTypeDTO getElectroType(@PathVariable("id") long id) {
        return electroTypeService.getElectroType(id);
    }

    @Operation(summary = "Retrieving all electro types with pageable and sort")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<ElectroType> findAll(Pageable pageable) {
        return electroTypeService.findAll(pageable);
    }
}
