package io.bpic.cielo.core.ecommerce;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Representation of customer's address
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {
    /**
     * {@link Address#getStreet()}
     */
    @XmlElement(name = "Street")
    private String street;

    /**
     * {@link Address#getNumber()}
     */
    @XmlElement(name = "Number")
    private String number;

    /**
     * {@link Address#getComplement()}
     */
    @XmlElement(name = "Complement")
    private String complement;

    /**
     * {@link Address#getZipCode()}
     */
    @XmlElement(name = "ZipCode")
    private String zipCode;

    /**
     * {@link Address#getCity()}
     */
    @XmlElement(name ="City")
    private String city;

    /**
     * {@link Address#getState()}
     */
    @XmlElement(name ="State")
    private String state;

    /**
     * {@link Address#getCountry()}
     */
    @XmlElement(name ="Country")
    private String country;

    /**
     * @return the city of customer's address
     */
    public String getCity() {
        return city;
    }

    /**
     * {@link Address#getCity()}
     */
    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    /**
     * @return any complement of customer's address
     */
    public String getComplement() {
        return complement;
    }

    /**
     * {@link Address#getComplement()}
     */
    public Address setComplement(String complement) {
        this.complement = complement;
        return this;
    }

    /**
     * @return the country of customer's address
     */
    public String getCountry() {
        return country;
    }

    /**
     * {@link Address#getCountry()}
     */
    public Address setCountry(String country) {
        this.country = country;
        return this;
    }

    /**
     * @return the customer's address number
     */
    public String getNumber() {
        return number;
    }

    /**
     * {@link Address#getNumber()}
     */
    public Address setNumber(String number) {
        this.number = number;
        return this;
    }

    /**
     * @return the state of customer's address
     */
    public String getState() {
        return state;
    }

    /**
     * {@link Address#getState()}
     */
    public Address setState(String state) {
        this.state = state;
        return this;
    }

    /**
     * @return the customer's address
     */
    public String getStreet() {
        return street;
    }

    /**
     * {@link Address#getStreet()}
     */
    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    /**
     * @return the zip code of customer's address
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * {@link Address#getZipCode()}
     */
    public Address setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public Address() {
    }
}
