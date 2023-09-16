package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class PlayerShotsStatistics implements Serializable {

    @SerializedName("total")
    private final Integer total;

    @SerializedName("on")
    private final Integer on;
}
