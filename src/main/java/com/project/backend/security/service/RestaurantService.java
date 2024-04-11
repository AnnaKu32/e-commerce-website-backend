package com.project.backend.security.service;

import com.project.backend.model.dao.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> findRestaurantsByAddress(String address);
}
