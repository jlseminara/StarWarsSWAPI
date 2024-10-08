package com.diverger.starwars.infrastructure.adapter.out.cache;

import com.diverger.starwars.domain.Film;
import com.diverger.starwars.domain.PeopleSearchResult;
import com.diverger.starwars.domain.Planet;
import com.diverger.starwars.domain.Starship;
import com.diverger.starwars.domain.Vehicle;
import com.diverger.starwars.infrastructure.adapter.out.exceptions.DataNotObtainableException;
import com.diverger.starwars.infrastructure.adapter.out.exceptions.PersonNotFoundException;
import com.diverger.starwars.infrastructure.adapter.out.http.SwapiFeignClient;
import com.diverger.starwars.infrastructure.port.out.cache.SwapiDataApi;
import feign.FeignException;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import java.net.URI;


@Slf4j
@Service
public class SwapiDataService implements SwapiDataApi {
    private final SwapiFeignClient swapiFeignClient;
    private final RestClient restClient;

    @Autowired
    public SwapiDataService(SwapiFeignClient swapiFeignClient, RestClient restClient) {
        this.swapiFeignClient = swapiFeignClient;
        this.restClient = restClient;
    }

    @Override
    @Cacheable(cacheNames="FILMS", unless="#result == null")
    @Retry(name = "General")
    public Film getFilmInformation(URI filmUri) {
        Film result;

        try {
            result = restClient.get().uri(filmUri).retrieve().toEntity(Film.class).getBody();
        } catch (RuntimeException ex) { //TODO: Bad practice to catch Runtime, better to refine them but this is Q&D
            log.error("Error fetching film message={}", ex.getMessage());
            throw new DataNotObtainableException(ex.getMessage(), "Film");
        }

        return result;
    }

    @Override
    @Cacheable(cacheNames="PLANETS", unless="#result == null")
    @Retry(name = "General")
    public String getPlanetName(URI planetResource) {
        Planet result;

        try {
            result = restClient.get().uri(planetResource).retrieve().toEntity(Planet.class).getBody();
        } catch (RuntimeException ex) { //TODO: Bad practice to catch Runtime, better to refine them but this is Q&D
            log.error("Error fetching planet message={}", ex.getMessage());
            throw new DataNotObtainableException(ex.getMessage(), "Planet");
        }

        if(result==null || result.getName().isBlank())
            return null;
        else
            return result.getName();
    }

    @Override
    @Cacheable(cacheNames="VEHICLES", unless="#result == null")
    @Retry(name = "General")
    public Vehicle getVehicleInformation(URI vehicleUri) {
        Vehicle result;

        try {
            result = restClient.get().uri(vehicleUri).retrieve().toEntity(Vehicle.class).getBody();
        } catch (RuntimeException ex) { //TODO: Bad practice to catch Runtime, better to refine them but this is Q&D
            log.error("Error fetching vehicle message={}", ex.getMessage());
            throw new DataNotObtainableException(ex.getMessage(), "Vehicle");
        }

        return result;
    }

    @Override
    @Cacheable(cacheNames="STARSHIPS", unless="#result == null")
    @Retry(name = "General")
    public Starship getStarshipInformation(URI starshipUri) {
        Starship result;

        try {
            result = restClient.get().uri(starshipUri).retrieve().toEntity(Starship.class).getBody();
        } catch (RuntimeException ex) { //TODO: Bad practice to catch Runtime, better to refine them but this is Q&D
            log.error("Error fetching starship message={}", ex.getMessage());
            throw new DataNotObtainableException(ex.getMessage(), "Starship");
        }

        return result;
    }

    @Override
    @Cacheable(cacheNames="PEOPLE", unless="#result == null")
    @Retry(name = "General")
    public PeopleSearchResult findPerson(String name) {
        PeopleSearchResult result;

        try {
            result = swapiFeignClient.findPerson(name);
        } catch (FeignException ex) {     //TODO: Bad practice to catch Runtime, better to refine them but this is Q&D
            log.error("Error fetching person name={}, message={}", name, ex.getMessage());
            throw new PersonNotFoundException(ex.getMessage());
        }

        return result;
    }

}
