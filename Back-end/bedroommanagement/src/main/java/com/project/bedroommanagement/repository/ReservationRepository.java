package com.project.bedroommanagement.repository;

import com.project.bedroommanagement.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByDateReservation(LocalDate dateReservation);
    List<Reservation> findByPaiementComplet(Boolean paiement);
    Reservation findByCustomerIdCustomer(Long id);
}
