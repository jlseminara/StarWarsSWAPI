package com.diverger.starwars.infrastructure.adapter.in.cache;

import com.diverger.starwars.domain.Film;
import com.diverger.starwars.domain.People;
import com.diverger.starwars.domain.PeopleSearchResult;
import com.diverger.starwars.domain.Planet;
import com.diverger.starwars.domain.Vehicle;
import com.diverger.starwars.infrastructure.adapter.out.SwapiFeignClient;
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
public class SwapiDataService {
    private final SwapiFeignClient swapiFeignClient;
    private final RestClient restClient;

    @Autowired
    public SwapiDataService(SwapiFeignClient swapiFeignClient) {
        this.swapiFeignClient = swapiFeignClient;
        this.restClient = RestClient.builder().build();
    }

    @Cacheable(cacheNames="FILMS", unless="#result == null")
    public Film getFilmInformation(URI filmUri) {
        return restClient.get().uri(filmUri).retrieve().toEntity(Film.class).getBody();
    }

    @Cacheable(cacheNames="PLANETS", unless="#result == null")
    public String getPlanetName(URI planetResource) {
        var planetResult = restClient.get().uri(planetResource).retrieve().toEntity(Planet.class).getBody();

        if(planetResult==null || !planetResult.getName().isBlank())
            return null;
        else
            return planetResult.getName();
    }

    @Cacheable(cacheNames="VEHICLES", unless="#result == null")
    public Vehicle getVehicleInformation(URI vehicleUri) {
        return restClient.get().uri(vehicleUri).retrieve().toEntity(Vehicle.class).getBody();
    }

    @Cacheable(cacheNames="PEOPLE", unless="#result == null")
    public PeopleSearchResult findPerson(String name) {
        return swapiFeignClient.findPerson(name);
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
