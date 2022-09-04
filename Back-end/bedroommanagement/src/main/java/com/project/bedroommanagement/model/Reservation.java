package com.project.bedroommanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    @Column(nullable = false)
    private Double totalLocationPrice;

    private LocalDate dateReservation;

    private Boolean paiementComplet;

    @OneToOne
    private Customer customer;

    @OneToMany(targetEntity = Bedroom.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "bedroom_fk", referencedColumnName = "idReservation")
    private List<Bedroom> bedroom;
}
