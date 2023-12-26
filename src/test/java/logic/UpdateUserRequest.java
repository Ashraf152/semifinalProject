package logic;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateUserRequest {
    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("additional_phone")
    private String additionalPhone;

    @JsonProperty("sex_id")
    private Integer sexId;

    @JsonProperty("birth_date")
    private String birthDate;

    public UpdateUserRequest(String firstName, String lastName, String phone, String additionalPhone, Integer sexId, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.additionalPhone = additionalPhone;
        this.sexId = sexId;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdditionalPhone() {
        return additionalPhone;
    }

    public void setAdditionalPhone(String additionalPhone) {
        this.additionalPhone = additionalPhone;
    }

    public Integer getSexId() {
        return sexId;
    }

    public void setSexId(Integer sexId) {
        this.sexId = sexId;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}

