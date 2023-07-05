package com.bemal.customer_management_system.Services;

import com.bemal.customer_management_system.Entity.City;
import com.bemal.customer_management_system.repository.CityRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City createCity(City city) {
        return cityRepository.save(city);
    }

    public City updateCity(Long cityId, City updatedCity) {
        updatedCity.setId(cityId);
        return cityRepository.save(updatedCity);
    }

    public City getCityById(Long cityId) {
        return cityRepository.findById(cityId)
                .orElseThrow(() -> new EntityNotFoundException("City not found with id: " + cityId));
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public void deleteCity(Long cityId) {
        cityRepository.deleteById(cityId);
    }
}
