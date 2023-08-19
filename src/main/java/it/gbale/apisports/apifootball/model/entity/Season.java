package it.gbale.apisports.apifootball.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class Season implements Serializable {

    @JsonProperty("year")
    private Integer year;

    @JsonProperty("start")
    private LocalDate start;
    @JsonProperty("end")
    private LocalDate end;
    @JsonProperty("current")
    private boolean current;
    @JsonProperty("coverage")
    private Coverage coverage;

}
