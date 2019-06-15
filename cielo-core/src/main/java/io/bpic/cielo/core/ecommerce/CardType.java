package io.bpic.cielo.core.ecommerce;

import javax.json.bind.annotation.JsonbProperty;

/**
 * Created: 27/10/2018 12:57.
 *
 * @author Bruno Palermo
 */
public enum CardType {

    @JsonbProperty("Credito")
    CREDIT,

    @JsonbProperty("Debito")
    DEBIT,

    @JsonbProperty("Multiplo")
    MULTIPLE

}
