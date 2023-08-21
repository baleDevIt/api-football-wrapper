package it.gbale.apisports.apifootball.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Coverage {

    @JsonProperty("fixtures")
    private Fixture fixtures;

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
