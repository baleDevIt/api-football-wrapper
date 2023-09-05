package it.gbale.apisports.apifootball.model.entity;


import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class TeamsInLeagueStatistics implements Serializable {

    @SerializedName("home")
    TeamStatistic homeTeam;

    @SerializedName("away")
    TeamStatistic awayTeam;


}
