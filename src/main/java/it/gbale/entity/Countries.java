package it.gbale.entity;

import java.io.Serializable;

public class Countries implements Serializable {

    private String name, code;
    private String flag;

    public Countries() {

    }

    public Countries(String name, String code, String flag) {
        this.name = name;
        this.code = code;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Countries{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
