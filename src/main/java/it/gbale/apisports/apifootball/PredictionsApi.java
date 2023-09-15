package it.gbale.apisports.apifootball;

import it.gbale.apisports.apifootball.model.core.ApiResponse;
import it.gbale.apisports.apifootball.model.entity.Prediction;
import it.gbale.apisports.apifootball.model.parameterEnum.PredictionParams;

import java.util.List;
import java.util.Map;

public class PredictionsApi extends BaseApi{

    private static final String ENDPOINT = "predictions";

    private final RequestFactory requestFactory;

    public PredictionsApi(RequestFactory requestFactory) {
        this.requestFactory = requestFactory;
    }

    public ApiResponse<Prediction> getResponse(Integer fixtureId){
        return requestFactory.makeRequest(ENDPOINT, Map.of(PredictionParams.FIXTURE, String.valueOf(fixtureId)), Prediction.class);
    }

    public List<Prediction> findPrediction(Integer fixtureId){
        return this.getResponse(fixtureId).getResponse();
    }

}
