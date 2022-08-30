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
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHotel;

    @Column(nullable = false)
    private String nameHotel;

    @OneToOne
    private TypeHotel typeHotel;

    @OneToMany(targetEntity = Bedroom.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "bedroom_fk", referencedColumnName = "idHotel")
    private List<Bedroom> bedroom = new ArrayList<>();
}
