package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class PlayerDuelsStatistics implements Serializable {

    @SerializedName("total")
    private final Integer total;

    @SerializedName("won")
    private final Integer won;

}
