package com.project.bedroommanagement.service;

import com.project.bedroommanagement.model.TypeBedroom;
import com.project.bedroommanagement.model.TypeHotel;
import com.project.bedroommanagement.repository.TypeHotelRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TypeHotelService {
    private TypeHotelRepository typeHotelRepository;

    public List<TypeHotel> getAllTypeHotel(Long page, Long pageSize){
        if(page != null && pageSize != null){
            Pageable pageable = PageRequest.of(Math.toIntExact(page-1), Math.toIntExact(pageSize));
            return typeHotelRepository.findAll(pageable).toList();
        }else {
            return typeHotelRepository.findAll();
        }
    }

    public TypeHotel putUpdate (Long id, TypeHotel typeHotel){
        Optional<TypeHotel> typeHotelOptional = typeHotelRepository.findById(id);
        TypeHotel typeHotelToUpdate;
        if(typeHotelOptional.isPresent()){
            typeHotelToUpdate = typeHotelOptional.get();
            typeHotelToUpdate.setHotelType(typeHotel.getHotelType());
            typeHotelRepository.save(typeHotelToUpdate);
        }else {
            throw new NullPointerException("not found");
        }
        return typeHotelToUpdate;
    }

    public TypeHotel isenrtTypeHotel(TypeHotel typeHotel){
        typeHotelRepository.save(typeHotel);
        return typeHotel;
    }

    public String deleteTypeHotel(Long id){
        typeHotelRepository.deleteById(id);
        return "deleted successfully";
    }
}
