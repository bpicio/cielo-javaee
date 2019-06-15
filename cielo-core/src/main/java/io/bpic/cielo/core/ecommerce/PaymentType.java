package io.bpic.cielo.core.ecommerce;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Created: 23/10/2018 22:55.
 *
 * @author Bruno Palermo
 */
@XmlEnum
public enum CardType {

    @XmlEnumValue(value = "CreditCard")
    CREDIT_CARD,

    @XmlEnumValue(value = "DebitCard")
    DEBIT_CARD,

    @XmlEnumValue(value = "ElectronicTransfer")
    ELETRONIC_TRANSFER,

    @XmlEnumValue("Boleto")
    BOLETO

}
