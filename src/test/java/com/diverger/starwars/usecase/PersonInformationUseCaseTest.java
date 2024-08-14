package com.diverger.starwars.usecase;

import com.diverger.starwars.domain.Film;
import com.diverger.starwars.domain.PeopleSearchResult;
import com.diverger.starwars.domain.Starship;
import com.diverger.starwars.domain.Vehicle;
import com.diverger.starwars.infrastructure.adapter.out.cache.SwapiDataService;
import com.diverger.starwars.infrastructure.adapter.out.exceptions.DataNotObtainableException;
import com.diverger.starwars.infrastructure.adapter.out.exceptions.PersonNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
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

        String planetName = "Some Planet";
        PeopleSearchResult searchResult =
                readGenericJsonMockFile("mock-results/swapi-dev-results/people-search-result.json", PeopleSearchResult.class);
        Film filmResult = readGenericJsonMockFile("mock-results/swapi-dev-results/film-result.json", Film.class);
        Vehicle vehicleResult = readGenericJsonMockFile("mock-results/swapi-dev-results/vehicle-result.json", Vehicle.class);
        Starship starshipResult = readGenericJsonMockFile("mock-results/swapi-dev-results/starship-result.json", Starship.class);

        when(swapiDataService.findPerson(anyString())).thenReturn(searchResult);
        when(swapiDataService.getPlanetName(any())).thenReturn(planetName);
        when(swapiDataService.getFilmInformation(any())).thenReturn(filmResult);
        when(swapiDataService.getStarshipInformation(any())).thenReturn(starshipResult);
        when(swapiDataService.getVehicleInformation(any())).thenReturn(vehicleResult);

        var finalResult = personInformationUseCase.getPersonInformation("Some-search-string");

        assertNotNull(finalResult);

        assertEquals(finalResult.getName(), searchResult.getResults().getFirst().getName());
        assertEquals(finalResult.getPlanetName(), planetName);
        assertEquals(finalResult.getBirthYear(), searchResult.getResults().getFirst().getBirthYear());
        assertEquals(finalResult.getGender(), searchResult.getResults().getFirst().getGender());
        assertEquals(finalResult.getFilms().size(), searchResult.getResults().getFirst().getFilms().size());
        assertEquals(finalResult.getFastestVehicleDriven(), starshipResult.getName());
    }

    @Test
    @DisplayName("Fails retrieving Person Information with Exception in SwapiDataService")
    void failsToRetrievePersonInformationWithException() {
        when(swapiDataService.findPerson(anyString())).thenThrow(new PersonNotFoundException("Failure"));

        RuntimeException expectedException = Assertions.assertThrows(RuntimeException.class, () ->
                personInformationUseCase.getPersonInformation("Some-search-string"));

        assertNotNull(expectedException);
        assertInstanceOf(PersonNotFoundException.class, expectedException);
    }

    @Test
    @DisplayName("Fails retrieving Films Information with Exception in SwapiDataService")
    void failsToRetrieveFilmsInformationWithException() {
        String planetName = "Some Planet";
        PeopleSearchResult searchResult =
                readGenericJsonMockFile("mock-results/swapi-dev-results/people-search-result.json", PeopleSearchResult.class);
        Film filmResult = readGenericJsonMockFile("mock-results/swapi-dev-results/film-result.json", Film.class);
        Vehicle vehicleResult = readGenericJsonMockFile("mock-results/swapi-dev-results/vehicle-result.json", Vehicle.class);
        Starship starshipResult = readGenericJsonMockFile("mock-results/swapi-dev-results/starship-result.json", Starship.class);

        when(swapiDataService.findPerson(anyString())).thenReturn(searchResult);
        when(swapiDataService.getPlanetName(any())).thenReturn(planetName);
        when(swapiDataService.getFilmInformation(any())).thenThrow(new DataNotObtainableException("failure", "field"));
        when(swapiDataService.getStarshipInformation(any())).thenReturn(starshipResult);
        when(swapiDataService.getVehicleInformation(any())).thenReturn(vehicleResult);

        RuntimeException expectedException = Assertions.assertThrows(RuntimeException.class, () ->
                personInformationUseCase.getPersonInformation("Some-search-string"));

        assertNotNull(expectedException);
        assertInstanceOf(DataNotObtainableException.class, expectedException);
    }


    @SneakyThrows
    public <T> T readGenericJsonMockFile(String filename, Class<T> type) {
        InputStream ioStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(filename);
        return objectMapper.readValue(ioStream, type);
    }
}
