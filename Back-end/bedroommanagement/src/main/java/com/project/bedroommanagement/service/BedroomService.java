package com.project.bedroommanagement.service;

import com.project.bedroommanagement.mapper.BedroomMapper;
import com.project.bedroommanagement.model.Bedroom;
import com.project.bedroommanagement.model.TypeBedroom;
import com.project.bedroommanagement.repository.BedroomRepository;
import com.project.bedroommanagement.repository.TypeBedroomRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BedroomService {
    private BedroomRepository bedroomRepository;
    private TypeBedroomRepository typeBedroomRepository;

    public Bedroom insertBedroom(BedroomMapper bedroomMapper){
        Bedroom newBedroom = new Bedroom();
        List<Long> listIdTypeBedroom = bedroomMapper.getIdTypebedroom();
        List<TypeBedroom> newtypeBedrooms = new ArrayList<>();
        newBedroom.setReserved(bedroomMapper.getReserved());
        newBedroom.setLocationPrice(bedroomMapper.getLocationPrice());
        newBedroom.setTypeLocation(bedroomMapper.getTypeLocation());

        for(Long idTypeBedroom : listIdTypeBedroom){
            TypeBedroom typeBedroom;
            Optional<TypeBedroom>typeBedroomOptional = typeBedroomRepository.findById(idTypeBedroom);
            if(typeBedroomOptional.isPresent()){
                typeBedroom = typeBedroomOptional.get();
                newtypeBedrooms.add(typeBedroom);
            }else{
                throw new NullPointerException("sorry not found");
            }
        }
        newBedroom.setTypeBedroom(newtypeBedrooms);
        bedroomRepository.save(newBedroom);
        return newBedroom;
    }

    public List<Bedroom> getAllBedrooms(Long page, Long pageSize){
        if(page != null && pageSize != null){
            Pageable pageable = PageRequest.of(Math.toIntExact(page - 1), Math.toIntExact(pageSize));
            return bedroomRepository.findAll(pageable).toList();
        }else {
            return bedroomRepository.findAll();
        }
    }

    public List<Bedroom> getAllBedroomsFilteredByAvailable(){
        return bedroomRepository.findByReserved(false);
    }

    public List<Bedroom> getBedroomByLocationPrice(Double locationPrice){
        return bedroomRepository.findByLocationPrice(locationPrice);
    }

    public List<Bedroom> redirectingRequest(Long page, Long pageSize, Double locationPrice){
        if(locationPrice != null && page == null && pageSize == null){
            return this.getBedroomByLocationPrice(locationPrice);
        }else{
            return this.getAllBedrooms(page, pageSize);
        }
    }

    public Bedroom putUpdateBedroomById(Long id, Bedroom newBedroom){
        Optional<Bedroom> optionalBedroom = bedroomRepository.findById(id);
        Bedroom bedroom;
        if(optionalBedroom.isPresent()){
            bedroom = optionalBedroom.get();
        }else {
            throw new RuntimeException("sorry bedroom not found");
        }

        bedroom.setReserved(newBedroom.getReserved());
        bedroom.setTypeBedroom(newBedroom.getTypeBedroom());
        bedroom.setLocationPrice(newBedroom.getLocationPrice());
        bedroom.setTypeLocation(newBedroom.getTypeLocation());
        bedroomRepository.save(bedroom);

        return bedroom;
    }

    public Bedroom patchUpdateBedroomById(Long id, Bedroom newBedroom){
        Optional<Bedroom> optionalBedroom = bedroomRepository.findById(id);
        Bedroom bedroom;
        if(optionalBedroom.isPresent()){
            bedroom = optionalBedroom.get();
        }else {
            throw new RuntimeException("sorry bedroom not found");
        }

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

    public String deleteBedroomById(Long id){
        Optional<Bedroom> bedroomOptional = bedroomRepository.findById(id);
        if(bedroomOptional.isPresent()){
            bedroomRepository.deleteById(id);
            return "bedroom deleted";
        }else if(bedroomOptional.isPresent() == false){
            throw new RuntimeException("sorry bedroom not found");
        }else{
            return "in process";
        }
    }
}
