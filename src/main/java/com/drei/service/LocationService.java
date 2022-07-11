package com.drei.service;

import com.drei.datatransferobject.PointDTO;
import com.drei.domainobject.LocationDO;
import com.drei.domainvalue.LocationType;
import com.drei.exception.ConstraintsViolationException;
import com.drei.exception.EntityNotFoundException;

import java.util.List;

public interface LocationService {

    LocationDO create(LocationDO locationDO) throws ConstraintsViolationException;

    List<LocationDO> findAllByType(LocationType locationType);

    List<LocationDO> searchLocation(LocationType locationType, PointDTO p1, PointDTO p2, int limit);


}
