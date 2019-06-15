package io.bpic.cielo.core.ecommerce;

import javax.json.bind.annotation.JsonbProperty;
import java.time.YearMonth;

/**
 * Created: 23/10/2018 22:59.
 *
 * @author Bruno Palermo
 */
@SuppressWarnings("WeakerAccess")
public class CreditCard {

    @JsonbProperty(value ="CustomerName")
    private String customerName;

    @JsonbProperty(value ="CardNumber")
    private String cardNumber;

    @JsonbProperty(value ="Holder")
    private String holder;

    @JsonbProperty(value ="ExpirationDate")
    private YearMonth expirationDate;

    @JsonbProperty(value ="SecurityCode")
    private String securityCode;

    @JsonbProperty(value ="SaveCard")
    private boolean saveCard = false;

    @JsonbProperty(value ="Brand")
    private Brand brand;

    @JsonbProperty(value ="CardToken")
    private String cardToken;

    public CreditCard() {
    }

    public CreditCard(String securityCode, Brand brand) {
        setSecurityCode(securityCode);
        setBrand(brand);
    }

    public String getCustomerName() {
        return customerName;
    }

    public CreditCard setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
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
