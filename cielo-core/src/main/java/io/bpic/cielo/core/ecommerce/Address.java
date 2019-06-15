package io.bpic.cielo.core.ecommerce;

import javax.json.bind.annotation.JsonbProperty;

/**
 * Representation of customer's address
 */
public class Address {

    @JsonbProperty(value = "Street")
    private String street;


    @JsonbProperty(value = "Number")
    private String number;


    @JsonbProperty(value = "Complement")
    private String complement;


    @JsonbProperty(value = "ZipCode")
    private String zipCode;


    @JsonbProperty(value ="District")
    private String district;


    @JsonbProperty(value ="City")
    private String city;


    @JsonbProperty(value ="State")
    private String state;


    @JsonbProperty(value ="Country")
    private String country;


    public String getCity() {
        return city;
    }


    public Address setCity(String city) {
        this.city = city;
        return this;
    }


    public String getComplement() {
        return complement;
    }


    public Address setComplement(String complement) {
        this.complement = complement;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Address setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public Address setNumber(String number) {
        this.number = number;
        return this;
    }

    public String getState() {
        return state;
    }

    public Address setState(String state) {
        this.state = state;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Address setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public String getDistrict() {
        return district;
    }

    public Address setDistrict(String district) {
        this.district = district;
        return this;
    }

    public Address() {
    }
}
