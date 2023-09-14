package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class ColorsTeamProperty implements Serializable {

    @SerializedName("player")
    private final ColorPlayer playerColors;


    @SerializedName("goalkeeper")
    private final ColorPlayer goalkeeperColors;
}
