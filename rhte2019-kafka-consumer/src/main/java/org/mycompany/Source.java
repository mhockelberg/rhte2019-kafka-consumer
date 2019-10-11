
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
    "version",
    "connector",
    "name",
    "ts_ms",
    "snapshot",
    "db",
    "table",
    "server_id",
    "gtid",
    "file",
    "pos",
    "row",
    "thread",
    "query"
})
public class Source {

    @JsonProperty("version")
    private String version;
    @JsonProperty("connector")
    private String connector;
    @JsonProperty("name")
    private String name;
    @JsonProperty("ts_ms")
    private Long tsMs;
    @JsonProperty("snapshot")
    private String snapshot;
    @JsonProperty("db")
    private String db;
    @JsonProperty("table")
    private String table;
    @JsonProperty("server_id")
    private Integer serverId;
    @JsonProperty("gtid")
    private String gtid;
    @JsonProperty("file")
    private String file;
    @JsonProperty("pos")
    private Integer pos;
    @JsonProperty("row")
    private Integer row;
    @JsonProperty("thread")
    private Integer thread;
    @JsonProperty("query")
    private Object query;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("connector")
    public String getConnector() {
        return connector;
    }

    @JsonProperty("connector")
    public void setConnector(String connector) {
        this.connector = connector;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("ts_ms")
    public Long getTsMs() {
        return tsMs;
    }

    @JsonProperty("ts_ms")
    public void setTsMs(Long tsMs) {
        this.tsMs = tsMs;
    }

    @JsonProperty("snapshot")
    public String getSnapshot() {
        return snapshot;
    }

    @JsonProperty("snapshot")
    public void setSnapshot(String snapshot) {
        this.snapshot = snapshot;
    }

    @JsonProperty("db")
    public String getDb() {
        return db;
    }

    @JsonProperty("db")
    public void setDb(String db) {
        this.db = db;
    }

    @JsonProperty("table")
    public String getTable() {
        return table;
    }

    @JsonProperty("table")
    public void setTable(String table) {
        this.table = table;
    }

    @JsonProperty("server_id")
    public Integer getServerId() {
        return serverId;
    }

    @JsonProperty("server_id")
    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    @JsonProperty("gtid")
    public String getGtid() {
        return gtid;
    }

    @JsonProperty("gtid")
    public void setGtid(String gtid) {
        this.gtid = gtid;
    }

    @JsonProperty("file")
    public String getFile() {
        return file;
    }

    @JsonProperty("file")
    public void setFile(String file) {
        this.file = file;
    }

    @JsonProperty("pos")
    public Integer getPos() {
        return pos;
    }

    @JsonProperty("pos")
    public void setPos(Integer pos) {
        this.pos = pos;
    }

    @JsonProperty("row")
    public Integer getRow() {
        return row;
    }

    @JsonProperty("row")
    public void setRow(Integer row) {
        this.row = row;
    }

    @JsonProperty("thread")
    public Integer getThread() {
        return thread;
    }

    @JsonProperty("thread")
    public void setThread(Integer thread) {
        this.thread = thread;
    }

    @JsonProperty("query")
    public Object getQuery() {
        return query;
    }

    @JsonProperty("query")
    public void setQuery(Object query) {
        this.query = query;
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
