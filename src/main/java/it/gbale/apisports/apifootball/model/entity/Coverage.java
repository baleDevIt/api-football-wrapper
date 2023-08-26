package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class Coverage implements Serializable {

    @SerializedName("fixtures")
    private CoverageFixture fixtures;
    @SerializedName("standings")
    private boolean standings;
    @SerializedName("players")
    private boolean players;
    @SerializedName("top_scorers")
    private boolean topScorers;
    @SerializedName("top_assists")
    private boolean topAssists;
    @SerializedName("top_cards")
    private boolean topCards;
    @SerializedName("injuries")
    private boolean injuries;
    @SerializedName("predictions")
    private boolean predictions;
    @SerializedName("odds")
    private boolean odds;

}

@Data
class CoverageFixture implements Serializable  {

    @SerializedName("events")
    private boolean events;
    @SerializedName("lineups")
    private boolean lineups;
    @SerializedName("statistics_fixtures")
    private boolean statistics_fixtures;
    @SerializedName("statistics_players")
    private boolean statistics_players;
}
