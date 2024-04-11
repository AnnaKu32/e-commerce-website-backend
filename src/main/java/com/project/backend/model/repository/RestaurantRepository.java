package com.project.backend.model.repository;

import com.project.backend.model.dao.Restaurant;
import com.project.backend.security.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantRepository {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public List<Restaurant> getRestaurantsByAddress(@RequestParam String address) {
        return restaurantService.findRestaurantsByAddress(address);
    }

}
