package com.project.bedroommanagement.mapper;

import com.project.bedroommanagement.model.TypeHotel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class HotelMapper {
    private String nameHotel;
    private TypeHotel typeHotel;
    private List<Long> bedrooms;
}
