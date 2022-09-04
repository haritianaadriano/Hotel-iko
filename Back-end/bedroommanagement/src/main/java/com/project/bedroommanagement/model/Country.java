package com.project.bedroommanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCountry;

    @Column(length = 100)
    private String countryName;

    @OneToMany(targetEntity = Hotel.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_fk", referencedColumnName = "idCountry")
    private List<Hotel> hotel;
}
