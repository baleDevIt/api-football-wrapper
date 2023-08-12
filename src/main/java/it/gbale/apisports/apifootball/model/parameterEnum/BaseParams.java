package it.gbale.apisports.apifootball.model.parameterEnum;

public interface BaseParams {

    String getValue();

    /**
     * Metodo utilità per il controllo della reale classe dell'oggetto. Utile per evitare classi Params associate
     * ad altre richieste non formattabili con la richiesta in atto.
     */
    default boolean checkClass(Class someClass){
        return this.getClass().equals(someClass);
    }
}
