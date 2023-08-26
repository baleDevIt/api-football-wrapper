package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Year;

@Data
public class Season implements Serializable {

    @SerializedName("year")
    private Year year;

    @SerializedName("start")
    private LocalDate start;
    @SerializedName("end")
    private LocalDate end;
    @SerializedName("current")
    private boolean current;
    @SerializedName("coverage")
    private Coverage coverage;

}
