package io.bpic.cielo.core.ecommerce;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.MonthDay;
import java.time.YearMonth;

/**
 * Created: 23/10/2018 22:59.
 *
 * @author Bruno Palermo
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CreditCard {

    @XmlElement(name ="CardNumber")
    private String cardNumber;

    @XmlElement(name ="Holder")
    private String holder;

    @XmlElement(name ="ExpirationDate")
    private YearMonth expirationDate;

    @XmlElement(name ="SecurityCode")
    private String securityCode;

    @XmlElement(name ="SaveCard")
    private boolean saveCard = false;

    @XmlElement(name ="Brand")
    private Brand brand;

    @XmlElement(name ="CardToken")
    private String cardToken;

    public CreditCard() {
    }

    public CreditCard(String securityCode, Brand brand) {
        setSecurityCode(securityCode);
        setBrand(brand);
    }

    public Brand getBrand() {
        return brand;
    }

    public CreditCard setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public CreditCard setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public String getCardToken() {
        return cardToken;
    }

    public CreditCard setCardToken(String cardToken) {
        this.cardToken = cardToken;
        return this;
    }

    public YearMonth getExpirationDate() {
        return expirationDate;
    }

    public CreditCard setExpirationDate(YearMonth expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public String getHolder() {
        return holder;
    }

    public CreditCard setHolder(String holder) {
        this.holder = holder;
        return this;
    }

    public boolean isSaveCard() {
        return saveCard;
    }

    public CreditCard setSaveCard(boolean saveCard) {
        this.saveCard = saveCard;
        return this;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public CreditCard setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
        return this;
    }

}
