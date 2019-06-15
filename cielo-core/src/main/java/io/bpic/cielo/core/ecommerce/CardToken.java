package io.bpic.cielo.core.ecommerce;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.MonthDay;

/**
 * Created: 23/10/2018 22:18.
 *
 * @author Bruno Palermo
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CardToken {

    @XmlElement(name ="Brand")
    private Brand brand;

    @XmlElement(name ="CardNumber")
    private String cardNumber;

    @XmlElement(name ="CardToken")
    private String cardToken;

    @XmlElement(name ="CustomerName")
    private String customerName;

    @XmlElement(name ="ExpirationDate")
    private MonthDay expirationDate;

    @XmlElement(name ="Holder")
    private String holder;

    @XmlElement(name ="Link")
    private Object links;

    public Brand getBrand() {
        return brand;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardToken() {
        return cardToken;
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
