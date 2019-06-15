package io.bpic.cielo.core.ecommerce;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Created: 23/10/2018 22:54.
 *
 * @author Bruno Palermo
 */
@XmlEnum
public enum Provider {

    @XmlEnumValue(value = "Cielo")
    CIELO,

    @XmlEnumValue(value = "Bradesco")
    BRADESCO,

    @XmlEnumValue(value = "Bradesco2")
    BRADESCO2,

    @XmlEnumValue(value = "BancoDoBrasil")
    BANCO_DO_BRASIL,

    @XmlEnumValue(value = "BancoDoBrasil2")
    BANCO_DO_BRASIL2,

    @XmlEnumValue(value = "Simulado")
    SIMULADO

}
