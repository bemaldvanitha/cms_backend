package com.bemal.customer_management_system.Services;

import com.bemal.customer_management_system.Entity.Country;
import com.bemal.customer_management_system.repository.CountryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country createCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country updateCountry(Long countryId, Country updatedCountry) {
        updatedCountry.setId(countryId);
        return countryRepository.save(updatedCountry);
    }

    public Country getCountryById(Long countryId) {
        return countryRepository.findById(countryId)
                .orElseThrow(() -> new EntityNotFoundException("Country not found with id: " + countryId));
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public void deleteCountry(Long countryId) {
        countryRepository.deleteById(countryId);
    }
}


