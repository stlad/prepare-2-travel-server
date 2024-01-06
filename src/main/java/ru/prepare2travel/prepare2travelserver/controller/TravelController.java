package ru.prepare2travel.prepare2travelserver.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.prepare2travel.prepare2travelserver.model.dto.TravelDTO;
import ru.prepare2travel.prepare2travelserver.service.TravelService;

import java.util.List;

@RestController
@RequestMapping("/travels")
@Tag(name = "Travels API")
@Slf4j
public class TravelController {

    @Autowired
    private TravelService travelService;

    @GetMapping("/{id}")
    public ResponseEntity<TravelDTO> get(@PathVariable(value = "id") Long id) {
        log.info("GET to /travels/{id}");
        TravelDTO dto = travelService.findById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<TravelDTO>> getAll() {
        log.info("GET to /travels/all");
        List<TravelDTO> dto = travelService.findAll();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
