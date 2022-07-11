package com.drei.controller;

import com.drei.controller.mapper.LocationMapper;
import com.drei.datatransferobject.LocationDTO;
import com.drei.datatransferobject.PointDTO;
import com.drei.domainobject.LocationDO;
import com.drei.domainvalue.LocationType;
import com.drei.exception.ConstraintsViolationException;
import com.drei.service.LocationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("location")
public class LocationController {

    private final LocationService service;

    @Autowired
    public LocationController(final LocationService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LocationDTO createLocation(@Valid @RequestBody LocationDTO locationDTO) throws ConstraintsViolationException {
        LocationDO locationDO = LocationMapper.makeLocationDO(locationDTO);
        return LocationMapper.makeLocationDTO(service.create(locationDO));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LocationDTO> findByType(@RequestParam LocationType locationType) {
        return LocationMapper.makeLocationDTOList(service.findAllByType(locationType));
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<LocationDTO> searchLocation(@RequestParam( value = "locationType", required = false) LocationType locationType, @RequestParam("p1") String p1Json,
                                            @RequestParam("p2") String p2Json, @RequestParam("limit") int limit) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        PointDTO point1 = mapper.readValue(p1Json, PointDTO.class);
        PointDTO point2 = mapper.readValue(p2Json, PointDTO.class);
        return LocationMapper.makeLocationDTOList(service.searchLocation(locationType,point1,point2,limit));
    }
}
