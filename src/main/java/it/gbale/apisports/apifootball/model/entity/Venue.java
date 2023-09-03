package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.net.URI;

@Data
public class Venue {

    @SerializedName("id")
    private final Integer id;
    @SerializedName("name")
    private final String name;

    @SerializedName("address")
    private final String address;
    @SerializedName("city")
    private final String city;

    @SerializedName("country")
    private final String country;

    @SerializedName("capacity")
    private final Integer capacity;

    @SerializedName("surface")
    private final String surface;

    @SerializedName("image")
    private final URI image;
}
