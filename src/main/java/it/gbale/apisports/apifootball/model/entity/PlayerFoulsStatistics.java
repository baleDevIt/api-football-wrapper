package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class PlayerFoulsStatistics implements Serializable {

    @SerializedName("drawn")
    private final Integer drawn;

    @SerializedName("committed")
    private final Integer committed;
}
