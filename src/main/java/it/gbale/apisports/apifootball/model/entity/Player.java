package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Player implements Serializable {

    @SerializedName("player")
    private final PlayerEssential playerInfo;

    @SerializedName("statistics")
    private final List<PlayerStatistics> playerStatistics;
}
