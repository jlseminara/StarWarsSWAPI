package com.diverger.starwars.integration.cucumberGlues;

import com.diverger.starwars.infrastructure.adapter.in.dto.StarWarsPersonInformation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonInformationSteps {
    @LocalServerPort
    String port;

    private final RestTemplate restTemplate = new RestTemplate();
    private ResponseEntity<StarWarsPersonInformation> obtainedResponse;
    private HttpClientErrorException httpException;

    @BeforeEach
    public void setup() {
        httpException = null;
        obtainedResponse = null;
    }

    @Given("I'm online")
    public void givenMyOnline() {
        ResponseEntity<String> googleResponse = restTemplate.exchange("http://www.google.com", HttpMethod.GET,
                null, String.class);

        assertTrue(googleResponse.getStatusCode().is2xxSuccessful());
    }

    @When("I specify the name {string}")
    public void whenISpecifyTheName(String name) {
        httpException = null;
        obtainedResponse = null;
        String encodedName;

        encodedName = URLEncoder.encode(name, StandardCharsets.UTF_8);

        try {
            obtainedResponse = restTemplate.exchange("http://localhost:" + port +
                    "/swapi-proxy/person-info?name=" + encodedName, HttpMethod.GET, null, StarWarsPersonInformation.class);
        } catch (HttpClientErrorException ex) {
            httpException = ex;
        }
    }

    @Then("I get the full name {string}")
    public void thenIGetTheFullName(String expectedFullName) {
        assertTrue(obtainedResponse.getStatusCode().is2xxSuccessful());
        assertNotNull(obtainedResponse.getBody());

        assertEquals(expectedFullName, obtainedResponse.getBody().getName());
    }

    @And("the gender is {string}")
    public void andTheGenderIs(String gender) {
        assertNotNull(obtainedResponse.getBody());
        assertEquals(gender, obtainedResponse.getBody().getGender());
    }

    @Then("I get an error Not Found")
    public void thenIGetAnErrorNotFound() {
        assertEquals(httpException.getStatusCode().value(), HttpStatus.NOT_FOUND.value());
    }

}
