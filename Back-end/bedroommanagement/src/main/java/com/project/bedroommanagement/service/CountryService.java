package com.project.bedroommanagement.service;

import com.project.bedroommanagement.model.Country;
import com.project.bedroommanagement.model.Hotel;
import com.project.bedroommanagement.repository.CountryRepository;
import com.project.bedroommanagement.repository.HotelRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryService {
    private CountryRepository countryRepository;
    private HotelRepository hotelRepository;

    //POST MAPPING
    public Country insertCountry(Country country){
        Country newCountry = new Country();
        newCountry.setCountryName(country.getCountryName());
        countryRepository.save(newCountry);
        return newCountry;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //GET MAPPING
    public List<Country> getAllCountry(Long page, Long pageSize){
        List<Country> someCountry;
        List<Hotel> someHotel;
        Pageable pageable = PageRequest.of(Math.toIntExact(page - 1), Math.toIntExact(pageSize));
        someCountry = countryRepository.findAll(pageable).toList();
        for(Country country : someCountry){
            someHotel = hotelRepository.findByLocation(country.getCountryName());
        }
        return someCountry;
    }

    public List<Country> redirectingRequest(Long page, Long pageSize, String countryName){
        if (countryName != null){
            List<Country> country= countryRepository.findByCountryName(countryName);
            return country;
        }else {
            return this.getAllCountry(page, pageSize);
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //DELETE MAPPING
    public String deleteCountry(Long id){
        countryRepository.deleteById(id);
        return "delete successfully";
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //PUT MAPPING
    public Country putUpdate(Long id, String countryName){
        Country country = countryRepository.findById(id)
                .orElseThrow(()->new NullPointerException("not found"));
        country.setCountryName(countryName);
        countryRepository.save(country);
        return country;
    }
}
