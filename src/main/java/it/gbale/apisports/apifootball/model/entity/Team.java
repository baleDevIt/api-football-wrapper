package it.gbale.apisports.apifootball.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.net.URI;
import java.time.Year;

@Data
public class Team {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;

    @JsonProperty("code")
    private String code;
    @JsonProperty("country")
    private String country;
    @JsonProperty("founded")
    private Year founded;
    @JsonProperty("national")
    private boolean national;
    @JsonProperty("logo")
    private URI logo;

    //TODO: Controllare se integrare l'oggetto Venue
}
