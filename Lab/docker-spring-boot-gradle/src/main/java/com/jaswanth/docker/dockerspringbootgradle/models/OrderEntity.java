package com.jaswanth.docker.dockerspringbootgradle.models;

import java.util.List;
import javax.validation.constraints.NotNull;

import com.jaswanth.docker.dockerspringbootgradle.dto.Item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {

  private String id;
  @NotNull
  private String restaurantId;
  @NotNull
  private String userId;
  @NotNull
  private List<Item> items;
  @NotNull
  private int total;
  @NotNull
  private String timePlaced;
}
