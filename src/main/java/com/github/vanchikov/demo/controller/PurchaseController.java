package com.github.vanchikov.demo.controller;


import com.github.vanchikov.demo.entity.Purchase;
import com.github.vanchikov.demo.model.PurchaseDTO;
import com.github.vanchikov.demo.service.PurchaseService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase")
@AllArgsConstructor
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @Operation(summary = "Adding new purchase to the database")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody PurchaseDTO purchaseDTO) {
        purchaseService.savePurchase(purchaseDTO);
    }

    @Operation(summary = "Retrieving targeted purchase by id")
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PurchaseDTO getPurchase(@PathVariable("id") long id) {
        return purchaseService.getPurchase(id);
    }

    /*public long getCashGainedValue() {
        return 0;
    }*/

    @Operation(summary = "Retrieving all purchases with pageable and sort")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Purchase> findAll(Pageable pageable) {
        return purchaseService.findAll(pageable);
    }
}
