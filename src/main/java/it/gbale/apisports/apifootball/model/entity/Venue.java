package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Venue {

    @SerializedName("id")
    private final Integer id;
    @SerializedName("name")
    private final String name;
    @SerializedName("city")
    private final String city;
}
