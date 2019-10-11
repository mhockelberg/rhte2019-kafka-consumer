
package org.mycompany;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "before",
    "after",
    "source",
    "op",
    "ts_ms"
})
public class Payload {

    @JsonProperty("before")
    private Before before;
    @JsonProperty("after")
    private After after;
    @JsonProperty("source")
    private Source source;
    @JsonProperty("op")
    private String op;
    @JsonProperty("ts_ms")
    private Long tsMs;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("before")
    public Before getBefore() {
        return before;
    }

    @JsonProperty("before")
    public void setBefore(Before before) {
        this.before = before;
    }

    @JsonProperty("after")
    public After getAfter() {
        return after;
    }

    @JsonProperty("after")
    public void setAfter(After after) {
        this.after = after;
    }

    @JsonProperty("source")
    public Source getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(Source source) {
        this.source = source;
    }

    @JsonProperty("op")
    public String getOp() {
        return op;
    }

    @JsonProperty("op")
    public void setOp(String op) {
        this.op = op;
    }

    @JsonProperty("ts_ms")
    public Long getTsMs() {
        return tsMs;
    }

    @JsonProperty("ts_ms")
    public void setTsMs(Long tsMs) {
        this.tsMs = tsMs;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
