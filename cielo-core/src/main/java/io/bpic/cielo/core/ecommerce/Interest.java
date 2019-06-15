package io.bpic.cielo.core.ecommerce;

import javax.json.bind.annotation.JsonbProperty;

/**
 * Created: 24/10/2018 00:46.
 *
 * @author Bruno Palermo
 */
public enum Interest {

    @JsonbProperty("ByMerchant")
    BY_MERCHANT,

    @JsonbProperty("ByIssuer")
    BY_ISSUER,

    @JsonbProperty("0")
    SANDBOX,
}
