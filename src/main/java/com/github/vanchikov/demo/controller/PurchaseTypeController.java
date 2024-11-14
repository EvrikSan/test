package com.github.vanchikov.demo.controller;

import com.github.vanchikov.demo.entity.PurchaseType;
import com.github.vanchikov.demo.model.PurchaseTypeDTO;
import com.github.vanchikov.demo.service.PurchaseTypeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchasetype")
@AllArgsConstructor
public class PurchaseTypeController {
    @Autowired
    private PurchaseTypeService purchaseTypeService;

    @Operation(summary = "Adding new purchase type to the database")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody PurchaseTypeDTO purchaseTypeDTO) {
        purchaseTypeService.save(purchaseTypeDTO);
    }

    @Operation(summary = "Retrieving targeted purchase type by id")
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PurchaseTypeDTO getPurchaseType(@PathVariable("id") long id) {
        return purchaseTypeService.getPurchaseType(id);
    }

    @Operation(summary = "Retrieving all purchase types with pageable and sort")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<PurchaseType> findAll(Pageable pageable) {
        return purchaseTypeService.findall(pageable);
    }
}
