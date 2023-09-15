package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class PlayerCardsStatistics implements Serializable {

    @SerializedName("yellow")
    private final Integer yellow;

    @SerializedName("red")
    private final Integer red;
}
