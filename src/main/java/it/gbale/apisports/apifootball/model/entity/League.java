package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode
public class League implements Serializable {

    @SerializedName("country")
    Country country;

    @SerializedName("seasons")
    List<Season> seasons;

    @SerializedName("league")
    LeagueInfo leagueInfo;


}
