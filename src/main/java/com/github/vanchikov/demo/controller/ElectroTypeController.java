package com.github.vanchikov.demo.controller;

import com.github.vanchikov.demo.model.ElectroTypeDTO;
import com.github.vanchikov.demo.service.ElectroTypeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/electroType")
@AllArgsConstructor
public class ElectroTypeController {
    @Autowired
    private ElectroTypeService electroTypeService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody ElectroTypeDTO electroTypeDTO) {
        electroTypeService.saveElectroType(electroTypeDTO);
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ElectroTypeDTO getElectroType(@PathVariable("id") long id) {
        return electroTypeService.getElectroType(id);
    }
}
