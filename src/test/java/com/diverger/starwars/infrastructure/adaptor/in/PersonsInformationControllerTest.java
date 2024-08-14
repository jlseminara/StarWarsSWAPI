package com.diverger.starwars.infrastructure.adaptor.in;

import com.diverger.starwars.StarwarsApplication;
import com.diverger.starwars.infrastructure.adapter.in.dto.StarWarsPersonInformation;
import com.diverger.starwars.infrastructure.adapter.in.http.PersonsInformationController;
import com.diverger.starwars.usecase.PersonInformationUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.io.InputStream;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@AutoConfigureMockMvc
@ContextConfiguration(classes = StarwarsApplication.class)
@SpringBootTest(classes = PersonsInformationController.class)
public class PersonsInformationControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonInformationUseCase personInformationUseCase;

    //@Test
    @DisplayName("Retrieve Person Information OK (200)")
    void getCaseReturnsOk() {
        StarWarsPersonInformation result = readGenericJsonMockFile("mock-results/service-results/person-information-result.json", StarWarsPersonInformation.class);
        when(personInformationUseCase.getPersonInformation(anyString())).thenReturn(result);
    }

    @SneakyThrows
    public <T> T readGenericJsonMockFile(String filename, Class<T> type) {
        InputStream ioStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(filename);
        return objectMapper.readValue(ioStream, type);
    }
}
