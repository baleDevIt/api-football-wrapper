package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.net.URI;

@Data
public class PlayerEssential implements Serializable {

    @SerializedName("id")
    private final Integer id;

    @SerializedName("name")
    private final String name;

    @SerializedName("photo")
    private final URI logo;
}
