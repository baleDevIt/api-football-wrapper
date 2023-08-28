package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import it.gbale.apisports.apifootball.model.parameterEnum.StatusFixtures;
import lombok.Data;

@Data
public class GameStatus {

    @SerializedName("short")
    private final StatusFixtures status;

    @SerializedName("long")
    private final String longStatusString;

    @SerializedName("elapsed")
    private final Integer elapsed;
}
