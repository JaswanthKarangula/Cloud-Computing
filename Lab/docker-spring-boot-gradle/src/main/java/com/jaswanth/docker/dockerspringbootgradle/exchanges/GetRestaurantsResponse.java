

package com.jaswanth.docker.dockerspringbootgradle.exchanges;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jaswanth.docker.dockerspringbootgradle.dto.Restaurant;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetRestaurantsResponse {

  @JsonProperty(value = "restaurants")
  private List<Restaurant> restaurants = new ArrayList<>();

}


