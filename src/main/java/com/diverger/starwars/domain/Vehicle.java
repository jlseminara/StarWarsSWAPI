package com.diverger.starwars.domain;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;
import javax.annotation.Generated;

/**
 * A vehicle.
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-14T18:04:26.420224800+02:00[Europe/Paris]", comments = "Generator version: 7.7.0")
public class Vehicle {

  private String name;

  private String model;

  private String manufacturer;

  private String costInCredits;

  private String length;

  private String crew;

  private String passengers;

  private String maxAtmospheringSpeed;

  private String cargoCapacity;

  private String consumables;

  private String hyperdriveRating;

  private String MGLT;

  private String starshipClassDoubleQuote;

  @Valid
  private List<URI> films = new ArrayList<>();

  @Valid
  private List<URI> pilots = new ArrayList<>();

  private URI url;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime created;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime edited;

  public Vehicle name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of this vehicle. The common name, such as Sand Crawler.
   * @return name
   */
  
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Vehicle model(String model) {
    this.model = model;
    return this;
  }

  /**
   * The model or official name of this vehicle. Such as All Terrain Attack Transport.
   * @return model
   */
  
  @JsonProperty("model")
  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Vehicle manufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
    return this;
  }

  /**
   * The manufacturer of this vehicle. Comma separated if more than one.
   * @return manufacturer
   */
  
  @JsonProperty("manufacturer")
  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public Vehicle costInCredits(String costInCredits) {
    this.costInCredits = costInCredits;
    return this;
  }

  /**
   * The cost of this vehicle new, in galactic credits.
   * @return costInCredits
   */
  
  @JsonProperty("cost_in_credits")
  public String getCostInCredits() {
    return costInCredits;
  }

  public void setCostInCredits(String costInCredits) {
    this.costInCredits = costInCredits;
  }

  public Vehicle length(String length) {
    this.length = length;
    return this;
  }

  /**
   * The length of this vehicle in meters.
   * @return length
   */
  
  @JsonProperty("length")
  public String getLength() {
    return length;
  }

  public void setLength(String length) {
    this.length = length;
  }

  public Vehicle crew(String crew) {
    this.crew = crew;
    return this;
  }

  /**
   * The number of personnel needed to run or pilot this vehicle.
   * @return crew
   */
  
  @JsonProperty("crew")
  public String getCrew() {
    return crew;
  }

  public void setCrew(String crew) {
    this.crew = crew;
  }

  public Vehicle passengers(String passengers) {
    this.passengers = passengers;
    return this;
  }

  /**
   * The number of non-essential people this vehicle can transport.
   * @return passengers
   */
  
  @JsonProperty("passengers")
  public String getPassengers() {
    return passengers;
  }

  public void setPassengers(String passengers) {
    this.passengers = passengers;
  }

  public Vehicle maxAtmospheringSpeed(String maxAtmospheringSpeed) {
    this.maxAtmospheringSpeed = maxAtmospheringSpeed;
    return this;
  }

  /**
   * The maximum speed of this vehicle in atmosphere.
   * @return maxAtmospheringSpeed
   */
  
  @JsonProperty("max_atmosphering_speed")
  public String getMaxAtmospheringSpeed() {
    return maxAtmospheringSpeed;
  }

  public void setMaxAtmospheringSpeed(String maxAtmospheringSpeed) {
    this.maxAtmospheringSpeed = maxAtmospheringSpeed;
  }

  public Vehicle cargoCapacity(String cargoCapacity) {
    this.cargoCapacity = cargoCapacity;
    return this;
  }

  /**
   * The maximum number of kilograms that this vehicle can transport.
   * @return cargoCapacity
   */
  
  @JsonProperty("cargo_capacity")
  public String getCargoCapacity() {
    return cargoCapacity;
  }

  public void setCargoCapacity(String cargoCapacity) {
    this.cargoCapacity = cargoCapacity;
  }

  public Vehicle consumables(String consumables) {
    this.consumables = consumables;
    return this;
  }

  /**
   * The maximum length of time that this vehicle can provide consumables for its entire crew without having to resupply.
   * @return consumables
   */
  
  @JsonProperty("consumables")
  public String getConsumables() {
    return consumables;
  }

  public void setConsumables(String consumables) {
    this.consumables = consumables;
  }

  public Vehicle hyperdriveRating(String hyperdriveRating) {
    this.hyperdriveRating = hyperdriveRating;
    return this;
  }

  /**
   * Get hyperdriveRating
   * @return hyperdriveRating
   */
  
  @JsonProperty("hyperdrive_rating")
  public String getHyperdriveRating() {
    return hyperdriveRating;
  }

  public void setHyperdriveRating(String hyperdriveRating) {
    this.hyperdriveRating = hyperdriveRating;
  }

  public Vehicle MGLT(String MGLT) {
    this.MGLT = MGLT;
    return this;
  }

  /**
   * Get MGLT
   * @return MGLT
   */
  
  @JsonProperty("MGLT")
  public String getMGLT() {
    return MGLT;
  }

  public void setMGLT(String MGLT) {
    this.MGLT = MGLT;
  }

  public Vehicle starshipClassDoubleQuote(String starshipClassDoubleQuote) {
    this.starshipClassDoubleQuote = starshipClassDoubleQuote;
    return this;
  }

  /**
   * Get starshipClassDoubleQuote
   * @return starshipClassDoubleQuote
   */
  
  @JsonProperty("starship_class&quot;")
  public String getStarshipClassDoubleQuote() {
    return starshipClassDoubleQuote;
  }

  public void setStarshipClassDoubleQuote(String starshipClassDoubleQuote) {
    this.starshipClassDoubleQuote = starshipClassDoubleQuote;
  }

  public Vehicle films(List<URI> films) {
    this.films = films;
    return this;
  }

  public Vehicle addFilmsItem(URI filmsItem) {
    if (this.films == null) {
      this.films = new ArrayList<>();
    }
    this.films.add(filmsItem);
    return this;
  }

  /**
   * An array of Film URL Resources that this vehicle has appeared in.
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

  public Vehicle pilots(List<URI> pilots) {
    this.pilots = pilots;
    return this;
  }

  public Vehicle addPilotsItem(URI pilotsItem) {
    if (this.pilots == null) {
      this.pilots = new ArrayList<>();
    }
    this.pilots.add(pilotsItem);
    return this;
  }

  /**
   * An array of People URL Resources that this vehicle has been piloted by.
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

  public Vehicle url(URI url) {
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

  public Vehicle created(OffsetDateTime created) {
    this.created = created;
    return this;
  }

  /**
   * The ISO 8601 date format of the time that this resource was created.
   * @return created
   */
  @Valid 
  @JsonProperty("created")
  public OffsetDateTime getCreated() {
    return created;
  }

  public void setCreated(OffsetDateTime created) {
    this.created = created;
  }

  public Vehicle edited(OffsetDateTime edited) {
    this.edited = edited;
    return this;
  }

  /**
   * the ISO 8601 date format of the time that this resource was edited.
   * @return edited
   */
  @Valid 
  @JsonProperty("edited")
  public OffsetDateTime getEdited() {
    return edited;
  }

  public void setEdited(OffsetDateTime edited) {
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
    Vehicle vehicle = (Vehicle) o;
    return Objects.equals(this.name, vehicle.name) &&
        Objects.equals(this.model, vehicle.model) &&
        Objects.equals(this.manufacturer, vehicle.manufacturer) &&
        Objects.equals(this.costInCredits, vehicle.costInCredits) &&
        Objects.equals(this.length, vehicle.length) &&
        Objects.equals(this.crew, vehicle.crew) &&
        Objects.equals(this.passengers, vehicle.passengers) &&
        Objects.equals(this.maxAtmospheringSpeed, vehicle.maxAtmospheringSpeed) &&
        Objects.equals(this.cargoCapacity, vehicle.cargoCapacity) &&
        Objects.equals(this.consumables, vehicle.consumables) &&
        Objects.equals(this.hyperdriveRating, vehicle.hyperdriveRating) &&
        Objects.equals(this.MGLT, vehicle.MGLT) &&
        Objects.equals(this.starshipClassDoubleQuote, vehicle.starshipClassDoubleQuote) &&
        Objects.equals(this.films, vehicle.films) &&
        Objects.equals(this.pilots, vehicle.pilots) &&
        Objects.equals(this.url, vehicle.url) &&
        Objects.equals(this.created, vehicle.created) &&
        Objects.equals(this.edited, vehicle.edited);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, model, manufacturer, costInCredits, length, crew, passengers, maxAtmospheringSpeed, cargoCapacity, consumables, hyperdriveRating, MGLT, starshipClassDoubleQuote, films, pilots, url, created, edited);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Vehicle {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    manufacturer: ").append(toIndentedString(manufacturer)).append("\n");
    sb.append("    costInCredits: ").append(toIndentedString(costInCredits)).append("\n");
    sb.append("    length: ").append(toIndentedString(length)).append("\n");
    sb.append("    crew: ").append(toIndentedString(crew)).append("\n");
    sb.append("    passengers: ").append(toIndentedString(passengers)).append("\n");
    sb.append("    maxAtmospheringSpeed: ").append(toIndentedString(maxAtmospheringSpeed)).append("\n");
    sb.append("    cargoCapacity: ").append(toIndentedString(cargoCapacity)).append("\n");
    sb.append("    consumables: ").append(toIndentedString(consumables)).append("\n");
    sb.append("    hyperdriveRating: ").append(toIndentedString(hyperdriveRating)).append("\n");
    sb.append("    MGLT: ").append(toIndentedString(MGLT)).append("\n");
    sb.append("    starshipClassDoubleQuote: ").append(toIndentedString(starshipClassDoubleQuote)).append("\n");
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

