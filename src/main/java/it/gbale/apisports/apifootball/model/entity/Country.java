package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class Country implements Serializable {

    @SerializedName("name")
    private String name;
    @SerializedName("code")
    private String code;
    @SerializedName("flag")
    private String flag;
}
