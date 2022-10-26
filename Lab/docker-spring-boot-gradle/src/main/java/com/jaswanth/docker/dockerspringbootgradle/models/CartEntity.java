package com.jaswanth.docker.dockerspringbootgradle.models;


import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.jaswanth.docker.dockerspringbootgradle.dto.Item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartEntity {

  

  private String id;

  @NotNull
  private String restaurantId;

  @NotNull
  private String userId;

  @NotNull
  private List<Item> items = new ArrayList<>();

  @NotNull
  private int total = 0;

  public void addItem(Item item) {
    items.add(item);
    total += item.getPrice();
  }

  public void removeItem(Item item) {
    boolean removed = items.remove(item);
    
    if (removed) {
      total = total - item.getPrice();
    }
  }

  public void clearCart() {
    if (items.size() > 0) {
      items.clear();
    }
  }
}