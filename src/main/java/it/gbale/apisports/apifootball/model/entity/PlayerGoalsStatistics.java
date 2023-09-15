package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class PlayerGoalsStatistics implements Serializable {

    @SerializedName("total")
    private final Integer total;

    @SerializedName("conceded")
    private final Integer conceded;

    @SerializedName("assists")
    private final Integer assists;

    @SerializedName("saves")
    private final Integer saves;

}
