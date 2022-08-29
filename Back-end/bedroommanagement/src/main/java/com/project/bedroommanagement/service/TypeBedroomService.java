package com.project.bedroommanagement.service;

import com.project.bedroommanagement.model.TypeBedroom;
import com.project.bedroommanagement.repository.TypeBedroomRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TypeBedroomService {
    private TypeBedroomRepository typeBedroomRepository;

    public List<TypeBedroom> getAllTypeBedroom(Long page, Long pageSize){
        if(page != null && pageSize != null){
            Pageable pageable = PageRequest.of(Math.toIntExact(page-1), Math.toIntExact(pageSize));
            return typeBedroomRepository.findAll(pageable).toList();
        }else {
            return typeBedroomRepository.findAll();
        }
    }

    public TypeBedroom insertTypeBedroom(TypeBedroom typeBedroom){
        typeBedroomRepository.save(typeBedroom);
        return typeBedroom;
    }

    public TypeBedroom putUpdate(Long id ,String newTypeBedroom){
        Optional<TypeBedroom> typeBedroomOptional = typeBedroomRepository.findById(id);
        TypeBedroom typeBedroom;
        if(typeBedroomOptional.isPresent()){
            typeBedroom = typeBedroomOptional.get();
        }else {
            throw new NullPointerException("not found");
        }
        typeBedroom.setBedroomType(newTypeBedroom);
        typeBedroomRepository.save(typeBedroom);
        return typeBedroom;
    }

    public String deleteTypeBedroom(Long id){
        typeBedroomRepository.deleteById(id);
        return "deleted successfully";
    }
}
