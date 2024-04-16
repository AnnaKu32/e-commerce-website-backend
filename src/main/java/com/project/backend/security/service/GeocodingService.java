package com.project.backend.security.service;

import com.project.backend.model.dao.Coordinates;

public interface GeocodingService {

    public Coordinates geocode(String address);
}
