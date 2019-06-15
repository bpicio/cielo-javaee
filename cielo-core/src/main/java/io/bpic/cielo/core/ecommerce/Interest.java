package io.bpic.cielo.core.ecommerce;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Created: 24/10/2018 00:46.
 *
 * @author Bruno Palermo
 */
@XmlEnum
public enum Interest {

    @XmlEnumValue("ByMerchant")
    BY_MERCHANT,

    @XmlEnumValue("ByIssuer")
    BY_ISSUER,
}
