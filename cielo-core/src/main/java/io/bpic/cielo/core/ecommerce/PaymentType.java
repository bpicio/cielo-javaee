package io.bpic.cielo.core.ecommerce;

import javax.json.bind.annotation.JsonbProperty;

/**
 * Created: 23/10/2018 22:55.
 *
 * @author Bruno Palermo
 */
public enum PaymentType {

    @JsonbProperty(value = "CreditCard")
    CREDIT_CARD,

    @JsonbProperty(value = "DebitCard")
    DEBIT_CARD,

    // Typing error
    @JsonbProperty(value = "EletronicTransfer")
    ELECTRONIC_TRANSFER,

    @JsonbProperty("Boleto")
    BOLETO

}
