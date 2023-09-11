package it.gbale.apisports.apifootball;

import it.gbale.apisports.apifootball.model.entity.Prediction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PredictionsApiTest extends GenericTest<Prediction> {

    private static ApiFootball apiFootball;

    @BeforeAll
    static void setup() {
        if(System.getenv("SERVICETOKEN") != null){
            apiFootball = new ApiFootball(System.getenv("SERVICETOKEN"));
        }
    }


    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void getResponse() {
        testResponseObjSuccess(apiFootball.predictionsApi().getResponse(198772), Prediction.class);
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SERVICETOKEN", matches = "[A-Za-z0-9@]+", disabledReason = "Token api is null or not valid")
    void findPrediction() {
        List<Prediction> predictionList = apiFootball.predictionsApi().findPrediction(198772);
        assertEquals(1, predictionList.size(), "Prevision List is more that one element");
        assertEquals("51.5%",predictionList.get(0).getComparison().getTotalComparison().getHome(), "Error in getTotalComparison");
        assertEquals("60%",predictionList.get(0).getComparison().getFormComparison().getHome(), "Error in getFormComparison");
        assertEquals("75%",predictionList.get(0).getComparison().getPoissonDistributionComparison().getHome(), "Error in getPoissonDistributionComparison");

        assertEquals("Combo Double chance : Deportivo Santani or draw and -3.5 goals",predictionList.get(0).getProperty().getAdvice() , "Error in getPoissonDistributionComparison");
        assertEquals("Combo Double chance : Deportivo Santani or draw and -3.5 goals",predictionList.get(0).getProperty().getAdvice() , "Error in getPoissonDistributionComparison");

    }
}