package com.drei.domainobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.drei.domainvalue.LocationType;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "location")
public class LocationDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("lat")
    private double latitude;

    @JsonProperty("lng")
    private double longitude;

    @Enumerated(EnumType.STRING)
    @JsonProperty("type")
    private LocationType type;

}
