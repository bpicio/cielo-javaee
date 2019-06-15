package io.bpic.cielo.core.ecommerce;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Created: 23/10/2018 23:03.
 *
 * @author Bruno Palermo
 */
@XmlEnum
public enum RecurrentInterval {

    @XmlEnumValue(value = "Monthly")
    MONTHLY,

    @XmlEnumValue(value = "Bimonthly")
    BI_MONTHLY,

    @XmlEnumValue(value = "Quarterly")
    QUATERLY,

    @XmlEnumValue(value = "SemiAnnual")
    SEMI_ANNUAL,

    @XmlEnumValue(value = "Annual")
    ANNUAL

}
