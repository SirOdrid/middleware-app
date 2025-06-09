package com.tfg.backend.api.controllers.Operations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.backend.config.ApiConfig;
import com.tfg.backend.models.Country;
import com.tfg.backend.services.operations.CountryService;


@RestController
@RequestMapping(ApiConfig.ENDPOINT_BASE_COUNTRY)
@CrossOrigin(origins = ApiConfig.CROSS_ORIGIN)
public class CountryController {
    
    @Autowired
    private final CountryService countryService;

    // Constructor
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    // Get all users
    @CrossOrigin
    @GetMapping(ApiConfig.ENDPOINT_COUNTRY_ALL)
    public ResponseEntity<?> getAllCountries() {
        List<Country> countries = countryService.getAllCountries();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

}
