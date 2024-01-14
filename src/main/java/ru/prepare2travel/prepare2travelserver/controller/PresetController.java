package ru.prepare2travel.prepare2travelserver.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.prepare2travel.prepare2travelserver.model.dto.TravelDTO;
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
    private TravelPresetService presetService;

    @GetMapping("/all")
    public ResponseEntity<List<TravelPresetDTO>> getAllPresets(){
        log.info("GET to /presets/all");

        return new ResponseEntity<>(presetService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TravelPresetDTO> get(@PathVariable(value = "id") Long id) {
        log.info("GET to /presets/{id}");
        TravelPresetDTO dto = presetService.findById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<TravelPresetDTO> saveTravel(@RequestBody TravelPresetDTO presetDTO){
        log.info("POST to /presets/");
        presetDTO = presetService.saveTravelPreset(presetDTO);
        return new ResponseEntity<>(presetDTO, HttpStatus.OK);
    }
}
