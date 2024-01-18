package ru.prepare2travel.prepare2travelserver.controller.handlers;


import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ApiExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleEntityNotFound(EntityNotFoundException ex){
        log.error(ex.getMessage());
        return new ResponseEntity<>(new ErrorDTO(HttpStatus.NOT_FOUND.value(), ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDTO> handleParsingException(HttpMessageNotReadableException ex){
        log.error(ex.getMessage());
        return new ResponseEntity<>(new ErrorDTO(HttpStatus.BAD_REQUEST.value(), ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleUsernameNotFoundException(UsernameNotFoundException ex){
        log.error(ex.getMessage());
        return new ResponseEntity<>(new ErrorDTO(HttpStatus.BAD_REQUEST.value(), ex.getMessage()), HttpStatus.NOT_FOUND);
    }

}

@Data @AllArgsConstructor
class ErrorDTO{
    private Integer code;
    private String msg;
}
