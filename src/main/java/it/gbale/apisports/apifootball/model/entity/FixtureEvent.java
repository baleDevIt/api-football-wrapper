package it.gbale.apisports.apifootball.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class FixtureEvent implements Serializable {

    @SerializedName("time")
    private final EventTimeProperty eventTimeProperty;

    @SerializedName("team")
    private final EventTeamProperty teamProperty;

    @SerializedName("player")
    private final EventPlayerProperty eventPlayerProperty;

    @SerializedName("assist")
    private final EventPlayerProperty eventAssistPlayerProperty;

    @SerializedName("type")
    private final String typeEvent;

    @SerializedName("detail")
    private final String detailEvent;

    @SerializedName("comments")
    private final String commentEvent;
}


