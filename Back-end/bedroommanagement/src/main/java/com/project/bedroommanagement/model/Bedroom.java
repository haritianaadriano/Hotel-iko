package com.project.bedroommanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
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

    private Boolean reserved;

    private Double locationPrice;

    private String hotel;

    @OneToOne
    private TypeLocation typeLocation;

    @OneToMany(targetEntity = TypeBedroom.class, cascade =  CascadeType.ALL)
    @JoinColumn(name = "type_bedroom_fk", referencedColumnName = "idBedroom")
    private List<TypeBedroom> typeBedroom = new ArrayList<>();
}
