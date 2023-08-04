package it.gbale.model.core;

import java.io.Serializable;

public abstract class Paging implements Serializable {

    private Integer current;
    private Integer total;


    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
