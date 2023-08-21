package it.gbale.apisports.apifootball.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Coverage implements Serializable {

    @JsonProperty("fixtures")
    private CoverageFixture fixtures;
    @JsonProperty("standings")
    private boolean standings;
    @JsonProperty("players")
    private boolean players;
    @JsonProperty("top_scorers")
    private boolean topScorers;
    @JsonProperty("top_assists")
    private boolean topAssists;
    @JsonProperty("top_cards")
    private boolean topCards;
    @JsonProperty("injuries")
    private boolean injuries;
    @JsonProperty("predictions")
    private boolean predictions;
    @JsonProperty("odds")
    private boolean odds;

}

@Data
class CoverageFixture implements Serializable  {

    @JsonProperty("events")
    private boolean events;
    @JsonProperty("lineups")
    private boolean lineups;
    @JsonProperty("statistics_fixtures")
    private boolean statistics_fixtures;
    @JsonProperty("statistics_players")
    private boolean statistics_players;
}
