package com.github.vanchikov.demo.controller;

import com.github.vanchikov.demo.entity.Shop;
import com.github.vanchikov.demo.model.ShopDTO;
import com.github.vanchikov.demo.service.ShopService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop")
@AllArgsConstructor
public class ShopController {
    @Autowired
    private ShopService shopService;

    @Operation(summary = "Adding new shop to the database")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String save(@RequestBody ShopDTO shopDTO) {
        shopService.saveShop(shopDTO);
        return "good";
    }

    @Operation(summary = "Retrieving targeted shop by id")
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ShopDTO getShop(@PathVariable("id") long id) {
        return shopService.getShop(id);
    }

    @Operation(summary = "Retrieving available count of item in the shop by id's")
    @GetMapping(value = "{shopId}/quantity", produces = MediaType.APPLICATION_JSON_VALUE)
    public int getQuantityByElectroItemIdAndShopId(@RequestParam("itemId") long itemId, @PathVariable("shopId") long shopId) {
        return shopService.getQuantityByElectroItemIdAndShopId(itemId, shopId);
    }

    @Operation(summary = "Retrieving all shops with pageable and sort")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Shop> findAll(Pageable pageable) {
        return shopService.findAll(pageable);
    }

    /*@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Shop> getShops(){
        return shopService.getShops();
    }*/
}
