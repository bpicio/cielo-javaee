package io.bpic.cielo.core.ecommerce;

import javax.json.bind.annotation.JsonbProperty;
import java.time.MonthDay;

/**
 * Created: 23/10/2018 22:18.
 *
 * @author Bruno Palermo
 */
@SuppressWarnings("WeakerAccess")
public class CardToken {

    @JsonbProperty(value ="Brand")
    private Brand brand;

    @JsonbProperty(value ="CardNumber")
    private String cardNumber;

    @JsonbProperty(value ="CardToken")
    private String cardToken;

    @JsonbProperty(value ="CustomerName")
    private String customerName;

    @JsonbProperty(value ="ExpirationDate")
    private MonthDay expirationDate;

    @JsonbProperty(value ="Holder")
    private String holder;

    @JsonbProperty(value ="Links")
    private Link links;

    public Brand getBrand() {
        return brand;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardToken() {
        return cardToken;
    }

    public void setCardToken(String cardToken) {
        this.cardToken = cardToken;
    }

    public void setLinks(Link links) {
        this.links = links;
    }

    public String getCustomerName() {
        return customerName;
    }

    public MonthDay getExpirationDate() {
        return expirationDate;
    }

    public String getHolder() {
        return holder;
    }

    public Object getLinks() {
        return links;
    }

    public CardToken setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }

    public CardToken setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public CardToken setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public CardToken setExpirationDate(MonthDay expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public CardToken setHolder(String holder) {
        this.holder = holder;

        if (customerName == null) {
            setCustomerName(holder);
        }
        return this;
    }
    
}
