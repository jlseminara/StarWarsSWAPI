package com.diverger.starwars.infrastructure.adapter.out.cache;

import com.diverger.starwars.domain.Film;
import com.diverger.starwars.domain.PeopleSearchResult;
import com.diverger.starwars.domain.Planet;
import com.diverger.starwars.domain.Starship;
import com.diverger.starwars.domain.Vehicle;
import com.diverger.starwars.infrastructure.adapter.out.exceptions.FilmNotFoundException;
import com.diverger.starwars.infrastructure.adapter.out.exceptions.PersonNotFoundException;
import com.diverger.starwars.infrastructure.adapter.out.exceptions.PlanetNotFoundException;
import com.diverger.starwars.infrastructure.adapter.out.exceptions.StarshipNotFoundException;
import com.diverger.starwars.infrastructure.adapter.out.exceptions.VehicleNotFoundException;
import com.diverger.starwars.infrastructure.adapter.out.http.SwapiFeignClient;
import com.diverger.starwars.infrastructure.port.out.cache.SwapiDataApi;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import java.net.URI;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class SwapiDataService implements SwapiDataApi {
    private final SwapiFeignClient swapiFeignClient;
    private final RestClient restClient;

    @Autowired
    public SwapiDataService(SwapiFeignClient swapiFeignClient) {
        this.swapiFeignClient = swapiFeignClient;
        this.restClient = RestClient.builder().build();
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
            throw new FilmNotFoundException(ex.getMessage());
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
            throw new PlanetNotFoundException(ex.getMessage());
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
            throw new VehicleNotFoundException(ex.getMessage());
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
            throw new StarshipNotFoundException(ex.getMessage());
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
        } catch (RuntimeException ex) {     //TODO: Bad practice to catch Runtime, better to refine them but this is Q&D
            log.error("Error fetching person name={}, message={}", name, ex.getMessage());
            throw new PersonNotFoundException(ex.getMessage());
        }

        return result;
    }


    //TODO: Borrar esto despues de las pruebas
    @Deprecated
    private Optional<String> getFastestVehicleOld(List<URI> vehiclesUri) {
        String fastestVehicle = null;
        double vehicleSpeed = 0;

        if(vehiclesUri==null || vehiclesUri.isEmpty())
            return Optional.empty();

        for(URI resource : vehiclesUri) {
            Vehicle vehicle = restClient.get().uri(resource).retrieve().toEntity(Vehicle.class).getBody();

            if(vehicle!=null) {
                double speed = Double.parseDouble(vehicle.getMaxAtmospheringSpeed());
                if (speed > vehicleSpeed) {
                    vehicleSpeed = speed;
                    fastestVehicle = vehicle.getName();
                }
            }
        }

        return Optional.ofNullable(fastestVehicle);
    }

}
