package io.bpic.cielo.core.ecommerce;

import javax.json.bind.annotation.JsonbProperty;
import java.time.YearMonth;

/**
 * Created: 23/10/2018 23:00.
 *
 * @author Bruno Palermo
 */
@SuppressWarnings("WeakerAccess")
public class DebitCard {

    @JsonbProperty(value ="CardNumber")
    private String cardNumber;

    @JsonbProperty(value ="Holder")
    private String holder;

    @JsonbProperty(value ="ExpirationDate")
    private YearMonth expirationDate;

    @JsonbProperty(value ="SecurityCode")
    private String securityCode;

    @JsonbProperty(value ="SaveCard")
    private boolean saveCard;

    @JsonbProperty(value ="Brand")
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

    public boolean isSaveCard() {
        return saveCard;
    }

    public void setSaveCard(boolean saveCard) {
        this.saveCard = saveCard;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public DebitCard setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
        return this;
    }
    
}
