package models;

public class User {
    private String name;
    private String lastName;
    private String zipCode;

    public User(String name, String lastName, String zipCode) {
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
