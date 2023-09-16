package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class EventTimeProperty {

    @SerializedName("elapsed")
    private final Integer elapsed;

    @SerializedName("extra")
    private final Integer extra;

    public EventTimeProperty(Integer elapsed, Integer extra) {
        this.elapsed = elapsed;
        this.extra = extra;
    }
}
