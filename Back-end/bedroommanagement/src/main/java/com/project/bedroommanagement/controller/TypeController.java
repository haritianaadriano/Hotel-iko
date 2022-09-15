package com.project.bedroommanagement.controller;

import com.project.bedroommanagement.model.TypeBedroom;
import com.project.bedroommanagement.model.TypeHotel;
import com.project.bedroommanagement.model.TypeLocation;
import com.project.bedroommanagement.service.TypeBedroomService;
import com.project.bedroommanagement.service.TypeHotelService;
import com.project.bedroommanagement.service.TypeLocationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
public class TypeController {
    //Variable sector
    private TypeBedroomService bedroomService;
    private TypeHotelService hotelService;
    private TypeLocationService locationService;

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //GET MAPPING FOR ALL TYPE
    @GetMapping("/type_hotels")
    public List<TypeHotel> getAllTypeOfHotel(
            @RequestParam(name = "page", required = false)Long page,
            @RequestParam(name = "page_size", required = false)Long pageSize
    ){
        return hotelService.getAllTypeHotel(page, pageSize);
    }

    @GetMapping("/type_bedrooms")
    public List<TypeBedroom> getAllTypeOfBedroom(
            @RequestParam(name = "page", required = false)Long page,
            @RequestParam(name = "page_size", required = false)Long pageSize
    ){
        return bedroomService.getAllTypeBedroom(page, pageSize);
    }

    @GetMapping("/type_locations")
    public List<TypeLocation> getAllLocation(
            @RequestParam(name = "page", required = false)Long page,
            @RequestParam(name = "page_size", required = false)Long pageSize
    ){
        return locationService.getAllTypeLocation(page, pageSize);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //POST MAPPING FOR ALL TYPES
    @PostMapping("/type_bedroom")
    public TypeBedroom insertTypeBedroom(@RequestBody TypeBedroom newTypeBedroom){
        return bedroomService.insertTypeBedroom(newTypeBedroom);
    }

    @PostMapping("/type_hotel")
    public TypeHotel insertTypeHotel(@RequestBody TypeHotel newTypeHotel){
        return hotelService.isenrtTypeHotel(newTypeHotel);
    }

    @PostMapping("/type_location")
    public TypeLocation insertTypeLocation (@RequestBody TypeLocation newTypeLocation){
        return locationService.insertTypeLocation(newTypeLocation);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //DELETE MAPPING FOR ALL TYPES
    @DeleteMapping("/type_bedroom/{id}")
    public String deleteByIdTypeBedroom(@PathVariable(name = "id") Long id){
        return bedroomService.deleteTypeBedroom(id);
    }

    @DeleteMapping("/type_hotel/{id}")
    public String deleteByIdTypeHotel(@PathVariable(name = "id")Long id){
        return hotelService.deleteTypeHotel(id);
    }

    @DeleteMapping("/type_location/{id}")
    public String deleteByIdTypeLocation(@PathVariable(name = "id")Long id){
        return locationService.deleteTypeLocation(id);
    }
}
