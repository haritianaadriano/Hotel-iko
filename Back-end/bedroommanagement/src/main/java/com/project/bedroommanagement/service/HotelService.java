package com.project.bedroommanagement.service;

import com.project.bedroommanagement.mapper.HotelMapper;
import com.project.bedroommanagement.model.Bedroom;
import com.project.bedroommanagement.model.Hotel;
import com.project.bedroommanagement.repository.BedroomRepository;
import com.project.bedroommanagement.repository.HotelRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HotelService {
    //variable sector
    private HotelRepository hotelRepository;
    private BedroomRepository bedroomRepository;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //GET MAPPING
    /**
     * Get -> all hotels list
     * @param page page you want to have
     * @param pageSize size of the page you want to have
     * @return list of hotels
     */
    public List<Hotel> getAllHotels(Long page, Long pageSize){
        if(page != null && pageSize != null){
            Pageable pageable = PageRequest.of(Math.toIntExact(page - 1), Math.toIntExact(pageSize));
            return hotelRepository.findAll(pageable).toList();
        }else {
            return hotelRepository.findAll();
        }
    }

    public List<Hotel> getHotelByName(String nameHotel){
        return hotelRepository.findByNameHotel(nameHotel);
    }

    public List<Hotel> redirectingRequest(Long page, Long pageSize, String nameHotel){
        if(nameHotel != null && page == null && pageSize == null){
            return this.getHotelByName(nameHotel);
        }else {
            return this.getAllHotels(page, pageSize);
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //POST MAPPING
    /**
     * Inserting the hotel
     * @param hotelMapper parameter for adapting the request-body to model
     * @return the new-hotel inserted
     */
    public Hotel insertHotel(HotelMapper hotelMapper){
        Hotel newHotel = new Hotel();
        List<Bedroom> bedroomListForHotel = new ArrayList<>();
        List<Long>  bedroomList= hotelMapper.getBedrooms();

        newHotel.setNameHotel(hotelMapper.getNameHotel());
        newHotel.setTypeHotel(hotelMapper.getTypeHotel());
        for(Long id : bedroomList){
            Optional<Bedroom> bedroomOptional = bedroomRepository.findById(id);
            Bedroom bedroom;
            if(bedroomOptional.isPresent()){
                bedroom = bedroomOptional.get();
                bedroomListForHotel.add(bedroom);
            }else {
                throw new NullPointerException("not found");
            }
        }
        newHotel.setBedroom(bedroomListForHotel);
        hotelRepository.save(newHotel);
        return newHotel;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //PUT MAPPING
    /**
     * Update the hotel with some modification
     * @param id id for search the hotel
     * @param hotelMapper the parameter to adapt the parameter to the model
     * @return the hotel updated
     */
    public Hotel putUpdate(Long id, HotelMapper hotelMapper){
        Optional<Hotel> hotelOptional = hotelRepository.findById(id);
        List<Bedroom> bedroomList = new ArrayList<>();
        Hotel hotel;

        if (hotelOptional.isPresent()){
            hotel = hotelOptional.get();
            hotel.setNameHotel(hotelMapper.getNameHotel());
            hotel.setTypeHotel(hotelMapper.getTypeHotel());

            for (Long idBedroom : hotelMapper.getBedrooms()){
                Bedroom bedroom = bedroomRepository.findById(idBedroom).get();
                bedroomList.add(bedroom);
            }
            hotel.setBedroom(bedroomList);
            hotelRepository.save(hotel);
        }else {
            throw new NullPointerException("not found");
        }
        return hotel;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //DELETE MAPPING
    public String deleteHotel(Long id){
        hotelRepository.deleteById(id);
        return "deleted successfully";
    }
}