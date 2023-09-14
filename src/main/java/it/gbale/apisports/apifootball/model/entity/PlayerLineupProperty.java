package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class PlayerLineupProperty implements Serializable {

    @SerializedName("id")
    private final Integer playerId;

    @SerializedName("name")
    private final String playerName;

    @SerializedName("number")
    private final Integer playerNumber;

    @SerializedName("pos")
    private final String playerPosition;

    @SerializedName("grid")
    private final String gridPosition;
}
