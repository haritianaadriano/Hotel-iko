package com.project.bedroommanagement.controller;

import com.project.bedroommanagement.mapper.BedroomMapper;
import com.project.bedroommanagement.model.Bedroom;
import com.project.bedroommanagement.service.BedroomService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
public class BedroomController {
    private BedroomService bedroomService;

    //POST
    @PostMapping("/hotel-room")
    public Bedroom insertBedroom(@RequestBody BedroomMapper newBedroom){
        return bedroomService.insertBedroom(newBedroom);
    }

    //GET
    @GetMapping("/hotel-rooms")
    public List<Bedroom> getAllBedrooms(
            @RequestParam(name = "page", required = false)Long page,
            @RequestParam(name = "page_size", required = false)Long pageSize,
            @RequestParam(name = "location_price", required = false)Double locationPrice,
            @RequestParam(name = "name_hotel", required = false)String hotelName
    ){
        return bedroomService.redirectingRequest(page, pageSize, locationPrice, hotelName);
    }

    //GET
    @GetMapping("/hotel-rooms-available")
    public List<Bedroom> getAllBedroomsAvailable(){
        return bedroomService.getAllBedroomsFilteredByAvailable();
    }

    //PUT
    @PutMapping("/hotel-room/{id}")
    public Bedroom putUpdate(
            @PathVariable(name = "id")Long id,
            @RequestBody Bedroom newBedroom
    ){
        return bedroomService.putUpdateBedroomById(id, newBedroom);
    }

    //PATCH
    @PatchMapping("/hotel-room/{id}")
    public Bedroom patchUpdate(
            @PathVariable(name = "id")Long id,
            @RequestBody Bedroom newBedroom
    ){
        return bedroomService.patchUpdateBedroomById(id, newBedroom);
    }

    //DELETE
    @DeleteMapping("/hotel-room/{id}")
    public String deleteBedroomById(@PathVariable(name = "id")Long id){
        return bedroomService.deleteBedroomById(id);
    }
}
