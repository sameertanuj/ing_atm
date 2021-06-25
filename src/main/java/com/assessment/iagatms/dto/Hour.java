
package com.assessment.iagatms.dto;

import java.util.HashMap;
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
    "hourFrom",
    "hourTo"
})
@Generated("jsonschema2pojo")
@Data
public class Hour {

    @JsonProperty("hourFrom")
    private String hourFrom;
    @JsonProperty("hourTo")
    private String hourTo;

}
