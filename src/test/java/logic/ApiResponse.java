package logic;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class ApiResponse {
    @JsonProperty("success")
    private boolean success;

    @JsonProperty("error")
    private String error;

    @JsonProperty("LogIn")
    private List<LogInData> data;

    @JsonCreator
    public ApiResponse(@JsonProperty("success") boolean success,
                       @JsonProperty("error") String error,
                       @JsonProperty("LogIn") List<LogInData> data) {
        this.success=success;
        this.error=error;
        this.data =data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<LogInData> getData() {
        return data;
    }

    public void setData(List<LogInData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "success=" + success +
                ", error='" + error + '\'' +
                ", login=" + data +
                '}';
    }

    public static class LogInData{
        @JsonProperty("email")
        private String email;

        @JsonProperty("password")
        private String password;


        public LogInData(@JsonProperty("email") String email,
                              @JsonProperty("password") String password) {
            this.email = email;
            this.password = password;

        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getpassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }


        @Override
        public String toString() {
            return "Restaurant{" +
                    "email=" + email +
                    ", password='" + password + '\''+
                    '}';
        }
    }

}
