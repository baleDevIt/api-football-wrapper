package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.net.URI;

@Data
public class TeamStatistic {

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;
    @SerializedName("logo")
    private URI logo;

    @SerializedName("last_5")
    private LastFiveStatistics lastFiveStatistics;

//    @SerializedName("league")
//    private TeamLeagueStatistics teamLeagueStatistics;

}
