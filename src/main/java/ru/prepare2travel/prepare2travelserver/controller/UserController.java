package ru.prepare2travel.prepare2travelserver.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.prepare2travel.prepare2travelserver.model.dto.TravelDTO;
import ru.prepare2travel.prepare2travelserver.model.dto.UserDTO;
import ru.prepare2travel.prepare2travelserver.service.TravelService;
import ru.prepare2travel.prepare2travelserver.service.UserService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
@Tag(name = "Users API")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TravelService travelService;

    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable(value = "username") String username){
        log.info("GET to /users/{username}");
        UserDTO dto = userService.getUserByUsername(username);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        log.info("GET to /users/all");
        List<UserDTO> dtos = userService.findAll();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping("/{username}/addTravel")
    public ResponseEntity<TravelDTO> getUserByUsername(@PathVariable(value = "username") String username,
                                                     @RequestBody TravelDTO travelDTO){
        log.info("POST to users/{username}/addTravel");
        UserDTO userDTO = userService.getUserByUsername(username);
        travelDTO.setOwnerId(userDTO.getId());
        travelDTO = travelService.saveTravel(travelDTO);
        return new ResponseEntity<>(travelDTO, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
        log.info("POST to /users/");
        userDTO = userService.save(userDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
}
