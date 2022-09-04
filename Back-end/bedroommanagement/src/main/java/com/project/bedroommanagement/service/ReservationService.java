package com.project.bedroommanagement.service;

import com.project.bedroommanagement.mapper.ReservationMapper;
import com.project.bedroommanagement.model.Bedroom;
import com.project.bedroommanagement.model.Customer;
import com.project.bedroommanagement.model.Reservation;
import com.project.bedroommanagement.repository.BedroomRepository;
import com.project.bedroommanagement.repository.CustomerRepository;
import com.project.bedroommanagement.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService {
    private ReservationRepository reservationRepository;
    private CustomerRepository customerRepository;
    private BedroomRepository bedroomRepository;

    //GET MAPPING
    public List<Reservation> getAllReservation(int page, int pageSize){
        //variable sector
        LocalDate now = LocalDate.now();
        List<Bedroom> bedroomList;
        //functionnement
        Pageable pageable = PageRequest.of(page-1, pageSize);
        List<Reservation> allReservation = reservationRepository.findAll(pageable).toList();
        for(Reservation reservation : allReservation){
            if(reservation.getDateReservation() == now){
                bedroomList = reservation.getBedroom();
                for(Bedroom bedroom : bedroomList){
                    bedroom.setReserved(true);
                }
            }
        }
        return allReservation;
    }

    //GET -> reservation by Customer
    public Reservation getReservationByCustomer(Long idCustomer){
        return reservationRepository.findByCustomerIdCustomer(idCustomer);
    }

    //GET -> all reservation with "paiement" completed
    public List<Reservation> getReservationWithPaiementCompleted(){
        return reservationRepository.findByPaiementComplet(true);
    }

    //GET -> filtered by date
    public List<Reservation> getReservationByDateReservation(LocalDate dateReservation){
        return reservationRepository.findByDateReservation(dateReservation);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //POST MAPPING
    /**
     * this function inserts the reservation in the database
     * @param reservationMapper just the reservation to mapp in the model class
     * @return
     */
    public Reservation insertNewReservation(ReservationMapper reservationMapper){
        //variable sector
        Double priceOfReservation = 0D;

        //1.find the customer
        Customer customer = customerRepository.findById(reservationMapper.getCustomer())
                .orElseThrow(()->new NullPointerException("not found"));

        //2.find all bedroom to reserved
        List<Bedroom> bedroomReserved = new ArrayList<>();
        for(int i=0; i<reservationMapper.getBedroom().size(); i++){
            Bedroom bedroom = bedroomRepository.findById(reservationMapper.getBedroom().get(i))
                    .orElseThrow(()->new NullPointerException("not found"));
            priceOfReservation += bedroom.getLocationPrice();
            bedroomReserved.add(bedroom);
        }
        //3.Construct the new reservation
        Reservation newReservation = new Reservation();
        newReservation.setDateReservation(reservationMapper.getDateReservation());
        newReservation.setCustomer(customer);
        newReservation.setPaiementComplet(reservationMapper.getPaiementComplet());
        newReservation.setBedroom(bedroomReserved);

        //4.Calcul the total of the reservation
        newReservation.setTotalLocationPrice(priceOfReservation);

        //5.Insert the reservation in the data-base
        reservationRepository.save(newReservation);
        return newReservation;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //DELETE MAPPING
    /**
     * this function has a function to delete a reservation after that the client finish their reservation
     * @return a confirmation
     */
    public String deleteReservationAfterReservation(){
        LocalDate delay = LocalDate.now();
        List<Reservation> allReservation = reservationRepository.findByDateReservation(delay);
        for (Reservation reservation : allReservation){
            List<Bedroom> bedroomList = reservation.getBedroom();

            for(Bedroom bedroom : bedroomList){
                bedroom.setReserved(false);
            }
            reservationRepository.deleteById(reservation.getIdReservation());
        }
        return "list is update";
    }
}
