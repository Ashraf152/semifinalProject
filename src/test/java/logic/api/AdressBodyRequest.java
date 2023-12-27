package logic.api;


public class AdressBodyRequest {
    private String name;
    private int cityId;
    private String city;
    private String street;
    private String streetNumber;
    private String zip;
    private String apartment;
    private String entrance;
    private String floor;

    public AdressBodyRequest(String name, int cityId, String city, String street, String streetNumber, String zip, String apartment, String entrance, String floor) {
        this.name = name;
        this.cityId = cityId;
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
        this.zip = zip;
        this.apartment = apartment;
        this.entrance = entrance;
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getEntrance() {
        return entrance;
    }

    public void setEntrance(String entrance) {
        this.entrance = entrance;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    // toString method

    @Override
    public String toString() {
        return "{" +
                "\"name\": " + (name != null ? "\"" + name + "\"" : "null") + "," +
                "\"city_id\": " + cityId + "," +
                "\"city\": \"" + city + "\"," +
                "\"street\": \"" + street + "\"," +
                "\"street_number\": \"" + streetNumber + "\"," +
                "\"zip\": \"" + zip + "\"," +
                "\"apartment\": \"" + apartment + "\"," +
                "\"entrance\": " + (entrance != null ? "\"" + entrance + "\"" : "null") + "," +
                "\"floor\": \"" + floor + "\"" +
                "}";
    }
}
