package com.project.bedroommanagement.mapper;

import com.project.bedroommanagement.model.TypeLocation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class BedroomMapper implements Serializable {
    private Boolean reserved;
    private Double locationPrice;
    private TypeLocation typeLocation;
    private List<Long> idTypeBedroom;
    private Long idHotel;
}
