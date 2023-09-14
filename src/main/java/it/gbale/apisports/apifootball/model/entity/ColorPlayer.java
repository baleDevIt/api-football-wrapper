package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class ColorPlayer implements Serializable {

    @SerializedName("primary")
    private final String primaryColor;

    @SerializedName("number")
    private final String numberColor;

    @SerializedName("border")
    private final String borderColor;
}
