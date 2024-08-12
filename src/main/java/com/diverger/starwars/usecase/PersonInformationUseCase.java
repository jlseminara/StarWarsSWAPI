package com.diverger.starwars.usecase;

import com.diverger.starwars.domain.People;
import com.diverger.starwars.domain.PeopleSearchResult;
import com.diverger.starwars.infrastructure.adapter.out.cache.SwapiDataService;
import com.diverger.starwars.infrastructure.adapter.in.dto.StarWarsPersonInformation;
import com.diverger.starwars.infrastructure.adapter.in.exceptions.PersonNotFoundException;
import com.diverger.starwars.usecase.interfaces.PersonInformationUseCaseApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.diverger.starwars.infrastructure.adapter.in.dto.FilmData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.net.URI;


@Slf4j
@Service
public class PersonInformationUseCase implements PersonInformationUseCaseApi {

    private final SwapiDataService swapiDataService;

    @Autowired
    public PersonInformationUseCase(SwapiDataService swapiDataService) {
        this.swapiDataService = swapiDataService;
    }

    @Override
    public StarWarsPersonInformation getPersonInformation(String name) {
        log.info("PersonInformationUserCase:getPersonInformation, name={}", name);
        StarWarsPersonInformation personInfoResult = new StarWarsPersonInformation();

        PeopleSearchResult findPersonResult = swapiDataService.findPerson(name);

        if(findPersonResult==null || findPersonResult.getCount()==0)
            throw new PersonNotFoundException("Person with name '" +name+ "' cannot be found");

        //No specifications about what to do when receiving more that one result
        People personFound = findPersonResult.getResults().getFirst();

        personInfoResult.setName(personFound.getName());
        personInfoResult.setBirthYear(personFound.getBirthYear());
        personInfoResult.setGender(personFound.getGender());
        personInfoResult.setPlanetName(swapiDataService.getPlanetName(personFound.getHomeworld()));
        personInfoResult.setFastestVehicleDriven(this.getFastestVehicle(personFound.getVehicles()));
        personInfoResult.setFilms(this.getFilmsComponent(personFound.getFilms()));

        return personInfoResult;
    }


    private List<FilmData> getFilmsComponent(List<URI> filmURIList) {
        log.info("PersonInformationUserCase:getFilmsComponent");
        List<FilmData> filmList = new ArrayList<>();

        if(filmURIList==null || filmURIList.isEmpty())
            return filmList;

        for(URI filmResource : filmURIList) {
            var filmResult = swapiDataService.getFilmInformation(filmResource);

            if(filmResult!=null)
                filmList.add(new FilmData().name(filmResult.getTitle()).releaseDate(filmResult.getReleaseDate()));
        }

        return filmList;
    }

    private String getFastestVehicle(List<URI> vehiclesUri) {
        log.info("PersonInformationUserCase:getFastestVehicle");
        Map<String, Double> mapVehicles = new HashMap<>();

        if(vehiclesUri==null || vehiclesUri.isEmpty())
            return null;

        for(URI resource : vehiclesUri) {
            var vehicle = swapiDataService.getVehicleInformation(resource);
            if (vehicle != null)
                mapVehicles.put(vehicle.getName(), Double.parseDouble(vehicle.getMaxAtmospheringSpeed()));
        }
        var fastest = mapVehicles.entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null);

        return (fastest == null) ? null : fastest.getKey();
    }

}
