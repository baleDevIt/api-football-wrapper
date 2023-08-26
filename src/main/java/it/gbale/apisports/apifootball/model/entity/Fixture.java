package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.net.URI;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.Map;

@Data
public class Fixture implements Serializable {

    @SerializedName("id")
    private Integer id;

    @SerializedName("referee")
    private String referee;
    @SerializedName("timezone")
    private String timezone;

    @SerializedName("date")
    private LocalDateTime date;
    @SerializedName("timestamp")
    private Instant timestamp;

    // Periods
    private Timestamp firstPeriod;
    private Timestamp secondPeriod;

    //Venue
    private Integer venueId;
    private String venueName;
    private String venueCity;

    //Status
    private String statusName;
    private String status;
    private Integer statusTimeElapsed;

    //League
    private GameLeague league;
    @SerializedName("teams")
    private GameTeams teams;
    //Goals
    @SerializedName("goals")
    private GameResult goals;

    @SerializedName("score")
    private GameScore score;

    @SerializedName("periods")
    @SuppressWarnings("unused")
    private void setterPeriodsNestedObject(Map<String, String> periods) {
        this.firstPeriod = Timestamp.valueOf(periods.getOrDefault("first", null));
        this.secondPeriod = Timestamp.valueOf(periods.getOrDefault("second", null));
    }

    @SerializedName("venue")
    @SuppressWarnings("unused")
    private void setterVenueNestedObject(Map<String, String> venue) {
        this.venueId = Integer.valueOf(venue.getOrDefault("id", "0"));
        this.venueName = venue.getOrDefault("name", null);
        this.venueCity = venue.getOrDefault("city", null);
    }

    @SerializedName("status")
    @SuppressWarnings("unused")
    private void setterStatusNestedObject(Map<String, String> status) {
        this.statusTimeElapsed = Integer.valueOf(status.getOrDefault("elapsed", "0"));
        this.statusName = status.getOrDefault("long", null);
        this.status = status.getOrDefault("short", null);
    }


}

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

@Data
class GameScore{

    @SerializedName("halftime")
    private GameResult halftime;
    @SerializedName("fulltime")
    private GameResult fulltime;
    @SerializedName("extratime")
    private GameResult extratime;
    @SerializedName("penalty")
    private GameResult penalty;


}

@Data
class GameLeague {
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("country")
    private String country;
    @SerializedName("logo")
    private URI logo;
    @SerializedName("flag")
    private URI flag;
    @SerializedName("season")
    private Year season;
    @SerializedName("round")
    private String round;


}

@Data
class GameResult{
    @SerializedName("home")
    private Integer home;
    @SerializedName("away")
    private Integer away;
}


