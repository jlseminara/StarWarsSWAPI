package com.diverger.starwars.domain;

import java.net.URI;
import java.util.Objects;
import com.diverger.starwars.domain.Film;
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
 * List of films returned
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-13T16:16:43.821372300+02:00[Europe/Paris]", comments = "Generator version: 7.7.0")
public class FilmsSearchResult {

  private Integer count;

  private URI next;

  private URI previous;

  @Valid
  private List<@Valid Film> results = new ArrayList<>();

  public FilmsSearchResult count(Integer count) {
    this.count = count;
    return this;
  }

  /**
   * Get count
   * @return count
   */
  
  @JsonProperty("count")
  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public FilmsSearchResult next(URI next) {
    this.next = next;
    return this;
  }

  /**
   * Get next
   * @return next
   */
  @Valid 
  @JsonProperty("next")
  public URI getNext() {
    return next;
  }

  public void setNext(URI next) {
    this.next = next;
  }

  public FilmsSearchResult previous(URI previous) {
    this.previous = previous;
    return this;
  }

  /**
   * Get previous
   * @return previous
   */
  @Valid 
  @JsonProperty("previous")
  public URI getPrevious() {
    return previous;
  }

  public void setPrevious(URI previous) {
    this.previous = previous;
  }

  public FilmsSearchResult results(List<@Valid Film> results) {
    this.results = results;
    return this;
  }

  public FilmsSearchResult addResultsItem(Film resultsItem) {
    if (this.results == null) {
      this.results = new ArrayList<>();
    }
    this.results.add(resultsItem);
    return this;
  }

  /**
   * Get results
   * @return results
   */
  @Valid 
  @JsonProperty("results")
  public List<@Valid Film> getResults() {
    return results;
  }

  public void setResults(List<@Valid Film> results) {
    this.results = results;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FilmsSearchResult filmsSearchResult = (FilmsSearchResult) o;
    return Objects.equals(this.count, filmsSearchResult.count) &&
        Objects.equals(this.next, filmsSearchResult.next) &&
        Objects.equals(this.previous, filmsSearchResult.previous) &&
        Objects.equals(this.results, filmsSearchResult.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, next, previous, results);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FilmsSearchResult {\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    next: ").append(toIndentedString(next)).append("\n");
    sb.append("    previous: ").append(toIndentedString(previous)).append("\n");
    sb.append("    results: ").append(toIndentedString(results)).append("\n");
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

