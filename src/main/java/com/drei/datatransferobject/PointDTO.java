package com.drei.datatransferobject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PointDTO implements Serializable {

    @NotNull
    @JsonProperty("lat")
    private double latitude;

    @NotNull
    @JsonProperty("lng")
    private double longitude;

}
