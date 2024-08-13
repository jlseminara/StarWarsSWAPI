package com.diverger.starwars.infrastructure.port.out.cache;

import com.diverger.starwars.domain.Film;
import com.diverger.starwars.domain.PeopleSearchResult;
import com.diverger.starwars.domain.Starship;
import com.diverger.starwars.domain.Vehicle;

import java.net.URI;

public interface SwapiDataApi {

    Film getFilmInformation(URI filmUri);

    String getPlanetName(URI planetResource);

    PeopleSearchResult findPerson(String name);

    Vehicle getVehicleInformation(URI vehicleUri);

    Starship getStarshipInformation(URI starshipUri);
}
