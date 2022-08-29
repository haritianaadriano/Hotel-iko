package com.project.bedroommanagement.repository;

import com.project.bedroommanagement.model.TypeBedroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeBedroomRepository extends JpaRepository<TypeBedroom, Long> {

}
