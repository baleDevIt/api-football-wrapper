package it.gbale.model.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class ApiResponce<T> extends AbstractJsonMapping {

    @JsonProperty("get")
    private String get;
    @JsonProperty("parameters")
    private List<String> parameters;
    @JsonProperty("errors")
    private List<Map<String, String>> errors;
    @JsonProperty("results")
    private Integer results;
    @JsonProperty("paging")
    private Map<String, Object> paging;
    @JsonProperty("response")
    private List<T> response;

    public String getGet() {
        return get;
    }

    public void setGet(String get) {
        this.get = get;
    }

    public List<Map<String, String>> getErrors() {
        return errors;
    }

    public void setErrors(List<Map<String, String>> errors) {
        this.errors = errors;
    }

    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }

    public Map<String, Object> getPaging() {
        return paging;
    }

    public void setPaging(Map<String, Object> paging) {
        this.paging = paging;
    }

    public List<T> getResponce() {
        return response;
    }

    public void setResponce(List<T> responce) {
        this.response = responce;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ApiResponce{");
        sb.append("get='").append(get).append('\'');
        sb.append(", errors=").append(errors);
        sb.append(", results=").append(results);
        sb.append(", paging=").append(paging);
        sb.append(", response=").append(response);
        sb.append('}');
        return sb.toString();
    }
}
