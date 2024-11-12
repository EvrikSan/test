package com.github.vanchikov.demo.controller;


import com.github.vanchikov.demo.model.PurchaseDTO;
import com.github.vanchikov.demo.service.PurchaseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase")
@AllArgsConstructor
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody PurchaseDTO purchaseDTO) {
        purchaseService.savePurchase(purchaseDTO);
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PurchaseDTO getPurchase(@PathVariable("id") long id) {
        return purchaseService.getPurchase(id);
    }

    public long getCashGainedValue() {
        return 0;
    }
}
