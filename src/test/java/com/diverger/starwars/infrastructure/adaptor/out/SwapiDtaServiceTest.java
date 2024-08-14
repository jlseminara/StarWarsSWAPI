package com.diverger.starwars.infrastructure.adaptor.out;

import com.diverger.starwars.domain.Film;
import com.diverger.starwars.infrastructure.adapter.out.cache.SwapiDataService;
import com.diverger.starwars.infrastructure.adapter.out.exceptions.DataNotObtainableException;
import com.diverger.starwars.infrastructure.adapter.out.http.SwapiFeignClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;
import java.io.InputStream;
import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
    private SwapiDataService swapiDataService;

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

    //@Test
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



    @SneakyThrows
    public <T> T readGenericJsonMockFile(String filename, Class<T> type) {
        InputStream ioStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(filename);
        return objectMapper.readValue(ioStream, type);
    }
}
