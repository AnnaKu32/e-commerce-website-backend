package com.project.backend.security.service.impl;

import com.project.backend.model.dao.Restaurant;
import com.project.backend.model.repository.RestaurantRepository;
import com.project.backend.security.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private GeocodingServiceImpl geocodingService;

    @Override
    public List<Restaurant> findRestaurantsByAddress(String address) {
        Coordinates coordinates = geocodingService.geocode(address);
        return restaurantRepository.findByCoordinatesNear(coordinates);
    }
}
