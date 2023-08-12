package it.gbale.apisports.apifootball.model.core;

import lombok.Data;

import java.io.Serializable;

@Data
public class Paging implements Serializable {

    private Integer current;
    private Integer total;

}
