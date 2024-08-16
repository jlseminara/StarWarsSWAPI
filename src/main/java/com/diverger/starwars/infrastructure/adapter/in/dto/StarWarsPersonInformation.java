package com.diverger.starwars.infrastructure.adapter.in.dto;

import java.net.URI;
import java.util.Objects;
import com.diverger.starwars.infrastructure.adapter.in.dto.FilmData;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;
import javax.annotation.Generated;

/**
 * StarWarsPersonInformation
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-16T16:43:15.075699+02:00[Europe/Paris]", comments = "Generator version: 7.7.0")
public class StarWarsPersonInformation {

  private String name;

  private String birthYear;

  private String gender;

  private String planetName;

  private String fastestVehicleDriven;

  @Valid
  private List<@Valid FilmData> films = new ArrayList<>();

  public StarWarsPersonInformation name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public StarWarsPersonInformation birthYear(String birthYear) {
    this.birthYear = birthYear;
    return this;
  }

  /**
   * Get birthYear
   * @return birthYear
   */
  
  @JsonProperty("birth_year")
  public String getBirthYear() {
    return birthYear;
  }

  public void setBirthYear(String birthYear) {
    this.birthYear = birthYear;
  }

  public StarWarsPersonInformation gender(String gender) {
    this.gender = gender;
    return this;
  }

  /**
   * Get gender
   * @return gender
   */
  
  @JsonProperty("gender")
  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public StarWarsPersonInformation planetName(String planetName) {
    this.planetName = planetName;
    return this;
  }

  /**
   * Get planetName
   * @return planetName
   */
  
  @JsonProperty("planet_name")
  public String getPlanetName() {
    return planetName;
  }

  public void setPlanetName(String planetName) {
    this.planetName = planetName;
  }

  public StarWarsPersonInformation fastestVehicleDriven(String fastestVehicleDriven) {
    this.fastestVehicleDriven = fastestVehicleDriven;
    return this;
  }

  /**
   * Get fastestVehicleDriven
   * @return fastestVehicleDriven
   */
  
  @JsonProperty("fastest_vehicle_driven")
  public String getFastestVehicleDriven() {
    return fastestVehicleDriven;
  }

  public void setFastestVehicleDriven(String fastestVehicleDriven) {
    this.fastestVehicleDriven = fastestVehicleDriven;
  }

  public StarWarsPersonInformation films(List<@Valid FilmData> films) {
    this.films = films;
    return this;
  }

  public StarWarsPersonInformation addFilmsItem(FilmData filmsItem) {
    if (this.films == null) {
      this.films = new ArrayList<>();
    }
    this.films.add(filmsItem);
    return this;
  }

  /**
   * Get films
   * @return films
   */
  @Valid 
  @JsonProperty("films")
  public List<@Valid FilmData> getFilms() {
    return films;
  }

  public void setFilms(List<@Valid FilmData> films) {
    this.films = films;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StarWarsPersonInformation starWarsPersonInformation = (StarWarsPersonInformation) o;
    return Objects.equals(this.name, starWarsPersonInformation.name) &&
        Objects.equals(this.birthYear, starWarsPersonInformation.birthYear) &&
        Objects.equals(this.gender, starWarsPersonInformation.gender) &&
        Objects.equals(this.planetName, starWarsPersonInformation.planetName) &&
        Objects.equals(this.fastestVehicleDriven, starWarsPersonInformation.fastestVehicleDriven) &&
        Objects.equals(this.films, starWarsPersonInformation.films);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, birthYear, gender, planetName, fastestVehicleDriven, films);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StarWarsPersonInformation {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    birthYear: ").append(toIndentedString(birthYear)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    planetName: ").append(toIndentedString(planetName)).append("\n");
    sb.append("    fastestVehicleDriven: ").append(toIndentedString(fastestVehicleDriven)).append("\n");
    sb.append("    films: ").append(toIndentedString(films)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

