package com.diverger.starwars.infrastructure.port.out.cache;

import com.diverger.starwars.domain.Film;
import com.diverger.starwars.domain.PeopleSearchResult;

import java.net.URI;

public interface SwapiDataApi {

    Film getFilmInformation(URI filmUri);

    String getPlanetName(URI planetResource);

    PeopleSearchResult findPerson(String name);
}
