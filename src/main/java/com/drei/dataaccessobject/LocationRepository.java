package com.drei.dataaccessobject;

import com.drei.datatransferobject.PointDTO;
import com.drei.domainobject.LocationDO;
import com.drei.domainvalue.LocationType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface LocationRepository extends CrudRepository<LocationDO, Long> {

    @Query(value = "SELECT l FROM location l WHERE " +
            "l.latitude >= :#{#p1.latitude} AND l.latitude <= :#{#p2.latitude} " +
            "AND l.longitude >= :#{#p1.longitude} AND l.longitude <= :#{#p2.longitude}" +
            " AND l.type IN :#{#locationTypes}")
    List<LocationDO> searchLocation(@Param("locationTypes") List<LocationType> locationTypes, @Param("p1") PointDTO p1, @Param("p2") PointDTO p2,
                                    Pageable pageable);


    List<LocationDO> findAllByType(LocationType locationType);

}
