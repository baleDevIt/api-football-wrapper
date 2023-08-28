package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

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
