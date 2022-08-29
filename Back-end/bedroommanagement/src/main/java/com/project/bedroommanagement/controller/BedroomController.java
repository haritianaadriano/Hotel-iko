package com.project.bedroommanagement.controller;

import com.project.bedroommanagement.mapper.BedroomMapper;
import com.project.bedroommanagement.model.Bedroom;
import com.project.bedroommanagement.service.BedroomService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class BedroomController {
    private BedroomService bedroomService;

    @PostMapping("/bedroom")
    public Bedroom insertBedroom(@RequestBody BedroomMapper newBedroom){
        return bedroomService.insertBedroom(newBedroom);
    }

    @GetMapping("/bedrooms")
    public List<Bedroom> getAllBedrooms(
            @RequestParam(name = "page", required = false)Long page,
            @RequestParam(name = "page_size", required = false)Long pageSize,
            @RequestParam(name = "location_price", required = false)Double locationPrice
    ){
        return bedroomService.redirectingRequest(page, pageSize, locationPrice);
    }

    @GetMapping("/bedrooms_available")
    public List<Bedroom> getAllBedroomsAvailable(){
        return bedroomService.getAllBedroomsFilteredByAvailable();
    }

    @PutMapping("/bedroom/{id}")
    public Bedroom putUpdate(
            @PathVariable(name = "id")Long id,
            @RequestBody Bedroom newBedroom
    ){
        return bedroomService.putUpdateBedroomById(id, newBedroom);
    }

    @PatchMapping("/bedroom/{id}")
    public Bedroom patchUpdate(
            @PathVariable(name = "id")Long id,
            @RequestBody Bedroom newBedroom
    ){
        return bedroomService.patchUpdateBedroomById(id, newBedroom);
    }

    @DeleteMapping("/bedroom/{id}")
    public String deleteBedroomById(@PathVariable(name = "id")Long id){
        return bedroomService.deleteBedroomById(id);
    }
}
