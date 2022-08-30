package com.project.bedroommanagement.repository;

import com.project.bedroommanagement.model.Bedroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BedroomRepository extends JpaRepository<Bedroom, Long> {
    List<Bedroom> findByLocationPrice(Double locationPrice);

    List<Bedroom> findByReserved(Boolean search);

    List<Bedroom> findByHotel(String hotel);
}
