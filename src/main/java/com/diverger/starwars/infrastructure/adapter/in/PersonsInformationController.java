package com.diverger.starwars.infrastructure.adapter.in;

import com.diverger.starwars.infrastructure.adapter.in.dto.StarWarsPersonInformation;
import com.diverger.starwars.infrastructure.port.in.StarWarsServiceApi;
import com.diverger.starwars.usecase.PersonInformationUseCase;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class PersonsInformationController implements StarWarsServiceApi {

    private final PersonInformationUseCase personInformationUseCase;

    @Autowired
    public PersonsInformationController(PersonInformationUseCase personInformationUseCase) {
        this.personInformationUseCase = personInformationUseCase;
    }

    @CircuitBreaker(name = "CircuitBreakerGeneral")
    @Override
    public ResponseEntity<StarWarsPersonInformation> getPersonInformation(String name) {
        log.info("Request to get person information, name={}", name);

        return ResponseEntity.ok(personInformationUseCase.getPersonInformation(name));
    }

}
