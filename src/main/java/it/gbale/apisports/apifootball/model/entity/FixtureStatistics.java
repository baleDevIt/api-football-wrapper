package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@SuppressWarnings("unused")
public class FixtureStatistics implements Serializable {

    @SerializedName("team")
    private final StatisticsTeamProperty teamProperty;

    @SerializedName("statistics")
    private final List<StatisticFixtureEntry> statisticsProperty;

    public FixtureStatistics(StatisticsTeamProperty teamProperty, List<StatisticFixtureEntry> statisticsProperty) {
        this.teamProperty = teamProperty;
        this.statisticsProperty = statisticsProperty;
    }

    public Integer getTeamId() {
        return teamProperty.getTeamId();
    }

    public String getTeamName() {
        return teamProperty.getTeamName();
    }

    public URI getLogoTeam() {
        return teamProperty.getLogoTeam();
    }


    public Integer getShotsOnGoal(){
        Object objRet = statisticsProperty
                .stream()
                .filter(sfe -> sfe.getType().equalsIgnoreCase("Shots on Goal"))
                .findFirst()
                .orElse(new StatisticFixtureEntry("Error", ""))
                .getValue();
        return castToInteger(objRet);
    }

    public Integer getShotsOffGoal(){
        Object objRet = statisticsProperty
                .stream()
                .filter(sfe -> sfe.getType().equalsIgnoreCase("Shots off Goal"))
                .findFirst()
                .orElse(new StatisticFixtureEntry("Error", ""))
                .getValue();

        return castToInteger(objRet);
    }

    public Integer getTotalShots(){
        Object objRet = statisticsProperty
                .stream()
                .filter(sfe -> sfe.getType().equalsIgnoreCase("Total Shots"))
                .findFirst()
                .orElse(new StatisticFixtureEntry("Error", ""))
                .getValue();

        return castToInteger(objRet);
    }

    public Integer getBlockedShots(){
        Object objRet = statisticsProperty
                .stream()
                .filter(sfe -> sfe.getType().equalsIgnoreCase("Blocked Shots"))
                .findFirst()
                .orElse(new StatisticFixtureEntry("Error", ""))
                .getValue();

        return castToInteger(objRet);
    }

    public Integer getShotsInsidebox(){
        Object objRet = statisticsProperty
                .stream()
                .filter(sfe -> sfe.getType().equalsIgnoreCase("Shots insidebox"))
                .findFirst()
                .orElse(new StatisticFixtureEntry("Error", ""))
                .getValue();

        return castToInteger(objRet);
    }

    public Integer getShotsOutsidebox(){
        Object objRet = statisticsProperty
                .stream()
                .filter(sfe -> sfe.getType().equalsIgnoreCase("Shots outsidebox"))
                .findFirst()
                .orElse(new StatisticFixtureEntry("Error", ""))
                .getValue();

        return castToInteger(objRet);
    }

    public Integer getFouls(){
        Object objRet = statisticsProperty
                .stream()
                .filter(sfe -> sfe.getType().equalsIgnoreCase("Fouls"))
                .findFirst()
                .orElse(new StatisticFixtureEntry("Error", ""))
                .getValue();
        return castToInteger(objRet);
    }

    public Integer getCornerKicks(){
        Object objRet = statisticsProperty
                .stream()
                .filter(sfe -> sfe.getType().equalsIgnoreCase("Corner Kicks"))
                .findFirst()
                .orElse(new StatisticFixtureEntry("Error", ""))
                .getValue();

        return castToInteger(objRet);
    }

    public Integer getOffsides(){
        Object objRet = statisticsProperty
                .stream()
                .filter(sfe -> sfe.getType().equalsIgnoreCase("Offsides"))
                .findFirst()
                .orElse(new StatisticFixtureEntry("Error", ""))
                .getValue();

        return castToInteger(objRet);
    }

    public String getBallPossession(){
        Object objRet = statisticsProperty
                .stream()
                .filter(sfe -> sfe.getType().equalsIgnoreCase("Ball Possession"))
                .findFirst()
                .orElse(new StatisticFixtureEntry("Error", ""))
                .getValue();

        return castToString(objRet);
    }

    public Integer getYellowCards(){
        Object objRet = statisticsProperty
                .stream()
                .filter(sfe -> sfe.getType().equalsIgnoreCase("Yellow Cards"))
                .findFirst()
                .orElse(new StatisticFixtureEntry("Error", ""))
                .getValue();

        return castToInteger(objRet);
    }

    public Integer getRedCards(){
        Object objRet = statisticsProperty
                .stream()
                .filter(sfe -> sfe.getType().equalsIgnoreCase("Red Cards"))
                .findFirst()
                .orElse(new StatisticFixtureEntry("Error", ""))
                .getValue();

        return castToInteger(objRet);
    }

    public Integer getGoalkeeperSaves(){
        Object objRet = statisticsProperty
                .stream()
                .filter(sfe -> sfe.getType().equalsIgnoreCase("Goalkeeper Saves"))
                .findFirst()
                .orElse(new StatisticFixtureEntry("Error", ""))
                .getValue();

        return castToInteger(objRet);
    }

    public Integer getTotalPasses(){
        Object objRet = statisticsProperty
                .stream()
                .filter(sfe -> sfe.getType().equalsIgnoreCase("Total passes"))
                .findFirst()
                .orElse(new StatisticFixtureEntry("Error", ""))
                .getValue();

        return castToInteger(objRet);
    }

    public Integer getPassesAccurate(){
        Object objRet = statisticsProperty
                .stream()
                .filter(sfe -> sfe.getType().equalsIgnoreCase("Passes accurate"))
                .findFirst()
                .orElse(new StatisticFixtureEntry("Error", ""))
                .getValue();

        return castToInteger(objRet);
    }

    public String getPasses(){
         Object objRet = statisticsProperty
                .stream()
                .filter(sfe -> sfe.getType().equalsIgnoreCase("Passes %"))
                .findFirst()
                 .orElse(new StatisticFixtureEntry("Error", ""))
                .getValue();

        return castToString(objRet);
    }

    public Map<String,String> getAllMetrics(){
        Map<String,String> objMaps = new HashMap<>();
        statisticsProperty.forEach(sfe -> objMaps.put(sfe.getType(), String.valueOf(sfe.getValue())));
        return objMaps;
    }

    private Integer castToInteger(Object objRet) {
        if(objRet instanceof Integer){
            return (Integer) objRet;
        } else if (objRet instanceof Double) {
            Double d = (Double) objRet;
            return d.intValue();
        }
        return 0;
    }

    private String castToString(Object objRet) {
        if(objRet instanceof String || objRet instanceof Integer || objRet instanceof Double){
            return String.valueOf(objRet);
        }
        return "";
    }

}


class StatisticsTeamProperty{

    @SerializedName("id")
    private final Integer teamId;

    @SerializedName("name")
    private final String teamName;

    @SerializedName("logo")
    private final URI logoTeam;

    public StatisticsTeamProperty(Integer teamId, String teamName, URI logoTeam) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.logoTeam = logoTeam;
    }


    public Integer getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public URI getLogoTeam() {
        return logoTeam;
    }
}


class StatisticFixtureEntry{
    @SerializedName("type")
    private final String type;

    @SerializedName("value")
    private final Object value;

    public StatisticFixtureEntry(String type, Object value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatisticFixtureEntry that = (StatisticFixtureEntry) o;
        return getType().equals(that.getType()) && getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType());
    }
}
