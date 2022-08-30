package com.project.bedroommanagement.controller;

import com.project.bedroommanagement.mapper.BedroomMapper;
import com.project.bedroommanagement.model.Bedroom;
import com.project.bedroommanagement.service.BedroomService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BedroomController {
    private BedroomService bedroomService;

    //POST
    @PostMapping("/bedroom")
    public Bedroom insertBedroom(@RequestBody BedroomMapper newBedroom){
        return bedroomService.insertBedroom(newBedroom);
    }

    //GET
    @GetMapping("/bedrooms")
    public List<Bedroom> getAllBedrooms(
            @RequestParam(name = "page", required = false)Long page,
            @RequestParam(name = "page_size", required = false)Long pageSize,
            @RequestParam(name = "location_price", required = false)Double locationPrice
    ){
        return bedroomService.redirectingRequest(page, pageSize, locationPrice);
    }

    //GET
    @GetMapping("/bedrooms_available")
    public List<Bedroom> getAllBedroomsAvailable(){
        return bedroomService.getAllBedroomsFilteredByAvailable();
    }

    //PUT
    @PutMapping("/bedroom/{id}")
    public Bedroom putUpdate(
            @PathVariable(name = "id")Long id,
            @RequestBody Bedroom newBedroom
    ){
        return bedroomService.putUpdateBedroomById(id, newBedroom);
    }

    //PATCH
    @PatchMapping("/bedroom/{id}")
    public Bedroom patchUpdate(
            @PathVariable(name = "id")Long id,
            @RequestBody Bedroom newBedroom
    ){
        return bedroomService.patchUpdateBedroomById(id, newBedroom);
    }

    //DELETE
    @DeleteMapping("/bedroom/{id}")
    public String deleteBedroomById(@PathVariable(name = "id")Long id){
        return bedroomService.deleteBedroomById(id);
    }
}
