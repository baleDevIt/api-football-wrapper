package it.gbale.apisports.apifootball.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("referee")
    private String referee;
    @JsonProperty("timezone")
    private String timezone;

    @JsonProperty("date")
    private LocalDateTime date;
    @JsonProperty("timestamp")
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
    @JsonProperty("teams")
    private GameTeams teams;
    //Goals
    @JsonProperty("goals")
    private GameResult goals;

    @JsonProperty("score")
    private GameScore score;

    @JsonProperty("periods")
    @SuppressWarnings("unused")
    private void setterPeriodsNestedObject(Map<String, String> periods) {
        this.firstPeriod = Timestamp.valueOf(periods.getOrDefault("first", null));
        this.secondPeriod = Timestamp.valueOf(periods.getOrDefault("second", null));
    }

    @JsonProperty("venue")
    @SuppressWarnings("unused")
    private void setterVenueNestedObject(Map<String, String> venue) {
        this.venueId = Integer.valueOf(venue.getOrDefault("id", "0"));
        this.venueName = venue.getOrDefault("name", null);
        this.venueCity = venue.getOrDefault("city", null);
    }

    @JsonProperty("status")
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

    @JsonProperty("home")
    @SuppressWarnings("unused")
    private void setterHomeTeamNestedObject(Map<String, String> status) {
        this.teamHomeId = Integer.valueOf(status.getOrDefault("id", "0"));
        this.teamHomeName = status.getOrDefault("name", null);
        this.teamHomeLogo = URI.create(status.getOrDefault("logo", null));
        this.teamHomeWinner = Boolean.valueOf(status.getOrDefault("short", "false"));
    }

    @JsonProperty("away")
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

    @JsonProperty("halftime")
    private GameResult halftime;
    @JsonProperty("fulltime")
    private GameResult fulltime;
    @JsonProperty("extratime")
    private GameResult extratime;
    @JsonProperty("penalty")
    private GameResult penalty;


}

@Data
class GameLeague {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("country")
    private String country;
    @JsonProperty("logo")
    private URI logo;
    @JsonProperty("flag")
    private URI flag;
    @JsonProperty("season")
    private Year season;
    @JsonProperty("round")
    private String round;


}

@Data
class GameResult{
    @JsonProperty("home")
    private Integer home;
    @JsonProperty("away")
    private Integer away;
}


