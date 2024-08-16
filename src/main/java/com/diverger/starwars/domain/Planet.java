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
 * A planet.
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-16T03:14:59.448348500+02:00[Europe/Paris]", comments = "Generator version: 7.7.0")
public class Planet {

  private String name;

  private String diameter;

  private String rotationPeriod;

  private String orbitalPeriod;

  private String gravity;

  private String population;

  private String climate;

  private String terrain;

  private String surfaceWater;

  @Valid
  private List<URI> films = new ArrayList<>();

  @Valid
  private List<URI> residents = new ArrayList<>();

  private URI url;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime created;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime edited;

  public Planet name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of this planet.
   * @return name
   */
  
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Planet diameter(String diameter) {
    this.diameter = diameter;
    return this;
  }

  /**
   * The diameter of this planet in kilometers.
   * @return diameter
   */
  
  @JsonProperty("diameter")
  public String getDiameter() {
    return diameter;
  }

  public void setDiameter(String diameter) {
    this.diameter = diameter;
  }

  public Planet rotationPeriod(String rotationPeriod) {
    this.rotationPeriod = rotationPeriod;
    return this;
  }

  /**
   * The number of standard hours it takes for this planet to complete a single rotation on its axis.
   * @return rotationPeriod
   */
  
  @JsonProperty("rotation_period")
  public String getRotationPeriod() {
    return rotationPeriod;
  }

  public void setRotationPeriod(String rotationPeriod) {
    this.rotationPeriod = rotationPeriod;
  }

  public Planet orbitalPeriod(String orbitalPeriod) {
    this.orbitalPeriod = orbitalPeriod;
    return this;
  }

  /**
   * The number of standard days it takes for this planet to complete a single orbit of its local star.
   * @return orbitalPeriod
   */
  
  @JsonProperty("orbital_period")
  public String getOrbitalPeriod() {
    return orbitalPeriod;
  }

  public void setOrbitalPeriod(String orbitalPeriod) {
    this.orbitalPeriod = orbitalPeriod;
  }

  public Planet gravity(String gravity) {
    this.gravity = gravity;
    return this;
  }

  /**
   * A number denoting the gravity of this planet. Where 1 is normal.
   * @return gravity
   */
  
  @JsonProperty("gravity")
  public String getGravity() {
    return gravity;
  }

  public void setGravity(String gravity) {
    this.gravity = gravity;
  }

  public Planet population(String population) {
    this.population = population;
    return this;
  }

  /**
   * The average populationof sentient beings inhabiting this planet.
   * @return population
   */
  
  @JsonProperty("population")
  public String getPopulation() {
    return population;
  }

  public void setPopulation(String population) {
    this.population = population;
  }

  public Planet climate(String climate) {
    this.climate = climate;
    return this;
  }

  /**
   * The climate of this planet. Comma-seperated if diverse.
   * @return climate
   */
  
  @JsonProperty("climate")
  public String getClimate() {
    return climate;
  }

  public void setClimate(String climate) {
    this.climate = climate;
  }

  public Planet terrain(String terrain) {
    this.terrain = terrain;
    return this;
  }

  /**
   * the terrain of this planet. Comma-seperated if diverse.
   * @return terrain
   */
  
  @JsonProperty("terrain")
  public String getTerrain() {
    return terrain;
  }

  public void setTerrain(String terrain) {
    this.terrain = terrain;
  }

  public Planet surfaceWater(String surfaceWater) {
    this.surfaceWater = surfaceWater;
    return this;
  }

  /**
   * The percentage of the planet surface that is naturally occuring water or bodies of water.
   * @return surfaceWater
   */
  
  @JsonProperty("surface_water")
  public String getSurfaceWater() {
    return surfaceWater;
  }

  public void setSurfaceWater(String surfaceWater) {
    this.surfaceWater = surfaceWater;
  }

  public Planet films(List<URI> films) {
    this.films = films;
    return this;
  }

  public Planet addFilmsItem(URI filmsItem) {
    if (this.films == null) {
      this.films = new ArrayList<>();
    }
    this.films.add(filmsItem);
    return this;
  }

  /**
   * An array of Film URL Resources that this planet has appeared in.
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

  public Planet residents(List<URI> residents) {
    this.residents = residents;
    return this;
  }

  public Planet addResidentsItem(URI residentsItem) {
    if (this.residents == null) {
      this.residents = new ArrayList<>();
    }
    this.residents.add(residentsItem);
    return this;
  }

  /**
   * An array of People URL Resources that live on this planet.
   * @return residents
   */
  @Valid 
  @JsonProperty("residents")
  public List<URI> getResidents() {
    return residents;
  }

  public void setResidents(List<URI> residents) {
    this.residents = residents;
  }

  public Planet url(URI url) {
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

  public Planet created(OffsetDateTime created) {
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

  public Planet edited(OffsetDateTime edited) {
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
    Planet planet = (Planet) o;
    return Objects.equals(this.name, planet.name) &&
        Objects.equals(this.diameter, planet.diameter) &&
        Objects.equals(this.rotationPeriod, planet.rotationPeriod) &&
        Objects.equals(this.orbitalPeriod, planet.orbitalPeriod) &&
        Objects.equals(this.gravity, planet.gravity) &&
        Objects.equals(this.population, planet.population) &&
        Objects.equals(this.climate, planet.climate) &&
        Objects.equals(this.terrain, planet.terrain) &&
        Objects.equals(this.surfaceWater, planet.surfaceWater) &&
        Objects.equals(this.films, planet.films) &&
        Objects.equals(this.residents, planet.residents) &&
        Objects.equals(this.url, planet.url) &&
        Objects.equals(this.created, planet.created) &&
        Objects.equals(this.edited, planet.edited);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, diameter, rotationPeriod, orbitalPeriod, gravity, population, climate, terrain, surfaceWater, films, residents, url, created, edited);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Planet {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    diameter: ").append(toIndentedString(diameter)).append("\n");
    sb.append("    rotationPeriod: ").append(toIndentedString(rotationPeriod)).append("\n");
    sb.append("    orbitalPeriod: ").append(toIndentedString(orbitalPeriod)).append("\n");
    sb.append("    gravity: ").append(toIndentedString(gravity)).append("\n");
    sb.append("    population: ").append(toIndentedString(population)).append("\n");
    sb.append("    climate: ").append(toIndentedString(climate)).append("\n");
    sb.append("    terrain: ").append(toIndentedString(terrain)).append("\n");
    sb.append("    surfaceWater: ").append(toIndentedString(surfaceWater)).append("\n");
    sb.append("    films: ").append(toIndentedString(films)).append("\n");
    sb.append("    residents: ").append(toIndentedString(residents)).append("\n");
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

