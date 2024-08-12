package com.diverger.starwars.infrastructure.adapter.out;

import com.diverger.starwars.domain.Film;
import com.diverger.starwars.domain.FilmsSearchResult;
import com.diverger.starwars.domain.People;
import com.diverger.starwars.domain.PeopleSearchResult;
import com.diverger.starwars.domain.Planet;
import com.diverger.starwars.domain.Vehicle;
import com.diverger.starwars.domain.VehicleSearchResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "FacadeSwapiConsumer", url = "${spring.cloud.openfeign.client.swapi}")
public interface SwapiFeignClient {

    @GetMapping(value = "/people/{personId}")
    People getPerson(@PathVariable(name = "personId") String personId);

    @GetMapping(value = "/people/")
    PeopleSearchResult findPerson(@RequestParam(name = "search") String searchString);

    @GetMapping(value = "/vehicles/{vehicleId}")
    Vehicle getVehicle(@PathVariable(name = "vehicleId") String vehicleId);

    @GetMapping(value = "/vehicles/")
    VehicleSearchResult findVehicle(@RequestParam(name = "search") String searchString);

    @GetMapping(value = "/films/{filmId}")
    Film getFilm(@PathVariable(name = "filmId") String filmId);

    @GetMapping(value = "/films/")
    FilmsSearchResult findFilm(@RequestParam(name = "search") String searchString);

    @GetMapping(value = "/planets/{planetId}")
    Planet getPlanet(@RequestParam(name = "planetId") String planetId);
}
