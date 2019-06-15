package io.bpic.cielo.core.ecommerce;

import javax.json.bind.annotation.JsonbProperty;

/**
 * Created: 25/10/2018 20:57.
 *
 * @author Bruno Palermo
 */
public enum IdentityType {

    @JsonbProperty("CPF")
    CPF,

    @JsonbProperty("CNPJ")
    CNPJ

}
