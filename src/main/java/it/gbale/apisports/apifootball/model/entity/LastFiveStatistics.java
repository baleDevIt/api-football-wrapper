package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@SuppressWarnings("unused")
@Data
public class LastFiveStatistics {

    @SerializedName("form")
    private String formPercentage;
    @SerializedName("att")
    private String attPercentage;
    @SerializedName("def")
    private String defPercentage;
    @SerializedName("goals")
    private Goals goals;

    public Double getGoalsFor(){
        return Double.valueOf(this.getGoals().getForGoals().get("total"));
    }

    public Double getAverageGoalsFor(){
        return Double.valueOf(this.getGoals().getForGoals().get("average"));
    }

    public Double getGoalsAgainst(){
        return Double.valueOf(this.getGoals().getAgainstGoals().get("total"));
    }

    public Double getAverageGoalsAgainst(){
        return Double.valueOf(this.getGoals().getForGoals().get("average"));
    }
}
@AllArgsConstructor
class Goals{

    @SerializedName("for")
    private Map<String, String> forGoals;
    @SerializedName("against")
    private Map<String, String> againstGoals;

    public Map<String, String> getForGoals() {
        return forGoals;
    }

    public Map<String, String> getAgainstGoals() {
        return againstGoals;
    }
}
