package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.net.URI;

@Data
public class TeamLineupProperty {

    @SerializedName("id")
    private final Integer teamId;

    @SerializedName("name")
    private final String teamName;

    @SerializedName("logo")
    private final URI teamLogo;

    @SerializedName("colors")
    private final ColorsTeamProperty colorsTeamProperty;


}
