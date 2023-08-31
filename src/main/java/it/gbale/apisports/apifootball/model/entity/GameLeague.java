package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.net.URI;
import java.time.Year;

@Data
public class GameLeague {
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("country")
    private String country;
    @SerializedName("logo")
    private URI logo;
    @SerializedName("flag")
    private URI flag;
    @SerializedName("season")
    private Year season;
    @SerializedName("round")
    private String round;
}
