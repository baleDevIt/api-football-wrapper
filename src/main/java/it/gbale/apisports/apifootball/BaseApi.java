package it.gbale.apisports.apifootball;


import it.gbale.apisports.apifootball.model.parameterEnum.BaseParams;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseApi {

    @SuppressWarnings("SameParameterValue")
    protected Map<BaseParams, String> makeParams(BaseParams key, String value){
        Map<BaseParams, String> paramsStringMap = new HashMap<>();
        paramsStringMap.put(key, value);
        return paramsStringMap;
    }

}
