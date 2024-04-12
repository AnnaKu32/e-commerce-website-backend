package com.project.backend.controller;

import com.project.backend.model.dao.Restaurant;
import com.project.backend.security.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/nearby")
    public List<Restaurant> getNearbyRestaurants(@RequestParam String address) {
        return restaurantService.findRestaurantsByAddress(address);
    }
}
