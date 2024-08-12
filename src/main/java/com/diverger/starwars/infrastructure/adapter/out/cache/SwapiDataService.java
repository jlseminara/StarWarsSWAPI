package com.diverger.starwars.infrastructure.adapter.out.cache;

import com.diverger.starwars.domain.Film;
import com.diverger.starwars.domain.PeopleSearchResult;
import com.diverger.starwars.domain.Planet;
import com.diverger.starwars.domain.Vehicle;
import com.diverger.starwars.infrastructure.adapter.in.exceptions.FilmNotFoundException;
import com.diverger.starwars.infrastructure.adapter.in.exceptions.PersonNotFoundException;
import com.diverger.starwars.infrastructure.adapter.in.exceptions.PlanetNotFoundException;
import com.diverger.starwars.infrastructure.adapter.in.exceptions.VehicleNotFoundException;
import com.diverger.starwars.infrastructure.adapter.out.http.SwapiFeignClient;
import com.diverger.starwars.infrastructure.port.out.cache.SwapiDataApi;
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

    @Cacheable(cacheNames="FILMS", unless="#result == null")
    public Film getFilmInformation(URI filmUri) {
        Film result;

        try {
            result = restClient.get().uri(filmUri).retrieve().toEntity(Film.class).getBody();
        } catch (RuntimeException ex) {
            log.error("Error fetching film message={}", ex.getMessage());
            throw new FilmNotFoundException(ex.getMessage());
        }

        return result;
    }

    @Cacheable(cacheNames="PLANETS", unless="#result == null")
    public String getPlanetName(URI planetResource) {
        Planet result;

        try {
            result = restClient.get().uri(planetResource).retrieve().toEntity(Planet.class).getBody();
        } catch (RuntimeException ex) {
            log.error("Error fetching planet message={}", ex.getMessage());
            throw new PlanetNotFoundException(ex.getMessage());
        }

        if(result==null || result.getName().isBlank())
            return null;
        else
            return result.getName();
    }

    @Cacheable(cacheNames="VEHICLES", unless="#result == null")
    public Vehicle getVehicleInformation(URI vehicleUri) {
        Vehicle result;

        try {
            result = restClient.get().uri(vehicleUri).retrieve().toEntity(Vehicle.class).getBody();
        } catch (RuntimeException ex) {
            log.error("Error fetching person message={}", ex.getMessage());
            throw new VehicleNotFoundException(ex.getMessage());
        }

        return result;
    }

    @Cacheable(cacheNames="PEOPLE", unless="#result == null")
    public PeopleSearchResult findPerson(String name) {
        PeopleSearchResult result;

        try {
            result = swapiFeignClient.findPerson(name);
        } catch (RuntimeException ex) {
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
