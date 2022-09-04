package com.project.bedroommanagement.controller;

import com.project.bedroommanagement.model.Country;
import com.project.bedroommanagement.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CountryController {
    private CountryService countryService;

    @GetMapping("/countries")
    public List<Country> getAllCountries(
            @RequestParam(name = "page")Long page,
            @RequestParam(name = "page_size")Long pageSize,
            @RequestParam(name = "country_name", required = false)String countryName
    ){
        return countryService.redirectingRequest(page, pageSize, countryName);
    }

    @PostMapping("/countries")
    public Country insertCountry(@RequestBody Country newCountry){
        return countryService.insertCountry(newCountry);
    }

    @DeleteMapping("/country/{id}")
    public String deleteCountry(@PathVariable(name = "id")Long id){
        return countryService.deleteCountry(id);
    }

    @PutMapping("/country/{id}")
    public Country putUpdateCountry(
            @PathVariable(name = "id")Long id,
            @RequestParam(name = "new-country")String newCountry
    ){
        return countryService.putUpdate(id, newCountry);
    }
}
