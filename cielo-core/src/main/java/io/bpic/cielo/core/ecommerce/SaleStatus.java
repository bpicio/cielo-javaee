package io.bpic.cielo.core.ecommerce;

import javax.json.bind.annotation.JsonbProperty;

/**
 * Created: 24/10/2018 01:03.
 *
 * @author Bruno Palermo
 */
public enum SaleStatus {

    @JsonbProperty("0")
    NOT_FINISH(0),

    @JsonbProperty("1")
    AUTHORIZED(1),

    @JsonbProperty("2")
    PAYMENT_CONFIRMED(2),

    @JsonbProperty("3")
    DENIED(3),

    @JsonbProperty("10")
    VOIDED(10),

    @JsonbProperty("11")
    REFUNDED(11),

    @JsonbProperty("12")
    PENDING(12),

    @JsonbProperty("13")
    ABORTED(13),

    @JsonbProperty("20")
    SCHEDULED(20);

    private Integer value;

    SaleStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static SaleStatus fromValue(Integer v) {
        if (v == null) return null;
        for (SaleStatus status : SaleStatus.values()) {
            if (v.equals(status.getValue())) {
                return status;
            }
        }
        return null;
    }
}
