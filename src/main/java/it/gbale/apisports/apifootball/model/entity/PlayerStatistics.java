package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class PlayerStatistics implements Serializable {

    @SerializedName("games")
    private final PlayerGameStatistics gameStatistics;

    @SerializedName("offsides")
    private final Integer offsides;

    @SerializedName("shots")
    private final PlayerShotsStatistics shotsStatistics;

    @SerializedName("goals")
    private final PlayerGoalsStatistics goalsStatistics;

    @SerializedName("passes")
    private final PlayerPassesStatistics passesStatistics;

    @SerializedName("tackles")
    private final PlayerTacklesStatistics tacklesStatistics;

    @SerializedName("duels")
    private final PlayerDuelsStatistics duelsStatistics;

    @SerializedName("dribbles")
    private final PlayerDribblesStatistics dribblesStatistics;

    @SerializedName("fouls")
    private final PlayerFoulsStatistics foulsStatistics;

    @SerializedName("cards")
    private final PlayerCardsStatistics cardsStatistics;

    @SerializedName("penalty")
    private final PlayerPenaltyStatistics penaltyStatistics;

}
