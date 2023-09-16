package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class PlayerDribblesStatistics implements Serializable {

    @SerializedName("attempts")
    private final Integer attempts;

    @SerializedName("success")
    private final Integer success;

    @SerializedName("past")
    private final Integer past;
}
