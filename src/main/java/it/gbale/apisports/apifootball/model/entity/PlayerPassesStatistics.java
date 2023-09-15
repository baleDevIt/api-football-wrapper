package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class PlayerPassesStatistics implements Serializable {

    @SerializedName("total")
    private final Integer total;

    @SerializedName("key")
    private final Integer key;

    @SerializedName("accuracy")
    private final String accuracy;
}
