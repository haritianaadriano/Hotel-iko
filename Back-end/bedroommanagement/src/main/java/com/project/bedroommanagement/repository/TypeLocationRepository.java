package com.project.bedroommanagement.repository;

import com.project.bedroommanagement.model.TypeLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeLocationRepository extends JpaRepository<TypeLocation, Long> {

}
