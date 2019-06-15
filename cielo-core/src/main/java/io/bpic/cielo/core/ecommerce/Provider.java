package io.bpic.cielo.core.ecommerce;

import javax.json.bind.annotation.JsonbProperty;

/**
 * Created: 23/10/2018 22:54.
 *
 * @author Bruno Palermo
 */
public enum Provider {

    @JsonbProperty(value = "Cielo")
    CIELO,

    @JsonbProperty(value = "Bradesco")
    BRADESCO,

    @JsonbProperty(value = "Bradesco2")
    BRADESCO2,

    @JsonbProperty(value = "BancoDoBrasil")
    BANCO_DO_BRASIL,

    @JsonbProperty(value = "BancoDoBrasil2")
    BANCO_DO_BRASIL2,

    @JsonbProperty(value = "Simulado")
    SIMULADO

}
