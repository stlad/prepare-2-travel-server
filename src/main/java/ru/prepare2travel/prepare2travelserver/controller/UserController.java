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

    @PostMapping("/{username}/addTravel")
    public ResponseEntity<TravelDTO> getUserByUsername(@PathVariable(value = "username") String username,
                                                     @RequestBody TravelDTO travelDTO){
        log.info("POST to /{username}/addTravel");
        UserDTO userDTO = userService.getUserByUsername(username);
        travelDTO.setOwnerId(userDTO.getId());
        travelDTO = travelService.saveTravel(travelDTO);
        return new ResponseEntity<>(travelDTO, HttpStatus.OK);
    }
}
