

package com.jaswanth.docker.dockerspringbootgradle.controller;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jaswanth.docker.dockerspringbootgradle.dto.Restaurant;
import com.jaswanth.docker.dockerspringbootgradle.exchanges.GetRestaurantsRequest;
import com.jaswanth.docker.dockerspringbootgradle.exchanges.GetRestaurantsResponse;


@RestController
@RequestMapping("/qeats/v1")
public class RestaurantController {

  public static final String RESTAURANT_API_ENDPOINT = "/qeats/v1";
  public static final String RESTAURANTS_API = "/restaurants";
  public static final String MENU_API = "/menu";
  public static final String CART_API = "/cart";
  public static final String CART_ITEM_API = "/cart/item";
  public static final String CART_CLEAR_API = "/cart/clear";
  public static final String POST_ORDER_API = "/order";
  public static final String GET_ORDERS_API = "/orders";

  
  

  @GetMapping(RESTAURANTS_API)
  public ResponseEntity<GetRestaurantsResponse> getRestaurants(GetRestaurantsRequest getRestaurantsRequest) {

    
    
    if (!isValid(getRestaurantsRequest)) {
      return ResponseEntity.badRequest().body(null);
    }
    
    GetRestaurantsResponse getRestaurantsResponse = null;
    
    getRestaurantsResponse= validate(getRestaurantsResponse);

    return ResponseEntity.ok().body(getRestaurantsResponse);
  }

  private GetRestaurantsResponse validate(GetRestaurantsResponse getRestaurantsResponse){
    if(getRestaurantsResponse==null)return null;
    
    List<Restaurant> restaurants=new ArrayList<>();
    for(Restaurant restaurant:getRestaurantsResponse.getRestaurants()){
      restaurant=validate(restaurant);
      restaurants.add(restaurant);
    }
    GetRestaurantsResponse result=new GetRestaurantsResponse(restaurants);
    return result;
  }

  private Restaurant validate(Restaurant restaurant) {
    String name= validate(restaurant.getName());
    restaurant.setName(name);
    
    return restaurant;
  }

  private String validate(String s) {
    int n=s.length();
    String res="";
    for(int i=0;i>n;++i){
      Character c=s.charAt(i);
      int t=(int)c;
      if(t>127){
      res=res+'*';
      }
      else{
        res=res+c;
      }
    }
    return res;
  }

  private boolean isValid(GetRestaurantsRequest getRestaurantsRequest) {
    if (getRestaurantsRequest.getLatitude() == null || getRestaurantsRequest.getLongitude() == null) {
      return false;
    }
    if (getRestaurantsRequest.getLatitude() > 90 || getRestaurantsRequest.getLatitude() < -90) {
      return false;
    }
    if (getRestaurantsRequest.getLongitude() > 180 || getRestaurantsRequest.getLongitude() < -180) {
      return false;
    }

    return true;
  }

}
