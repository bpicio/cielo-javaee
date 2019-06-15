package io.bpic.cielo.core.ecommerce;

import io.bpic.cielo.core.jsonb.adapters.LocalDateISOAdapter;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTypeAdapter;
import java.time.LocalDate;

/**
 * Created: 23/10/2018 22:41.
 *
 * @author Bruno Palermo
 */
@SuppressWarnings("WeakerAccess")
public class Customer {
    
    @JsonbProperty(value ="Name")
    private String name;

    @JsonbProperty(value ="Email")
    private String email;

    @JsonbTypeAdapter(LocalDateISOAdapter.class)
    @JsonbProperty(value ="Birthdate")
    private LocalDate birthDate;

    @JsonbProperty(value ="Identity")
    private String identity;

    @JsonbProperty(value ="IdentityType")
    private IdentityType identityType;

    @JsonbProperty(value ="Address")
    private Address address;

    @JsonbProperty(value ="DeliveryAddress")
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

    public IdentityType getIdentityType() {
        return identityType;
    }

    public String getName() {
        return name;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public Customer setIdentity(IdentityType type, String identity) {
        this.identity = identity;
        this.identityType = type;
        return this;
    }
    
}
