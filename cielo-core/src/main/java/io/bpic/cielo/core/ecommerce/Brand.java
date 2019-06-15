package io.bpic.cielo.core.ecommerce;

import javax.json.bind.annotation.JsonbProperty;

/**
 * Created: 23/10/2018 22:34.
 *
 * @author Bruno Palermo
 */
public enum Brand {

    @JsonbProperty(value = "Visa")
    VISA,

    @JsonbProperty(value = "Master")
    MASTER,

    @JsonbProperty(value = "Amex")
    AMEX,

    @JsonbProperty(value = "Elo")
    ELO,

    @JsonbProperty(value = "Aura")
    AURA,

    @JsonbProperty(value = "JCB")
    JCB,

    @JsonbProperty(value = "Diners")
    DINERS,

    @JsonbProperty(value = "Discover")
    DISCOVER,

    @JsonbProperty(value = "Hipercard")
    HIPERCARD,



}
