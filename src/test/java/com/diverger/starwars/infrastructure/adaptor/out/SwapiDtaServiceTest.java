package com.diverger.starwars.infrastructure.adaptor.out;

import com.diverger.starwars.domain.Film;
import com.diverger.starwars.domain.PeopleSearchResult;
import com.diverger.starwars.domain.Planet;
import com.diverger.starwars.domain.Starship;
import com.diverger.starwars.domain.Vehicle;
import com.diverger.starwars.infrastructure.adapter.out.cache.SwapiDataService;
import com.diverger.starwars.infrastructure.adapter.out.exceptions.DataNotObtainableException;
import com.diverger.starwars.infrastructure.adapter.out.exceptions.PersonNotFoundException;
import com.diverger.starwars.infrastructure.adapter.out.http.SwapiFeignClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import feign.Request;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockReset;
import org.springframework.cache.CacheManager;
import org.springframework.cache.support.NoOpCacheManager;
import org.springframework.http.HttpStatusCode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;
import java.io.InputStream;
import java.net.URI;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;


@SpringBootTest
public class SwapiDtaServiceTest {

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private SwapiFeignClient swapiFeignClient;

    @MockBean(answer = Answers.RETURNS_DEEP_STUBS)
    private RestClient restClient;

    @Autowired
    @InjectMocks
    private SwapiDataService swapiDataService;


    @Test
    @SneakyThrows
    @DisplayName("Fails to retrieve Planet Information with Exception")
    void failsToRetrievePlanetInformationWithException() {
        HttpClientErrorException mockException = new HttpClientErrorException(HttpStatusCode.valueOf(500));

        when(restClient.get().uri(any(URI.class)).retrieve().toEntity(Planet.class).getBody())
                .thenThrow(mockException);

        RuntimeException expectedException = Assertions.assertThrows(RuntimeException.class, () ->{
            swapiDataService.getPlanetName(URI.create("http://dummy.com"));
        });

        assertNotNull(expectedException);
        assertInstanceOf(DataNotObtainableException.class, expectedException);
    }


    @Test
    @SneakyThrows
    @DisplayName("Fails to retrieve Starship Information with Exception")
    void failsToRetrieveStarshipInformationWithException() {
        HttpClientErrorException mockException = new HttpClientErrorException(HttpStatusCode.valueOf(500));

        when(restClient.get().uri(any(URI.class)).retrieve().toEntity(Starship.class).getBody())
                .thenThrow(mockException);

        RuntimeException expectedException = Assertions.assertThrows(RuntimeException.class, () ->
                swapiDataService.getStarshipInformation(URI.create("http://dummy.com")));

        assertNotNull(expectedException);
        assertInstanceOf(DataNotObtainableException.class, expectedException);
    }


    @Test
    @SneakyThrows
    @DisplayName("Fails to retrieve Vehicle Information with Exception")
    void failsToRetrieveVehicleInformationWithException() {
        HttpClientErrorException mockException = new HttpClientErrorException(HttpStatusCode.valueOf(500));

        when(restClient.get().uri(any(URI.class)).retrieve().toEntity(Vehicle.class).getBody())
                .thenThrow(mockException);

        RuntimeException expectedException = Assertions.assertThrows(RuntimeException.class, () ->
                swapiDataService.getVehicleInformation(URI.create("http://dummy.com")));

        assertNotNull(expectedException);
        assertInstanceOf(DataNotObtainableException.class, expectedException);
    }


    @Test
    @SneakyThrows
    @DisplayName("Fails to retrieve List of People details with Exception")
    void failsToRetrieveListOfPersonsDetailsWithException() {
        Request request = Request.create(Request.HttpMethod.GET, "/something", new java.util.HashMap<>(), new byte[0], null, null);
        FeignException feignException = new FeignException.NotFound("Not Found", request, new byte[0], new java.util.HashMap<>());


        when(swapiFeignClient.findPerson(anyString())).thenThrow(feignException);

        RuntimeException expectedException = Assertions.assertThrows(RuntimeException.class, () ->
                swapiDataService.findPerson("some-name"));

        assertNotNull(expectedException);
        assertInstanceOf(PersonNotFoundException.class, expectedException);
    }

    @Test
    @SneakyThrows
    @DisplayName("Fails to retrieve Film Information with Exception")
    void failsToRetrieveFilmInformationWithException() {
        HttpClientErrorException mockException = new HttpClientErrorException(HttpStatusCode.valueOf(500));

        when(restClient.get().uri(any(URI.class)).retrieve().toEntity(Film.class).getBody())
                .thenThrow(mockException);

        RuntimeException expectedException = Assertions.assertThrows(RuntimeException.class, () ->
                swapiDataService.getFilmInformation(URI.create("http://dummy.com")));

        assertNotNull(expectedException);
        assertInstanceOf(DataNotObtainableException.class, expectedException);
    }

    @Test
    @SneakyThrows
    @DisplayName("Retrieve List of People details correctly")
    void retrieveListOfPeopleDetails() {
        PeopleSearchResult mockedFindPeopleResult = readGenericJsonMockFile(
                "mock-results/swapi-dev-results/people-search-multiple-result.json", PeopleSearchResult.class);

        when(swapiFeignClient.findPerson(anyString())).thenReturn(mockedFindPeopleResult);

        var obtainedPersons = swapiDataService.findPerson("some-name");

        assertNotNull(obtainedPersons);
        assertEquals(obtainedPersons.getResults().size(), 2);
        assertEquals(obtainedPersons.getResults().getFirst().getName(), "Leia Organa");
    }

    @Test
    @SneakyThrows
    @DisplayName("Retrieve Film Information correctly")
    void retrieveFilmInformation() {
        Film mockedFilm = readGenericJsonMockFile("mock-results/swapi-dev-results/film-result.json", Film.class);

        when(restClient.get().uri(any(URI.class)).retrieve().toEntity(Film.class).getBody())
                .thenReturn(mockedFilm);

        var obtainedFilm = swapiDataService.getFilmInformation(URI.create("http://dummy.com"));

        assertNotNull(obtainedFilm);
        assertEquals(obtainedFilm.getTitle(), mockedFilm.getTitle());
    }


    @Test
    @SneakyThrows
    @DisplayName("Retrieve Vehicle Information correctly")
    void retrieveVehicleInformation() {
        Vehicle mockedVehicle = readGenericJsonMockFile("mock-results/swapi-dev-results/vehicle-result.json", Vehicle.class);

        when(restClient.get().uri(any(URI.class)).retrieve().toEntity(Vehicle.class).getBody())
                .thenReturn(mockedVehicle);

        var obtainedVehicle = swapiDataService.getVehicleInformation(URI.create("http://dummy.com"));

        assertNotNull(obtainedVehicle);
        assertEquals(obtainedVehicle.getName(), mockedVehicle.getName());
    }

    @Test
    @SneakyThrows
    @DisplayName("Retrieve Starship Information correctly")
    void retrieveStarshipInformation() {
        Starship mockedStarship = readGenericJsonMockFile("mock-results/swapi-dev-results/starship-result.json", Starship.class);

        when(restClient.get().uri(any(URI.class)).retrieve().toEntity(Starship.class).getBody())
                .thenReturn(mockedStarship);

        var obtainedStarship = swapiDataService.getStarshipInformation(URI.create("http://dummy.com"));

        assertNotNull(obtainedStarship);
        assertEquals(obtainedStarship.getName(), mockedStarship.getName());
    }

    @Test
    @SneakyThrows
    @DisplayName("Retrieve Planet Information correctly")
    void retrievePlanetInformation() {
        Planet mockedPlanet = readGenericJsonMockFile("mock-results/swapi-dev-results/planet-result.json", Planet.class);

        when(restClient.get().uri(any(URI.class)).retrieve().toEntity(Planet.class).getBody())
                .thenReturn(mockedPlanet);

        var planetName = swapiDataService.getPlanetName(URI.create("http://dummy.com"));

        assertNotNull(planetName);
        assertEquals(planetName, mockedPlanet.getName());
    }


    @SneakyThrows
    public <T> T readGenericJsonMockFile(String filename, Class<T> type) {
        InputStream ioStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(filename);
        return objectMapper.readValue(ioStream, type);
    }

}
