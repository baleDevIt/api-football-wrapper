package it.gbale.apisports.apifootball.model.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ApiResponse <T>{


    @JsonProperty("get")
    private String get;
    @JsonProperty("parameters")
    private Map<String, String> parameters;
    @JsonProperty("errors")
    private Map<String, String> errors;
    @JsonProperty("results")
    private Integer results;
    @JsonProperty("paging")
    private Paging paging;
    @JsonProperty("response")
    private List<T> response;
}
