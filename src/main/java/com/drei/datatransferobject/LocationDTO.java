package com.drei.datatransferobject;

import com.drei.domainvalue.LocationType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocationDTO {

    @JsonProperty("id")
    private Long id;

    @NotNull
    @JsonProperty("name")
    private String name;

    @NotNull
    @JsonProperty("lat")
    private double latitude;

    @NotNull
    @JsonProperty("lng")
    private double longitude;

    @NotNull
    @Enumerated(EnumType.STRING)
    @JsonProperty("type")
    private LocationType type;
}
