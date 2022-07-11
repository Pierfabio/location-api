package com.drei.domainvalue;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum LocationType {

    @JsonProperty("premium") PREMIUM, @JsonProperty("standard") STANDARD;

}
