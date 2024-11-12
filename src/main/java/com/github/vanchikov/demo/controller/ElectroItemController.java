package com.github.vanchikov.demo.controller;

import com.github.vanchikov.demo.model.ElectroItemDTO;
import com.github.vanchikov.demo.service.ElectroItemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/electroItem")
@AllArgsConstructor
public class ElectroItemController {
    @Autowired
    private ElectroItemService electroItemService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody ElectroItemDTO electroItemDTO) {
        electroItemService.saveElectroItem(electroItemDTO);
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ElectroItemDTO getElectroItem(@PathVariable("id") long id) {
        return electroItemService.getElectroItem(id);
    }
}
