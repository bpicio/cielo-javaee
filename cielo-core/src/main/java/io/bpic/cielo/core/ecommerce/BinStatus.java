package io.bpic.cielo.core.ecommerce;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Created: 24/10/2018 01:03.
 *
 * @author Bruno Palermo
 */
@XmlEnum
public enum SaleStatus {

    @XmlEnumValue("0")
    NOT_FINISH(0),

    @XmlEnumValue("1")
    AUTHORIZED(1),

    @XmlEnumValue("2")
    PAYMENT_CONFIRMED(2),

    @XmlEnumValue("3")
    DENIED(3),

    @XmlEnumValue("10")
    VOIDED(10),

    @XmlEnumValue("11")
    REFUNDED(11),

    @XmlEnumValue("12")
    PENDING(12),

    @XmlEnumValue("13")
    ABORTED(13),

    @XmlEnumValue("20")
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
