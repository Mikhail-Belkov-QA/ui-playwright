package models;

public class User {
    private String name;
    private String lastName;
    private Integer zipCode;

    public User(String name, String lastName, Integer zipCode) {
        this.name = name;
        this.lastName = lastName;
        this.zipCode = zipCode;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }
}
