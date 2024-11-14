package com.github.vanchikov.demo.controller;

import com.github.vanchikov.demo.entity.ElectroItem;
import com.github.vanchikov.demo.model.ElectroItemDTO;
import com.github.vanchikov.demo.service.ElectroItemService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/electroItem")
@AllArgsConstructor
public class ElectroItemController {
    @Autowired
    private ElectroItemService electroItemService;

    @Operation(summary = "Adding new electro item to the database")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody ElectroItemDTO electroItemDTO) {
        electroItemService.saveElectroItem(electroItemDTO);
    }

    @Operation(summary = "Retrieving targeted electro item by id")
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ElectroItemDTO getElectroItem(@PathVariable("id") long id) {
        return electroItemService.getElectroItem(id);
    }

    @Operation(summary = "Retrieving all electro items with pageable and sort")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<ElectroItem> findAll(Pageable pageable) {
        return electroItemService.findAll(pageable);
    }
}
