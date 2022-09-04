package com.project.bedroommanagement.repository;

import com.project.bedroommanagement.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByNameHotel(String nameHotel);
    List<Hotel> findByLocation(String location);
}
