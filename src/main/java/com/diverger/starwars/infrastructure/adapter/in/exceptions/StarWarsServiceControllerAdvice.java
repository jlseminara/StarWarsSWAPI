package com.diverger.starwars.infrastructure.adapter.in.exceptions;

import com.diverger.starwars.infrastructure.adapter.in.dto.ErrorResponse;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class StarWarsServiceControllerAdvice {

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ErrorResponse> handleFeignException(FeignException ex) {
        var body = new ErrorResponse()
                .status(ex.status())
                .title("Error connection to SWAPI server")
                .detail(ex.getMessage());

        return ResponseEntity.status(ex.status()).body(body);
    }

    @ExceptionHandler(FeignException.NotFound.class)
    public ResponseEntity<ErrorResponse> handleFeignException(FeignException.NotFound ex) {
        var body = new ErrorResponse()
                .status(ex.status())
                .title("Data not found")
                .detail(ex.getMessage());

        return ResponseEntity.status(ex.status()).body(body);
    }


    @ExceptionHandler(DataInconsistencyException.class)
    public ResponseEntity<ErrorResponse> handleDataInconsistencyException(DataInconsistencyException ex) {
        var body = new ErrorResponse()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .title("Error processing data")
                .detail(ex.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(body);
    }

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePersonNotFoundException(PersonNotFoundException ex) {
        var body = new ErrorResponse()
                .status(HttpStatus.NOT_FOUND.value())
                .title("Person not found")
                .detail(ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(body);
    }

    @ExceptionHandler(FilmNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleFilmNotFoundException(FilmNotFoundException ex) {
        var body = new ErrorResponse()
                .status(HttpStatus.NOT_FOUND.value())
                .title("Film not found")
                .detail(ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(body);
    }

    @ExceptionHandler(PlanetNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePlanetNotFoundException(PlanetNotFoundException ex) {
        var body = new ErrorResponse()
                .status(HttpStatus.NOT_FOUND.value())
                .title("Planet not found")
                .detail(ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(body);
    }

    @ExceptionHandler(VehicleNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleVehicleNotFoundException(VehicleNotFoundException ex) {
        var body = new ErrorResponse()
                .status(HttpStatus.NOT_FOUND.value())
                .title("Vehicle not found")
                .detail(ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(body);
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleUnexpectedException(RuntimeException ex) {
        var body = new ErrorResponse()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .title("Unexpected exception")
                .detail(ex.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(body);
    }

}
