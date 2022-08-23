package com.project.bedroommanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bedroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBedroom;

    private Double locationPrice;

    @OneToOne
    private LocationType locationType;

    @OneToMany
    private List<BedroomType> bedroomTypes;
}
