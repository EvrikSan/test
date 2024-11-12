package com.github.vanchikov.demo.controller;

import com.github.vanchikov.demo.model.PositionTypeDTO;
import com.github.vanchikov.demo.service.PositionTypeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/positiontype")
@AllArgsConstructor
public class PositionTypeController {
    @Autowired
    private PositionTypeService positionTypeService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String save(@RequestBody PositionTypeDTO positionTypeDTO) {
        positionTypeService.savePositionType(positionTypeDTO);
        return "good";
    }

    /*
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String save(@RequestBody ShopDTO shopDTO){
        shopService.saveShop(shopDTO.getName(), shopDTO.getAddress());
        return "good";
    }

     */

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PositionTypeDTO getPositionType(@PathVariable("id") long id) {
        return positionTypeService.getPositionType(id);
    }
}
