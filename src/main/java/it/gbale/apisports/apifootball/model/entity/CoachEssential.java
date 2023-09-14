package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.net.URI;

@Data
public class CoachEssential implements Serializable {

    @SerializedName("id")
    private final Integer coachId;

    @SerializedName("name")
    private final String coachName;

    @SerializedName("photo")
    private final URI coachNumber;
}
