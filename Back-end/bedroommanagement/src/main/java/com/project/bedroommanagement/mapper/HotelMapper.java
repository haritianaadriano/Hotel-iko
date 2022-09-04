package com.project.bedroommanagement.mapper;

import com.project.bedroommanagement.model.TypeHotel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class HotelMapper implements Serializable {
    private String nameHotel;
    private TypeHotel typeHotel;
    private Long country;
    private List<Long> bedrooms;
}
