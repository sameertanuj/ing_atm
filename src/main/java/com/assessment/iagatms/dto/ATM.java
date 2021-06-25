
package com.assessment.iagatms.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "address",
    "distance",
    "openingHours",
    "functionality",
    "type"
})
@Generated("jsonschema2pojo")
@Document
@Data
public class ATM {

    @JsonProperty("address")
    @Indexed(unique = true)
    private Address address;
    @JsonProperty("distance")
    private Integer distance;
    @JsonProperty("openingHours")
    private List<OpeningHour> openingHours;
    @JsonProperty("functionality")
    private String functionality;
    @JsonProperty("type")
    private String type;

}
