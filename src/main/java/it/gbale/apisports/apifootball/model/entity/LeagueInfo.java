package it.gbale.apisports.apifootball.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.net.URI;

@Data
@EqualsAndHashCode
public class LeagueInfo {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;
    @JsonProperty("logo")
    private URI logo;
}
