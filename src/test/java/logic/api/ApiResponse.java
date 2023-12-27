package logic.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {

    @JsonProperty("id")
    private int id;

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("error")
    private String error;

    @JsonCreator
    public ApiResponse(
            @JsonProperty("success") boolean success,
            @JsonProperty("error") String error,
            @JsonProperty("id") int id) {
        this.success = success;
        this.error = error;
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public String getError() {
        return this.error;
    }
}
