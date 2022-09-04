package com.project.bedroommanagement.mapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ReservationMapper {
    private LocalDate dateReservation;
    private Boolean paiementComplet;
    private Long customer;
    private List<Long> bedroom;
}
