package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.net.URI;
import java.time.Year;

@Data
public class Team {

    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;

    @SerializedName("code")
    private String code;
    @SerializedName("country")
    private String country;
    @SerializedName("founded")
    private Year founded;
    @SerializedName("national")
    private boolean national;
    @SerializedName("logo")
    private URI logo;

    //TODO: Controllare se integrare l'oggetto Venue
}
