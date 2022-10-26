

package com.jaswanth.docker.dockerspringbootgradle.dto;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

  
  private String id;

  @NotNull
  String itemId;

  @NotNull
  String name;

  @NotNull
  String imageUrl;

  @NotNull
  List<String> attributes = new ArrayList<>();

  @NotNull
  int price;

}