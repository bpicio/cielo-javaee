package io.bpic.cielo.core.ecommerce;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.MonthDay;
import java.time.YearMonth;

/**
 * Created: 23/10/2018 23:00.
 *
 * @author Bruno Palermo
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DebitCard {

    @XmlElement(name ="CardNumber")
    private String cardNumber;

    @XmlElement(name ="Holder")
    private String holder;

    @XmlElement(name ="ExpirationDate")
    private YearMonth expirationDate;

    @XmlElement(name ="SecurityCode")
    private String securityCode;

    @XmlElement(name ="Brand")
    private Brand brand;

    public DebitCard() {
    }

    public DebitCard(String securityCode, Brand brand) {
        setSecurityCode(securityCode);
        setBrand(brand);
    }

    public Brand getBrand() {
        return brand;
    }

    public DebitCard setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public DebitCard setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public YearMonth getExpirationDate() {
        return expirationDate;
    }

    public DebitCard setExpirationDate(YearMonth expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public String getHolder() {
        return holder;
    }

    public DebitCard setHolder(String holder) {
        this.holder = holder;
        return this;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public DebitCard setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
        return this;
    }
    
}
