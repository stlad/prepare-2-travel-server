package ru.prepare2travel.prepare2travelserver.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.prepare2travel.prepare2travelserver.model.dto.TravelPresetDTO;
import ru.prepare2travel.prepare2travelserver.service.TravelPresetService;
import ru.prepare2travel.prepare2travelserver.service.TravelService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/presets")
@Tag(name = "Presets API")
@Slf4j
public class PresetController {

    @Autowired
    private TravelService travelService;

    @Autowired
    private TravelPresetService presetService;

    @GetMapping("/all")
    public ResponseEntity<List<TravelPresetDTO>> getAllPresets(){
        log.info("GET to /travels/all");

        return new ResponseEntity<>(presetService.findAll(), HttpStatus.OK);
    }

}
