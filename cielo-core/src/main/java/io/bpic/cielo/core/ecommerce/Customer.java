package io.bpic.cielo.core.ecommerce;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

/**
 * Created: 23/10/2018 22:41.
 *
 * @author Bruno Palermo
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {
    
    @XmlElement(name ="Name")
    private String name;

    @XmlElement(name ="Email")
    private String email;

    @XmlElement(name ="BirthDate")
    private LocalDate birthDate;

    @XmlElement(name ="Identity")
    private String identity;

    @XmlElement(name ="IdentityType")
    private String identityType;

    @XmlElement(name ="Address")
    private Address address;

    @XmlElement(name ="DeliveryAddress")
    private Address deliveryAddress;

    public Customer() {
    }

    public Customer(String name) {
        setName(name);
    }

    public Address address() {
        setAddress(new Address());

        return getAddress();
    }

    public Address deliveryAddress() {
        setDeliveryAddress(new Address());

        return getDeliveryAddress();
    }

    public Address getAddress() {
        return address;
    }

    public Customer setAddress(Address address) {
        this.address = address;
        return this;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public Customer setDeliveryAddress(Address address) {
        this.deliveryAddress = address;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Customer setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getIdentity() {
        return identity;
    }

    public String getIdentityType() {
        return identityType;
    }

    public String getName() {
        return name;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public Customer setIdentity(String identityType, String identity) {
        this.identity = identity;
        this.identityType = identityType;
        return this;
    }
    
}
