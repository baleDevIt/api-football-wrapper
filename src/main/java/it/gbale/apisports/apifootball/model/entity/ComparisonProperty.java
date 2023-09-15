package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ComparisonProperty {

    @SerializedName("home")
    private String home;

    @SerializedName("away")
    private String away;
}
