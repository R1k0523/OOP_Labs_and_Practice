package rtu.klokov.practics.prac16;

import java.util.Objects;

public final class Address {
    public static final Address EMPTY_ADDRESS = new Address("", 0, "", '\0', 0);
    private final String cityName;
    private final int zipCode;
    private final String streetName;
    private final char buildingLetter;
    private final int apartmentNumber;

    public Address(String cityName, int zipCode, String streetName, char buildingLetter, int apartmentNumber) {
        this.cityName = cityName;
        this.zipCode = zipCode;
        this.streetName = streetName;
        this.buildingLetter = buildingLetter;
        this.apartmentNumber = apartmentNumber;
    }

    public String getCityName() {
        return cityName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public char getBuildingLetter() {
        return buildingLetter;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return zipCode == address.zipCode &&
                buildingLetter == address.buildingLetter &&
                apartmentNumber == address.apartmentNumber &&
                Objects.equals(cityName, address.cityName) &&
                Objects.equals(streetName, address.streetName);
    }

    public int hashCode() {
        return Objects.hash(cityName, zipCode, streetName, buildingLetter, apartmentNumber);
    }

    public String toString() {
        return  cityName + ' ' + zipCode+ ' ' + streetName + ' ' + buildingLetter + ' ' + apartmentNumber;
    }
}
