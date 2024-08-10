package com.diverger.starwars.infrastructure.adapter.in.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;
import javax.annotation.Generated;

/**
 * Film
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-10T16:14:01.631152600+02:00[Europe/Paris]", comments = "Generator version: 7.7.0")
public class Film {

  private String name;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate releaseDate;

  public Film name(String name) {
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

  public Film releaseDate(LocalDate releaseDate) {
    this.releaseDate = releaseDate;
    return this;
  }

  /**
   * Get releaseDate
   * @return releaseDate
   */
  @Valid 
  @JsonProperty("release_date")
  public LocalDate getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(LocalDate releaseDate) {
    this.releaseDate = releaseDate;
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
    return Objects.equals(this.name, film.name) &&
        Objects.equals(this.releaseDate, film.releaseDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, releaseDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Film {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    releaseDate: ").append(toIndentedString(releaseDate)).append("\n");
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

