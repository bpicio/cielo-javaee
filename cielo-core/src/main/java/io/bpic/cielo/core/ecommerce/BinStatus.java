package io.bpic.cielo.core.ecommerce;

import javax.json.bind.annotation.JsonbProperty;

/**
 * Created: 24/10/2018 01:03.
 *
 * @author Bruno Palermo
 */
public enum BinStatus {

    @JsonbProperty("00")
    AUTHORIZED,

    @JsonbProperty("01")
    BRAND_NOT_SUPPORTED,

    @JsonbProperty("02")
    CARD_NOT_SUPPORTED,

    @JsonbProperty("73")
    BLOCKED_SUBSCRIPTION

}
