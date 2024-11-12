package com.github.vanchikov.demo.controller;

import com.github.vanchikov.demo.model.ShopDTO;
import com.github.vanchikov.demo.service.ShopService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop")
@AllArgsConstructor
public class ShopController {
    @Autowired
    private ShopService shopService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String save(@RequestBody ShopDTO shopDTO) {
        shopService.saveShop(shopDTO);
        return "good";
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ShopDTO getShop(@PathVariable("id") long id) {
        return shopService.getShop(id);
    }

    @GetMapping(value = "{shopId}/quantity", produces = MediaType.APPLICATION_JSON_VALUE)
    public int getQuantityByElectroItemIdAndShopId(@RequestParam("itemId") long itemId, @PathVariable("shopId") long shopId) {
        return shopService.getQuantityByElectroItemIdAndShopId(itemId, shopId);
    }

    /*@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Shop> getShops(){
        return shopService.getShops();
    }*/
}
