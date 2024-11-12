package com.github.vanchikov.demo.controller;

import com.github.vanchikov.demo.model.PurchaseTypeDTO;
import com.github.vanchikov.demo.service.PurchaseTypeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchasetype")
@AllArgsConstructor
public class PurchaseTypeController {
    @Autowired
    private PurchaseTypeService purchaseTypeService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody PurchaseTypeDTO purchaseTypeDTO) {
        purchaseTypeService.save(purchaseTypeDTO);
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PurchaseTypeDTO getPurchaseType(@PathVariable("id") long id) {
        return purchaseTypeService.getPurchaseType(id);
    }
}
