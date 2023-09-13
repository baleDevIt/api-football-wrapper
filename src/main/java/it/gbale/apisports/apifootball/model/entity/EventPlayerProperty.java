package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class EventPlayerProperty {

    @SerializedName("id")
    private final Integer playerId;

    @SerializedName("name")
    private final String playerName;

}
