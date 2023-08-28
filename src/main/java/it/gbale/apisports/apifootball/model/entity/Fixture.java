package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;
import java.time.OffsetDateTime;

@SuppressWarnings("unused")
public class Fixture implements Serializable {

    @SerializedName("fixture")
    private final FixtureProperty fixtureProperty;

    @SerializedName("league")
    private GameLeague league;
    @SerializedName("teams")
    private GameTeams teams;
    //Goals
    @SerializedName("goals")
    private GameResult goals;

    @SerializedName("score")
    private GameScore score;


    public Fixture(Integer id, String referee, String timezone, OffsetDateTime date, Instant timestamp, Period period, Venue venue, GameStatus gameStatus, GameLeague league, GameTeams teams, GameResult goals, GameScore score) {
        this.fixtureProperty = new FixtureProperty();
        this.fixtureProperty.id = id;
        this.fixtureProperty.referee = referee;
        this.fixtureProperty.timezone = timezone;
        this.fixtureProperty.date = date;
        this.fixtureProperty.timestamp = timestamp;
        this.fixtureProperty.period = period;
        this.fixtureProperty.venue = venue;
        this.fixtureProperty.gameStatus = gameStatus;
        this.league = league;
        this.teams = teams;
        this.goals = goals;
        this.score = score;
    }

    public Integer getId() {
        return fixtureProperty.id;
    }

    public void setId(Integer id) {
        this.fixtureProperty.id = id;
    }

    public String getReferee() {
        return fixtureProperty.referee;
    }

    public void setReferee(String referee) {
        this.fixtureProperty.referee = referee;
    }

    public String getTimezone() {
        return fixtureProperty.timezone;
    }

    public void setTimezone(String timezone) {
        this.fixtureProperty.timezone = timezone;
    }

    public OffsetDateTime getDate() {
        return fixtureProperty.date;
    }

    public void setDate(OffsetDateTime date) {
        this.fixtureProperty.date = date;
    }

    public Instant getTimestamp() {
        return fixtureProperty.timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.fixtureProperty.timestamp = timestamp;
    }

    public Period getPeriod() {
        return fixtureProperty.period;
    }

    public void setPeriod(Period period) {
        this.fixtureProperty.period = period;
    }

    public Venue getVenue() {
        return fixtureProperty.venue;
    }

    public void setVenue(Venue venue) {
        this.fixtureProperty.venue = venue;
    }

    public GameStatus getGameStatus() {
        return fixtureProperty.gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.fixtureProperty.gameStatus = gameStatus;
    }

    public GameLeague getLeague() {
        return league;
    }

    public void setLeague(GameLeague league) {
        this.league = league;
    }

    public GameTeams getTeams() {
        return teams;
    }

    public void setTeams(GameTeams teams) {
        this.teams = teams;
    }

    public GameResult getGoals() {
        return goals;
    }

    public void setGoals(GameResult goals) {
        this.goals = goals;
    }

    public GameScore getScore() {
        return score;
    }

    public void setScore(GameScore score) {
        this.score = score;
    }
}

@Data
class FixtureProperty{
    @SerializedName("id")
    Integer id;

    @SerializedName("referee")
    String referee;
    @SerializedName("timezone")
    String timezone;

    @SerializedName("date")
    OffsetDateTime date;
    @SerializedName("timestamp")
    Instant timestamp;

    @SerializedName("periods")
    Period period;

    @SerializedName("venue")
    Venue venue;

    @SerializedName("status")
    GameStatus gameStatus;

}



