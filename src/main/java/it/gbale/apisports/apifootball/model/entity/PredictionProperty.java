package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;

import java.io.Serializable;

@SuppressWarnings("unused")
@AllArgsConstructor
public class PredictionProperty implements Serializable {

    @SerializedName("winner")
    private WinnerTeam winnerTeam;

    @SerializedName("win_or_draw")
    private boolean winOrDraw;

    @SerializedName("under_over")
    private String underOver;

    @SerializedName("goals")
    private GoalsPrevision goals;

    @SerializedName("advice")
    private String advice;

    @SerializedName("percent")
    private PercentAdvice percentAdvice;




    public Integer getWinnerId() {
        return winnerTeam.winnerId;
    }

    public String getWinnerName() {
        return winnerTeam.winnerName;
    }

    public String getTextualPrevision() {
        return winnerTeam.textualPrevision;
    }

    public String getPrevisionGoalsHome() {
        return goals.home;
    }

    public String getPrevisionGoalsAway() {
        return goals.away;
    }

    public boolean isWinOrDraw() {
        return winOrDraw;
    }

    public String getUnderOver() {
        return underOver;
    }

    public String getAdvice() {
        return advice;
    }

    public String getPercentAdviceHome() {
        return percentAdvice.home;
    }

    public String getPercentAdviceDraw() {
        return percentAdvice.draw;
    }

    public String getPercentAdviceAway() {
        return percentAdvice.away;
    }
}

@AllArgsConstructor
class WinnerTeam{

    @SerializedName("id")
    final Integer winnerId;
    @SerializedName("name")
    final String winnerName;
    @SerializedName("comment")
    final String textualPrevision;
}

@AllArgsConstructor
class GoalsPrevision{

    @SerializedName("home")
    final String home;

    @SerializedName("away")
    final String away;
}

@AllArgsConstructor
class PercentAdvice{
    @SerializedName("home")
    final String home;

    @SerializedName("draw")
    final String draw;

    @SerializedName("away")
    final String away;
}
