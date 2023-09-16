package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
@Data
public class PlayerPenaltyStatistics implements Serializable {

    @SerializedName("won")
    private final Integer won;

    @SerializedName("commited")
    private final Integer commited;

    @SerializedName("scored")
    private final Integer scored;

    @SerializedName("missed")
    private final Integer missed;

    @SerializedName("saved")
    private final Integer saved;


}
