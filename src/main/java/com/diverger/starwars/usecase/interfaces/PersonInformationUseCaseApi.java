package com.diverger.starwars.usecase.interfaces;

import com.diverger.starwars.infrastructure.adapter.in.dto.StarWarsPersonInformation;

public interface PersonInformationUseCaseApi {

    StarWarsPersonInformation getPersonInformation(String name);

}
