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

    @ExceptionHandler(DataInconsistencyException.class)
    public ResponseEntity<ErrorResponse> handleFeignException(DataInconsistencyException ex) {
        var body = new ErrorResponse()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .title("Error processing data")
                .detail(ex.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(body);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex) {
        var body = new ErrorResponse()
                .status(500)
                .title("Internal Error. Unhandled error")
                .detail(ex.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(body);
    }

}
