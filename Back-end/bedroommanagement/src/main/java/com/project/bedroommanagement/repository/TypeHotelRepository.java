package com.project.bedroommanagement.repository;

import com.project.bedroommanagement.model.TypeHotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeHotelRepository extends JpaRepository<TypeHotel, Long> {
}
