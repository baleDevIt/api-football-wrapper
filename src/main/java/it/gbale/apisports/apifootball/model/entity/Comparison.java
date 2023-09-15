package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class Comparison implements Serializable {

    @SerializedName("form")
    ComparisonProperty formComparison;

    @SerializedName("att")
    ComparisonProperty attComparison;


    @SerializedName("def")
    ComparisonProperty defComparison;

    @SerializedName("poisson_distribution")
    ComparisonProperty poissonDistributionComparison;

    @SerializedName("h2h")
    ComparisonProperty h2hComparison;

    @SerializedName("goals")
    ComparisonProperty goalsComparison;

    @SerializedName("total")
    ComparisonProperty totalComparison;
}
