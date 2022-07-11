package com.drei.service;

import com.drei.dataaccessobject.LocationRepository;
import com.drei.datatransferobject.PointDTO;
import com.drei.domainobject.LocationDO;
import com.drei.domainvalue.LocationType;
import com.drei.exception.ConstraintsViolationException;
import com.drei.exception.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DefaultLocationService implements LocationService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultLocationService.class);

    private final LocationRepository repository;

    public DefaultLocationService(final LocationRepository repository) {
        this.repository = repository;
    }

    @Override
    public LocationDO create(LocationDO locationDO) throws ConstraintsViolationException {

        LocationDO location;
        try {
            location = repository.save(locationDO);
        } catch (DataIntegrityViolationException e) {
            LOG.warn("ConstraintsViolationException while creating a location: {}", locationDO, e);
            throw new ConstraintsViolationException(e.getMessage());
        }

        return location;
    }

    @Override
    public List<LocationDO> findAllByType(LocationType locationType) {
        return repository.findAllByType(locationType);
    }

    @Override
    public List<LocationDO> searchLocation(LocationType locationType, PointDTO p1, PointDTO p2, int limit) {
        return repository.searchLocation(makeLocationTypes(locationType), p1, p2, PageRequest.of(0,limit, Sort.by("type").ascending()));
    }

    private List<LocationType> makeLocationTypes(LocationType locationType) {
        return locationType == null ? Arrays.asList(LocationType.PREMIUM, LocationType.STANDARD) : Arrays.asList(locationType);
    }
}
