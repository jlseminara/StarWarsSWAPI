package com.diverger.starwars.domain;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.net.URI;
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
 * A Starship
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-16T16:40:28.350912800+02:00[Europe/Paris]", comments = "Generator version: 7.7.0")
public class Starship {

  private String name;

  private String model;

  private String starshipClass;

  private String manufacturer;

  private String costInCredits;

  private String length;

  private String crew;

  private String passengers;

  private String maxAtmospheringSpeed;

  private String hyperdriveRating;

  private String MGLT;

  private String cargoCapacity;

  private String consumables;

  @Valid
  private List<URI> films = new ArrayList<>();

  @Valid
  private List<URI> pilots = new ArrayList<>();

  private URI url;

  private String created;

  private String edited;

  public Starship name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of this starship. The common name, such as Death Star.
   * @return name
   */
  
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Starship model(String model) {
    this.model = model;
    return this;
  }

  /**
   * The model or official name of this starship. Such as T-65 X-wing or DS-1 Orbital Battle Station.
   * @return model
   */
  
  @JsonProperty("model")
  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Starship starshipClass(String starshipClass) {
    this.starshipClass = starshipClass;
    return this;
  }

  /**
   * The class of this starship, such as Starfighter or Deep Space Mobile Battlestation.
   * @return starshipClass
   */
  
  @JsonProperty("starship_class")
  public String getStarshipClass() {
    return starshipClass;
  }

  public void setStarshipClass(String starshipClass) {
    this.starshipClass = starshipClass;
  }

  public Starship manufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
    return this;
  }

  /**
   * The manufacturer of this starship. Comma seperated if more than one.
   * @return manufacturer
   */
  
  @JsonProperty("manufacturer")
  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public Starship costInCredits(String costInCredits) {
    this.costInCredits = costInCredits;
    return this;
  }

  /**
   * The cost of this starship new, in galactic credits.
   * @return costInCredits
   */
  
  @JsonProperty("cost_in_credits")
  public String getCostInCredits() {
    return costInCredits;
  }

  public void setCostInCredits(String costInCredits) {
    this.costInCredits = costInCredits;
  }

  public Starship length(String length) {
    this.length = length;
    return this;
  }

  /**
   * The length of this starship in meters.
   * @return length
   */
  
  @JsonProperty("length")
  public String getLength() {
    return length;
  }

  public void setLength(String length) {
    this.length = length;
  }

  public Starship crew(String crew) {
    this.crew = crew;
    return this;
  }

  /**
   * The number of personnel needed to run or pilot this starship.
   * @return crew
   */
  
  @JsonProperty("crew")
  public String getCrew() {
    return crew;
  }

  public void setCrew(String crew) {
    this.crew = crew;
  }

  public Starship passengers(String passengers) {
    this.passengers = passengers;
    return this;
  }

  /**
   * The number of non-essential people this starship can transport.
   * @return passengers
   */
  
  @JsonProperty("passengers")
  public String getPassengers() {
    return passengers;
  }

  public void setPassengers(String passengers) {
    this.passengers = passengers;
  }

  public Starship maxAtmospheringSpeed(String maxAtmospheringSpeed) {
    this.maxAtmospheringSpeed = maxAtmospheringSpeed;
    return this;
  }

  /**
   * The maximum speed of this starship in atmosphere. n/a if this starship is incapable of atmosphering flight.
   * @return maxAtmospheringSpeed
   */
  
  @JsonProperty("max_atmosphering_speed")
  public String getMaxAtmospheringSpeed() {
    return maxAtmospheringSpeed;
  }

  public void setMaxAtmospheringSpeed(String maxAtmospheringSpeed) {
    this.maxAtmospheringSpeed = maxAtmospheringSpeed;
  }

  public Starship hyperdriveRating(String hyperdriveRating) {
    this.hyperdriveRating = hyperdriveRating;
    return this;
  }

  /**
   * The class of this starships hyperdrive.
   * @return hyperdriveRating
   */
  
  @JsonProperty("hyperdrive_rating")
  public String getHyperdriveRating() {
    return hyperdriveRating;
  }

  public void setHyperdriveRating(String hyperdriveRating) {
    this.hyperdriveRating = hyperdriveRating;
  }

  public Starship MGLT(String MGLT) {
    this.MGLT = MGLT;
    return this;
  }

  /**
   * The Maximum number of Megalights this starship can travel in a standard hour. A Megalight is a standard unit of distance and has never been defined before within the Star Wars universe. This figure is only really useful for measuring the difference in speed of starships. We can assume it is similar to AU, the distance between our Sun (Sol) and Earth.
   * @return MGLT
   */
  
  @JsonProperty("MGLT")
  public String getMGLT() {
    return MGLT;
  }

  public void setMGLT(String MGLT) {
    this.MGLT = MGLT;
  }

  public Starship cargoCapacity(String cargoCapacity) {
    this.cargoCapacity = cargoCapacity;
    return this;
  }

  /**
   * The maximum number of kilograms that this starship can transport.
   * @return cargoCapacity
   */
  
  @JsonProperty("cargo_capacity")
  public String getCargoCapacity() {
    return cargoCapacity;
  }

  public void setCargoCapacity(String cargoCapacity) {
    this.cargoCapacity = cargoCapacity;
  }

  public Starship consumables(String consumables) {
    this.consumables = consumables;
    return this;
  }

  /**
   * The maximum length of time that this starship can provide consumables for its entire crew without having to resupply.
   * @return consumables
   */
  
  @JsonProperty("consumables")
  public String getConsumables() {
    return consumables;
  }

  public void setConsumables(String consumables) {
    this.consumables = consumables;
  }

  public Starship films(List<URI> films) {
    this.films = films;
    return this;
  }

  public Starship addFilmsItem(URI filmsItem) {
    if (this.films == null) {
      this.films = new ArrayList<>();
    }
    this.films.add(filmsItem);
    return this;
  }

  /**
   * An array of Film URL Resources that this starship has appeared in.
   * @return films
   */
  @Valid 
  @JsonProperty("films")
  public List<URI> getFilms() {
    return films;
  }

  public void setFilms(List<URI> films) {
    this.films = films;
  }

  public Starship pilots(List<URI> pilots) {
    this.pilots = pilots;
    return this;
  }

  public Starship addPilotsItem(URI pilotsItem) {
    if (this.pilots == null) {
      this.pilots = new ArrayList<>();
    }
    this.pilots.add(pilotsItem);
    return this;
  }

  /**
   * An array of People URL Resources that this starship has been piloted by.
   * @return pilots
   */
  @Valid 
  @JsonProperty("pilots")
  public List<URI> getPilots() {
    return pilots;
  }

  public void setPilots(List<URI> pilots) {
    this.pilots = pilots;
  }

  public Starship url(URI url) {
    this.url = url;
    return this;
  }

  /**
   * The hypermedia URL of this resource.
   * @return url
   */
  @Valid 
  @JsonProperty("url")
  public URI getUrl() {
    return url;
  }

  public void setUrl(URI url) {
    this.url = url;
  }

  public Starship created(String created) {
    this.created = created;
    return this;
  }

  /**
   * The ISO 8601 date format of the time that this resource was created.
   * @return created
   */
  
  @JsonProperty("created")
  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public Starship edited(String edited) {
    this.edited = edited;
    return this;
  }

  /**
   * the ISO 8601 date format of the time that this resource was edited.
   * @return edited
   */
  
  @JsonProperty("edited")
  public String getEdited() {
    return edited;
  }

  public void setEdited(String edited) {
    this.edited = edited;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Starship starship = (Starship) o;
    return Objects.equals(this.name, starship.name) &&
        Objects.equals(this.model, starship.model) &&
        Objects.equals(this.starshipClass, starship.starshipClass) &&
        Objects.equals(this.manufacturer, starship.manufacturer) &&
        Objects.equals(this.costInCredits, starship.costInCredits) &&
        Objects.equals(this.length, starship.length) &&
        Objects.equals(this.crew, starship.crew) &&
        Objects.equals(this.passengers, starship.passengers) &&
        Objects.equals(this.maxAtmospheringSpeed, starship.maxAtmospheringSpeed) &&
        Objects.equals(this.hyperdriveRating, starship.hyperdriveRating) &&
        Objects.equals(this.MGLT, starship.MGLT) &&
        Objects.equals(this.cargoCapacity, starship.cargoCapacity) &&
        Objects.equals(this.consumables, starship.consumables) &&
        Objects.equals(this.films, starship.films) &&
        Objects.equals(this.pilots, starship.pilots) &&
        Objects.equals(this.url, starship.url) &&
        Objects.equals(this.created, starship.created) &&
        Objects.equals(this.edited, starship.edited);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, model, starshipClass, manufacturer, costInCredits, length, crew, passengers, maxAtmospheringSpeed, hyperdriveRating, MGLT, cargoCapacity, consumables, films, pilots, url, created, edited);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Starship {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    starshipClass: ").append(toIndentedString(starshipClass)).append("\n");
    sb.append("    manufacturer: ").append(toIndentedString(manufacturer)).append("\n");
    sb.append("    costInCredits: ").append(toIndentedString(costInCredits)).append("\n");
    sb.append("    length: ").append(toIndentedString(length)).append("\n");
    sb.append("    crew: ").append(toIndentedString(crew)).append("\n");
    sb.append("    passengers: ").append(toIndentedString(passengers)).append("\n");
    sb.append("    maxAtmospheringSpeed: ").append(toIndentedString(maxAtmospheringSpeed)).append("\n");
    sb.append("    hyperdriveRating: ").append(toIndentedString(hyperdriveRating)).append("\n");
    sb.append("    MGLT: ").append(toIndentedString(MGLT)).append("\n");
    sb.append("    cargoCapacity: ").append(toIndentedString(cargoCapacity)).append("\n");
    sb.append("    consumables: ").append(toIndentedString(consumables)).append("\n");
    sb.append("    films: ").append(toIndentedString(films)).append("\n");
    sb.append("    pilots: ").append(toIndentedString(pilots)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    edited: ").append(toIndentedString(edited)).append("\n");
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

