package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
class GameResult{
    @SerializedName("home")
    private Integer home;
    @SerializedName("away")
    private Integer away;
}
