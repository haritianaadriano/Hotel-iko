package com.project.bedroommanagement.mapper;

import com.project.bedroommanagement.model.TypeLocation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class BedroomMapper {
    private Boolean reserved;
    private Double locationPrice;
    private TypeLocation typeLocation;
    private List<Long> idTypebedroom;
    private Long idHotel;
}
