package com.drei.controller.mapper;

import com.drei.datatransferobject.LocationDTO;
import com.drei.domainobject.LocationDO;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class LocationMapper {

    public static LocationDO makeLocationDO(LocationDTO locationDTO) {
        return LocationDO.builder()
                .name(locationDTO.getName())
                .latitude(locationDTO.getLatitude())
                .longitude(locationDTO.getLongitude())
                .type(locationDTO.getType())
                .build();
    }

    public static LocationDTO makeLocationDTO(LocationDO locationDO) {
        return LocationDTO.builder()
                .id(locationDO.getId())
                .name(locationDO.getName())
                .latitude(locationDO.getLatitude())
                .longitude(locationDO.getLongitude())
                .type(locationDO.getType())
                .build();
    }

    public static List<LocationDTO> makeLocationDTOList(Collection<LocationDO> locations){
        return locations.stream()
                .map(LocationMapper::makeLocationDTO)
                .collect(Collectors.toList());
    }

}
