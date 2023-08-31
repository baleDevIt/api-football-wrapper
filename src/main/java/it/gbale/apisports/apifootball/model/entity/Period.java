package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.time.Instant;

@Data
public class Period {

    @SerializedName("first")
    private Instant first;
    @SerializedName("second")
    private Instant second;
}
