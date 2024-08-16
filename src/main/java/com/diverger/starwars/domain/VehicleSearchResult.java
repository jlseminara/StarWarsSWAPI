package com.diverger.starwars.domain;

import java.net.URI;
import java.util.Objects;
import com.diverger.starwars.domain.Vehicle;
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
 * List of vehicles returned
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-16T03:14:59.448348500+02:00[Europe/Paris]", comments = "Generator version: 7.7.0")
public class VehicleSearchResult {

  private Integer count;

  private URI next;

  private URI previous;

  @Valid
  private List<@Valid Vehicle> results = new ArrayList<>();

  public VehicleSearchResult count(Integer count) {
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

  public VehicleSearchResult next(URI next) {
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

  public VehicleSearchResult previous(URI previous) {
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

  public VehicleSearchResult results(List<@Valid Vehicle> results) {
    this.results = results;
    return this;
  }

  public VehicleSearchResult addResultsItem(Vehicle resultsItem) {
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
  public List<@Valid Vehicle> getResults() {
    return results;
  }

  public void setResults(List<@Valid Vehicle> results) {
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
    VehicleSearchResult vehicleSearchResult = (VehicleSearchResult) o;
    return Objects.equals(this.count, vehicleSearchResult.count) &&
        Objects.equals(this.next, vehicleSearchResult.next) &&
        Objects.equals(this.previous, vehicleSearchResult.previous) &&
        Objects.equals(this.results, vehicleSearchResult.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, next, previous, results);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VehicleSearchResult {\n");
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

