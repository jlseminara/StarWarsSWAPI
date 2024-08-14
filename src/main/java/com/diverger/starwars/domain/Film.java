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
 * A Star Wars film
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-14T18:04:26.420224800+02:00[Europe/Paris]", comments = "Generator version: 7.7.0")
public class Film {

  private String title;

  private Integer episodeId;

  private String openingCrawl;

  private String director;

  private String producer;

  private String releaseDate;

  @Valid
  private List<URI> characters = new ArrayList<>();

  @Valid
  private List<URI> planets = new ArrayList<>();

  @Valid
  private List<URI> starships = new ArrayList<>();

  @Valid
  private List<URI> vehicles = new ArrayList<>();

  @Valid
  private List<URI> species = new ArrayList<>();

  private URI url;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime created;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime edited;

  public Film title(String title) {
    this.title = title;
    return this;
  }

  /**
   * The title of this film.
   * @return title
   */
  
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Film episodeId(Integer episodeId) {
    this.episodeId = episodeId;
    return this;
  }

  /**
   * The episode number of this film.
   * @return episodeId
   */
  
  @JsonProperty("episode_id")
  public Integer getEpisodeId() {
    return episodeId;
  }

  public void setEpisodeId(Integer episodeId) {
    this.episodeId = episodeId;
  }

  public Film openingCrawl(String openingCrawl) {
    this.openingCrawl = openingCrawl;
    return this;
  }

  /**
   * The opening crawl text at the beginning of this film.
   * @return openingCrawl
   */
  
  @JsonProperty("opening_crawl")
  public String getOpeningCrawl() {
    return openingCrawl;
  }

  public void setOpeningCrawl(String openingCrawl) {
    this.openingCrawl = openingCrawl;
  }

  public Film director(String director) {
    this.director = director;
    return this;
  }

  /**
   * The director of this film.
   * @return director
   */
  
  @JsonProperty("director")
  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public Film producer(String producer) {
    this.producer = producer;
    return this;
  }

  /**
   * The producer(s) of this film.
   * @return producer
   */
  
  @JsonProperty("producer")
  public String getProducer() {
    return producer;
  }

  public void setProducer(String producer) {
    this.producer = producer;
  }

  public Film releaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
    return this;
  }

  /**
   * The release date at original creator country.
   * @return releaseDate
   */
  
  @JsonProperty("release_date")
  public String getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }

  public Film characters(List<URI> characters) {
    this.characters = characters;
    return this;
  }

  public Film addCharactersItem(URI charactersItem) {
    if (this.characters == null) {
      this.characters = new ArrayList<>();
    }
    this.characters.add(charactersItem);
    return this;
  }

  /**
   * The people resources featured within this film.
   * @return characters
   */
  @Valid 
  @JsonProperty("characters")
  public List<URI> getCharacters() {
    return characters;
  }

  public void setCharacters(List<URI> characters) {
    this.characters = characters;
  }

  public Film planets(List<URI> planets) {
    this.planets = planets;
    return this;
  }

  public Film addPlanetsItem(URI planetsItem) {
    if (this.planets == null) {
      this.planets = new ArrayList<>();
    }
    this.planets.add(planetsItem);
    return this;
  }

  /**
   * The planet resources featured within this film.
   * @return planets
   */
  @Valid 
  @JsonProperty("planets")
  public List<URI> getPlanets() {
    return planets;
  }

  public void setPlanets(List<URI> planets) {
    this.planets = planets;
  }

  public Film starships(List<URI> starships) {
    this.starships = starships;
    return this;
  }

  public Film addStarshipsItem(URI starshipsItem) {
    if (this.starships == null) {
      this.starships = new ArrayList<>();
    }
    this.starships.add(starshipsItem);
    return this;
  }

  /**
   * The starship resources featured within this film.
   * @return starships
   */
  @Valid 
  @JsonProperty("starships")
  public List<URI> getStarships() {
    return starships;
  }

  public void setStarships(List<URI> starships) {
    this.starships = starships;
  }

  public Film vehicles(List<URI> vehicles) {
    this.vehicles = vehicles;
    return this;
  }

  public Film addVehiclesItem(URI vehiclesItem) {
    if (this.vehicles == null) {
      this.vehicles = new ArrayList<>();
    }
    this.vehicles.add(vehiclesItem);
    return this;
  }

  /**
   * The vehicle resources featured within this film.
   * @return vehicles
   */
  @Valid 
  @JsonProperty("vehicles")
  public List<URI> getVehicles() {
    return vehicles;
  }

  public void setVehicles(List<URI> vehicles) {
    this.vehicles = vehicles;
  }

  public Film species(List<URI> species) {
    this.species = species;
    return this;
  }

  public Film addSpeciesItem(URI speciesItem) {
    if (this.species == null) {
      this.species = new ArrayList<>();
    }
    this.species.add(speciesItem);
    return this;
  }

  /**
   * The species resources featured within this film.
   * @return species
   */
  @Valid 
  @JsonProperty("species")
  public List<URI> getSpecies() {
    return species;
  }

  public void setSpecies(List<URI> species) {
    this.species = species;
  }

  public Film url(URI url) {
    this.url = url;
    return this;
  }

  /**
   * The url of this resource
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

  public Film created(OffsetDateTime created) {
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

  public Film edited(OffsetDateTime edited) {
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
    Film film = (Film) o;
    return Objects.equals(this.title, film.title) &&
        Objects.equals(this.episodeId, film.episodeId) &&
        Objects.equals(this.openingCrawl, film.openingCrawl) &&
        Objects.equals(this.director, film.director) &&
        Objects.equals(this.producer, film.producer) &&
        Objects.equals(this.releaseDate, film.releaseDate) &&
        Objects.equals(this.characters, film.characters) &&
        Objects.equals(this.planets, film.planets) &&
        Objects.equals(this.starships, film.starships) &&
        Objects.equals(this.vehicles, film.vehicles) &&
        Objects.equals(this.species, film.species) &&
        Objects.equals(this.url, film.url) &&
        Objects.equals(this.created, film.created) &&
        Objects.equals(this.edited, film.edited);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, episodeId, openingCrawl, director, producer, releaseDate, characters, planets, starships, vehicles, species, url, created, edited);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Film {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    episodeId: ").append(toIndentedString(episodeId)).append("\n");
    sb.append("    openingCrawl: ").append(toIndentedString(openingCrawl)).append("\n");
    sb.append("    director: ").append(toIndentedString(director)).append("\n");
    sb.append("    producer: ").append(toIndentedString(producer)).append("\n");
    sb.append("    releaseDate: ").append(toIndentedString(releaseDate)).append("\n");
    sb.append("    characters: ").append(toIndentedString(characters)).append("\n");
    sb.append("    planets: ").append(toIndentedString(planets)).append("\n");
    sb.append("    starships: ").append(toIndentedString(starships)).append("\n");
    sb.append("    vehicles: ").append(toIndentedString(vehicles)).append("\n");
    sb.append("    species: ").append(toIndentedString(species)).append("\n");
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

