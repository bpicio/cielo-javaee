package io.bpic.cielo.core.ecommerce;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Created: 23/10/2018 22:34.
 *
 * @author Bruno Palermo
 */
@XmlEnum
public enum Brand {

    @XmlEnumValue(value = "Visa")
    VISA,

    @XmlEnumValue(value = "Master")
    MASTER,

    @XmlEnumValue(value = "Amex")
    AMEX,

    @XmlEnumValue(value = "Elo")
    ELO,

    @XmlEnumValue(value = "Aura")
    AURA,

    @XmlEnumValue(value = "JCB")
    JCB,

    @XmlEnumValue(value = "Diners")
    DINERS,

    @XmlEnumValue(value = "Discover")
    DISCOVER,

    @XmlEnumValue(value = "Hipercard")
    HIPERCARD,



}
