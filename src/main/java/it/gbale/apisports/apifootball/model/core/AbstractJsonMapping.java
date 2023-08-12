package it.gbale.apisports.apifootball.model.core;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;

public abstract class AbstractJsonMapping implements Serializable {

    private static Logger getLogger(Class<?> aClass) {
        return LogManager.getLogger(aClass);
    }

}
