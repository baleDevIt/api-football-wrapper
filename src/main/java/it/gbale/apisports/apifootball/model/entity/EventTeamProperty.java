package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.net.URI;

@Data
public class EventTeamProperty {

    @SerializedName("id")
    private final Integer teamId;

    @SerializedName("name")
    private final String teamName;

    @SerializedName("logo")
    private final URI logo;

}
