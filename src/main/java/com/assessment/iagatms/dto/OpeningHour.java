
package com.assessment.iagatms.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dayOfWeek",
    "hours"
})
@Generated("jsonschema2pojo")
@Data
public class OpeningHour {

    @JsonProperty("dayOfWeek")
    private Integer dayOfWeek;
    @JsonProperty("hours")
    private List<Hour> hours;

}