package com.project.bedroommanagement.service;

import com.project.bedroommanagement.model.TypeLocation;
import com.project.bedroommanagement.repository.TypeLocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TypeLocationService {
    private TypeLocationRepository typeLocationRepository;

    public List<TypeLocation> getAllTypeLocation(Long page, Long pageSize){
        if(page != null && pageSize != null){
            Pageable pageable = PageRequest.of(Math.toIntExact(page-1), Math.toIntExact(pageSize));
            return typeLocationRepository.findAll(pageable).toList();
        }else {
            return typeLocationRepository.findAll();
        }
    }

    public TypeLocation insertTypeLocation(TypeLocation typeLocation){
        typeLocationRepository.save(typeLocation);
        return typeLocation;
    }

    public TypeLocation putUpdate(Long id ,String newTypeLocation){
        Optional<TypeLocation> typeLocationOptional = typeLocationRepository.findById(id);
        TypeLocation typeLocation;
        if(typeLocationOptional.isPresent()){
            typeLocation = typeLocationOptional.get();
        }else {
            throw new NullPointerException("not found");
        }
        typeLocation.setLocationType(newTypeLocation);
        typeLocationRepository.save(typeLocation);
        return typeLocation;
    }

    public String deleteTypeLocation(Long id){
        typeLocationRepository.deleteById(id);
        return "deleted successfully";
    }
}
