package it.gbale.apisports.apifootball.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Fixture {

    @JsonProperty("events")
    private boolean events;
    @JsonProperty("lineups")
    private boolean lineups;
    @JsonProperty("statistics_fixtures")
    private boolean statistics_fixtures;
    @JsonProperty("statistics_players")
    private boolean statistics_players;
}
