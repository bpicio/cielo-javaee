package io.bpic.cielo.core.ecommerce;

import javax.json.bind.annotation.JsonbProperty;

/**
 * Created: 23/10/2018 23:08.
 *
 * @author Bruno Palermo
 */
public class RecurrentTransaction {

    @JsonbProperty(value ="PaymentId")
    private String paymentId;

    @JsonbProperty(value ="PaymentNumber")
    private Integer paymentNumber;

    @JsonbProperty(value ="TryNumber")
    private Integer tryNumber;

    public String getPaymentId() {
        return paymentId;
    }

    public Integer getPaymentNumber() {
        return paymentNumber;
    }

    public Integer getTryNumber() {
        return tryNumber;
    }

}
