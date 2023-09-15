package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FixtureLineup implements Serializable {

    @SerializedName("team")
    private final TeamLineupProperty teamLineupProperty;

    @SerializedName("formation")
    private final String formationSchema;

    @SerializedName("startXI")
    private final List<PlayerLineup> startXI;

    @SerializedName("substitutes")
    private final List<PlayerLineup> substitutes;

    @SerializedName("coach")
    private final CoachEssential coach;

}
