package com.project.bedroommanagement.service;

import com.project.bedroommanagement.mapper.BedroomMapper;
import com.project.bedroommanagement.model.Bedroom;
import com.project.bedroommanagement.model.Hotel;
import com.project.bedroommanagement.model.TypeBedroom;
import com.project.bedroommanagement.repository.BedroomRepository;
import com.project.bedroommanagement.repository.HotelRepository;
import com.project.bedroommanagement.repository.TypeBedroomRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BedroomService {
    private BedroomRepository bedroomRepository;
    private HotelRepository hotelRepository;
    private TypeBedroomRepository typeBedroomRepository;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //POST MAPPING
    /**
     * Post mapping for inserting a new bedroom -> POST "/bedroom"
     * @param bedroomMapper the bedroom params to adapt into model
     * @return new bedroom
     */
    public Bedroom insertBedroom(BedroomMapper bedroomMapper){
        //variable sector
        Bedroom newBedroom = new Bedroom();
        List<Long> listIdTypeBedroom = bedroomMapper.getIdTypeBedroom();
        List<TypeBedroom> newtypeBedrooms = new ArrayList<>();

        //mapping the parameter to adapting into model
        //-> 1.insert the simple attribute
        newBedroom.setReserved(bedroomMapper.getReserved());
        newBedroom.setLocationPrice(bedroomMapper.getLocationPrice());
        newBedroom.setTypeLocation(bedroomMapper.getTypeLocation());

        //-> 2.insert the name of hotel
        Hotel hotel = hotelRepository.findById(bedroomMapper.getIdHotel())
                .orElseThrow(()->new NullPointerException("the hotel in "+bedroomMapper.getIdHotel()+" is not found"));
        newBedroom.setHotel(hotel.getNameHotel());

        //-> 3. insert list of type of bedroom
        for(Long idTypeBedroom : listIdTypeBedroom){
            TypeBedroom typeBedroom = typeBedroomRepository.findById(idTypeBedroom)
                    .orElseThrow(()->new NullPointerException("not found"));
            newtypeBedrooms.add(typeBedroom);
        }
        newBedroom.setTypeBedroom(newtypeBedrooms);

        //-> 4. save and insert in database
        bedroomRepository.save(newBedroom);
        return newBedroom;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //GET MAPPING
    /**
     * Get mapping get all bedrooms with pagination -> (pagination is not obligatory)
     * @param page page you want to have
     * @param pageSize page-size you want to have
     * @return List of bedroom
     */
    public List<Bedroom> getAllBedrooms(Long page, Long pageSize){
        if(page != null && pageSize != null){
            Pageable pageable = PageRequest.of(Math.toIntExact(page - 1), Math.toIntExact(pageSize));
            return bedroomRepository.findAll(pageable).toList();
        }else {
            return bedroomRepository.findAll();
        }
    }

    /**
     * Get mapping -> return all bedroom available
     * @return list of bedrooms
     */
    public List<Bedroom> getAllBedroomsFilteredByAvailable(){
        return bedroomRepository.findByReserved(false);
    }

    /**
     * find bedroom by location price you make in params
     * @param locationPrice location price
     * @return list of bedroom filter by location price
     */
    public List<Bedroom> getBedroomByLocationPrice(Double locationPrice){
        return bedroomRepository.findByLocationPrice(locationPrice);
    }

    public List<Bedroom> getBedroomByHotelName(String hotelName){
        return bedroomRepository.findByHotel(hotelName);
    }

    public Bedroom getBedroomById(Long id){
        Bedroom theBedroom = bedroomRepository.findById(id)
                .orElseThrow(()->new RuntimeException("not found"));
        return theBedroom;
    }

    /**
     * just a function redirecting request to help request to do our task
     * @param page number of page you want to have
     * @param pageSize page size you want to have
     * @param locationPrice location price to filter bedroom list
     * @return list of bedroom
     */
    public List<Bedroom> redirectingRequest(Long page, Long pageSize, Double locationPrice, String hotelName){
        if(locationPrice != null && page == null && pageSize == null && hotelName == null){
            return this.getBedroomByLocationPrice(locationPrice);
        }
        else if(locationPrice == null && page == null && pageSize == null && hotelName != null){
            return this.getBedroomByHotelName(hotelName);
        }
        else{
            return this.getAllBedrooms(page, pageSize);
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //PUT MAPPING
    /**
     * Update the bedroom specified in parameter
     * @param id id of bedroom
     * @param newBedroom the bedroom change
     * @return the new-bedroom update
     */
    public Bedroom putUpdateBedroomById(Long id, Bedroom newBedroom){
        Bedroom bedroom = bedroomRepository.findById(id)
                        .orElseThrow(()-> new NullPointerException("not found"));

        bedroom.setReserved(newBedroom.getReserved());
        bedroom.setTypeBedroom(newBedroom.getTypeBedroom());
        bedroom.setLocationPrice(newBedroom.getLocationPrice());
        bedroom.setTypeLocation(newBedroom.getTypeLocation());
        bedroomRepository.save(bedroom);

        return bedroom;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //PATCH MAPPING
    /**
     * Update the bedroom with some attribute in parameter with "PATCH" method
     * @param id id of bedroom
     * @param newBedroom some attribute of bedroom to change
     * @return the new-bedroom
     */
    public Bedroom patchUpdateBedroomById(Long id, Bedroom newBedroom){
        Bedroom bedroom = bedroomRepository.findById(id)
                .orElseThrow(()->new NullPointerException("not found"));

        if(newBedroom.getReserved() != null){
            bedroom.setReserved(newBedroom.getReserved());
            bedroomRepository.save(bedroom);
        }
        if(newBedroom.getTypeBedroom()!= null){
            bedroom.setTypeBedroom(newBedroom.getTypeBedroom());
            bedroomRepository.save(bedroom);
        }
        if(newBedroom.getLocationPrice()!= null){
            bedroom.setLocationPrice(newBedroom.getLocationPrice());
            bedroomRepository.save(bedroom);
        }
        if(newBedroom.getTypeLocation()!= null){
            bedroom.setTypeLocation(newBedroom.getTypeLocation());
            bedroomRepository.save(bedroom);
        }
        return bedroom;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //DELETE MAPPING
    /**
     * Delete the bedroom with the specific id in parameters
     * @param id id of the bedroom to delete
     * @return String to confirm the delete mapping
     */
    public String deleteBedroomById(Long id){
        Optional<Bedroom> bedroomOptional = bedroomRepository.findById(id);
        if(bedroomOptional.isPresent()){
            bedroomRepository.deleteById(id);
            return "bedroom deleted";
        }else if(!bedroomOptional.isPresent()){
            throw new RuntimeException("sorry bedroom not found");
        }else{
            return "in process";
        }
    }
}