package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Prediction implements Serializable {

    @SerializedName("predictions")
    PredictionProperty property;

    @SerializedName("league")
    GameLeague gameLeague;

    @SerializedName("teams")
    TeamsInLeagueStatistics teamsPrevision;

    @SerializedName("comparison")
    Comparison comparison;

    @SerializedName("h2h")
    List<Fixture> headTohead;

}
