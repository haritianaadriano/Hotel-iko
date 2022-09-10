package com.project.bedroommanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TypeHotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHotelType;

    @Column(nullable = true)
    private String image;

    private String hotelType;
}
