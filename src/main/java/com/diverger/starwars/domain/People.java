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
 * A person within the Star Wars universe
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-09-04T23:03:01.403283400+02:00[Europe/Paris]", comments = "Generator version: 7.7.0")
public class People {

  private String name;

  private String height;

  private String mass;

  private String hairColor;

  private String skinColor;

  private String eyeColor;

  private String birthYear;

  private String gender;

  private URI homeworld;

  @Valid
  private List<URI> films = new ArrayList<>();

  @Valid
  private List<URI> species = new ArrayList<>();

  @Valid
  private List<URI> vehicles = new ArrayList<>();

  @Valid
  private List<URI> starships = new ArrayList<>();

  private URI url;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime created;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime edited;

  public People name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of this person.
   * @return name
   */
  
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public People height(String height) {
    this.height = height;
    return this;
  }

  /**
   * The height of this person in meters.
   * @return height
   */
  
  @JsonProperty("height")
  public String getHeight() {
    return height;
  }

  public void setHeight(String height) {
    this.height = height;
  }

  public People mass(String mass) {
    this.mass = mass;
    return this;
  }

  /**
   * The mass of this person in kilograms.
   * @return mass
   */
  
  @JsonProperty("mass")
  public String getMass() {
    return mass;
  }

  public void setMass(String mass) {
    this.mass = mass;
  }

  public People hairColor(String hairColor) {
    this.hairColor = hairColor;
    return this;
  }

  /**
   * The hair color of this person.
   * @return hairColor
   */
  
  @JsonProperty("hair_color")
  public String getHairColor() {
    return hairColor;
  }

  public void setHairColor(String hairColor) {
    this.hairColor = hairColor;
  }

  public People skinColor(String skinColor) {
    this.skinColor = skinColor;
    return this;
  }

  /**
   * The skin color of this person.
   * @return skinColor
   */
  
  @JsonProperty("skin_color")
  public String getSkinColor() {
    return skinColor;
  }

  public void setSkinColor(String skinColor) {
    this.skinColor = skinColor;
  }

  public People eyeColor(String eyeColor) {
    this.eyeColor = eyeColor;
    return this;
  }

  /**
   * The eye color of this person.
   * @return eyeColor
   */
  
  @JsonProperty("eye_color")
  public String getEyeColor() {
    return eyeColor;
  }

  public void setEyeColor(String eyeColor) {
    this.eyeColor = eyeColor;
  }

  public People birthYear(String birthYear) {
    this.birthYear = birthYear;
    return this;
  }

  /**
   * The birth year of this person. BBY (Before the Battle of Yavin) or ABY (After the Battle of Yavin).
   * @return birthYear
   */
  
  @JsonProperty("birth_year")
  public String getBirthYear() {
    return birthYear;
  }

  public void setBirthYear(String birthYear) {
    this.birthYear = birthYear;
  }

  public People gender(String gender) {
    this.gender = gender;
    return this;
  }

  /**
   * The gender of this person (if known).
   * @return gender
   */
  
  @JsonProperty("gender")
  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public People homeworld(URI homeworld) {
    this.homeworld = homeworld;
    return this;
  }

  /**
   * The url of the planet resource that this person was born on.
   * @return homeworld
   */
  @Valid 
  @JsonProperty("homeworld")
  public URI getHomeworld() {
    return homeworld;
  }

  public void setHomeworld(URI homeworld) {
    this.homeworld = homeworld;
  }

  public People films(List<URI> films) {
    this.films = films;
    return this;
  }

  public People addFilmsItem(URI filmsItem) {
    if (this.films == null) {
      this.films = new ArrayList<>();
    }
    this.films.add(filmsItem);
    return this;
  }

  /**
   * An array of urls of film resources that this person has been in.
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

  public People species(List<URI> species) {
    this.species = species;
    return this;
  }

  public People addSpeciesItem(URI speciesItem) {
    if (this.species == null) {
      this.species = new ArrayList<>();
    }
    this.species.add(speciesItem);
    return this;
  }

  /**
   * The url of the species resource that this person is.
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

  public People vehicles(List<URI> vehicles) {
    this.vehicles = vehicles;
    return this;
  }

  public People addVehiclesItem(URI vehiclesItem) {
    if (this.vehicles == null) {
      this.vehicles = new ArrayList<>();
    }
    this.vehicles.add(vehiclesItem);
    return this;
  }

  /**
   * An array of vehicle resources that this person has piloted
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

  public People starships(List<URI> starships) {
    this.starships = starships;
    return this;
  }

  public People addStarshipsItem(URI starshipsItem) {
    if (this.starships == null) {
      this.starships = new ArrayList<>();
    }
    this.starships.add(starshipsItem);
    return this;
  }

  /**
   * An array of starship resources that this person has piloted
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

  public People url(URI url) {
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

  public People created(OffsetDateTime created) {
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

  public People edited(OffsetDateTime edited) {
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
    People people = (People) o;
    return Objects.equals(this.name, people.name) &&
        Objects.equals(this.height, people.height) &&
        Objects.equals(this.mass, people.mass) &&
        Objects.equals(this.hairColor, people.hairColor) &&
        Objects.equals(this.skinColor, people.skinColor) &&
        Objects.equals(this.eyeColor, people.eyeColor) &&
        Objects.equals(this.birthYear, people.birthYear) &&
        Objects.equals(this.gender, people.gender) &&
        Objects.equals(this.homeworld, people.homeworld) &&
        Objects.equals(this.films, people.films) &&
        Objects.equals(this.species, people.species) &&
        Objects.equals(this.vehicles, people.vehicles) &&
        Objects.equals(this.starships, people.starships) &&
        Objects.equals(this.url, people.url) &&
        Objects.equals(this.created, people.created) &&
        Objects.equals(this.edited, people.edited);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, height, mass, hairColor, skinColor, eyeColor, birthYear, gender, homeworld, films, species, vehicles, starships, url, created, edited);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class People {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
    sb.append("    mass: ").append(toIndentedString(mass)).append("\n");
    sb.append("    hairColor: ").append(toIndentedString(hairColor)).append("\n");
    sb.append("    skinColor: ").append(toIndentedString(skinColor)).append("\n");
    sb.append("    eyeColor: ").append(toIndentedString(eyeColor)).append("\n");
    sb.append("    birthYear: ").append(toIndentedString(birthYear)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    homeworld: ").append(toIndentedString(homeworld)).append("\n");
    sb.append("    films: ").append(toIndentedString(films)).append("\n");
    sb.append("    species: ").append(toIndentedString(species)).append("\n");
    sb.append("    vehicles: ").append(toIndentedString(vehicles)).append("\n");
    sb.append("    starships: ").append(toIndentedString(starships)).append("\n");
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

