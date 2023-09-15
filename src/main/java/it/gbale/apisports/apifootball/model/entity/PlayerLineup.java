package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class PlayerLineup implements Serializable {

    @SerializedName("player")
    private final PlayerLineupProperty playerLineupProperty;

}
