package com.diverger.starwars.usecase;

import com.diverger.starwars.domain.Film;
import com.diverger.starwars.domain.PeopleSearchResult;
import com.diverger.starwars.domain.Planet;
import com.diverger.starwars.domain.Vehicle;
import com.diverger.starwars.infrastructure.adapter.out.cache.SwapiDataService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.InputStream;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@SpringBootTest
public class PersonInformationUseCaseTest {

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private SwapiDataService swapiDataService;

    @Autowired
    private PersonInformationUseCase personInformationUseCase;

    @Test
    @DisplayName("Retrieve Person Information correctly")
    void retrievePersonInformationCorrectly() {
        PeopleSearchResult searchResult =
                readGenericJsonMockFile("mock-results/people-search-multiple-result.json", PeopleSearchResult.class);

        Film filmResult = readGenericJsonMockFile("mock-results/film-result.json", Film.class);

        Planet planetResult = readGenericJsonMockFile("mock-results/planet-result.json", Planet.class);

        Vehicle vehicleResult = readGenericJsonMockFile("mock-results/vehicle-result.json", Vehicle.class);

        when(swapiDataService.findPerson(anyString())).thenReturn(searchResult);

        System.out.println(searchResult.toString());
        System.out.println(filmResult.toString());
        System.out.println(planetResult.toString());
        System.out.println(vehicleResult.toString());
    }

    @SneakyThrows
    public <T> T readGenericJsonMockFile(String filename, Class<T> type) {
        InputStream ioStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(filename);
        return objectMapper.readValue(ioStream, type);
    }
}
