package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class PlayerGameStatistics implements Serializable {

    @SerializedName("minutes")
    private final Integer minutes;

    @SerializedName("number")
    private final Integer number;

    @SerializedName("position")
    private final String position;

    @SerializedName("rating")
    private final String rating;

    @SerializedName("captain")
    private final Boolean captain;

    @SerializedName("substitute")
    private final Boolean substitute;
}
