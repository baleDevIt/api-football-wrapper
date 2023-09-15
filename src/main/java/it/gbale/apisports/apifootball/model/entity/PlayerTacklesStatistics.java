package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class PlayerTacklesStatistics implements Serializable {

    @SerializedName("total")
    private final Integer total;

    @SerializedName("blocks")
    private final Integer blocks;

    @SerializedName("interceptions")
    private final Integer interceptions;

}