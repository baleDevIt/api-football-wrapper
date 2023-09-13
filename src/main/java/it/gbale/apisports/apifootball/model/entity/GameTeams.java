package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.net.URI;
import java.util.Map;

@Data
class GameTeams{

    private Integer teamHomeId;
    private String teamHomeName;
    private URI teamHomeLogo;
    private Boolean teamHomeWinner;


    private Integer teamAwayId;
    private String teamAwayName;
    private URI teamAwayLogo;
    private boolean teamAwayWinner;

    @SerializedName("home")
    @SuppressWarnings("unused")
    private void setterHomeTeamNestedObject(Map<String, String> status) {
        this.teamHomeId = Integer.valueOf(status.getOrDefault("id", "0"));
        this.teamHomeName = status.getOrDefault("name", null);
        this.teamHomeLogo = URI.create(status.getOrDefault("logo", null));
        this.teamHomeWinner = Boolean.valueOf(status.getOrDefault("short", "false"));
    }

    @SerializedName("away")
    @SuppressWarnings("unused")
    private void setterAwayTeamNestedObject(Map<String, String> status) {
        this.teamAwayId = Integer.valueOf(status.getOrDefault("id", "0"));
        this.teamAwayName = status.getOrDefault("name", null);
        this.teamAwayLogo = URI.create(status.getOrDefault("logo", null));
        this.teamAwayWinner = Boolean.parseBoolean(status.getOrDefault("short", "false"));
    }

}
