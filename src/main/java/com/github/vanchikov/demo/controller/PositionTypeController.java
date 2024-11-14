package com.github.vanchikov.demo.controller;

import com.github.vanchikov.demo.entity.PositionType;
import com.github.vanchikov.demo.model.PositionTypeDTO;
import com.github.vanchikov.demo.service.PositionTypeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/positiontype")
@AllArgsConstructor
public class PositionTypeController {
    @Autowired
    private PositionTypeService positionTypeService;

    @Operation(summary = "Adding new position type to the database")
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

    @Operation(summary = "Retrieving targeted position type by id")
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PositionTypeDTO getPositionType(@PathVariable("id") long id) {
        return positionTypeService.getPositionType(id);
    }

    @Operation(summary = "Retrieving all position types with pageable and sort")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<PositionType> findAll(Pageable pageable) {
        return positionTypeService.findAll(pageable);
    }
}
