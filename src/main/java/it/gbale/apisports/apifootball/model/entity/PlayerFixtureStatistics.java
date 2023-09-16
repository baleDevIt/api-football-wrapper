package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PlayerFixtureStatistics implements Serializable {

    @SerializedName("team")
    private final TeamEssential team;

    @SerializedName("players")
    private final List<Player> players;
}
