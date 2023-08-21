package it.gbale.apisports.apifootball.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

@Data
@ToString
public class League implements Serializable {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;
    @JsonProperty("logo")
    private URI logo;

    @JsonProperty("country")
    Countries country;

    @JsonProperty("seasons")
    List<Season> seasons;



}
