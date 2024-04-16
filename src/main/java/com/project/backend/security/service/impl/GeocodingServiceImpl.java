package com.project.backend.security.service.impl;

import com.project.backend.model.dao.Coordinates;
import com.project.backend.security.service.GeocodingService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeocodingServiceImpl implements GeocodingService {

    private final RestTemplate restTemplate;

    public GeocodingServiceImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public Coordinates geocode(String address) {
        String url = "https://nominatim.openstreetmap.org/search?format=json&q=" + address;
        String response = restTemplate.getForObject(url, String.class);
        JSONArray jsonArray = new JSONArray(response);
        if (jsonArray.length() > 0) {
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            double lat = jsonObject.getDouble("lat");
            double lon = jsonObject.getDouble("lon");
            return new Coordinates(lat, lon);
        } else {
            return null;
        }
    }
}
