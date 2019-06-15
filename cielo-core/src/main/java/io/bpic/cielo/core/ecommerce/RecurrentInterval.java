package io.bpic.cielo.core.ecommerce;

import javax.json.bind.annotation.JsonbProperty;

/**
 * Created: 23/10/2018 23:03.
 *
 * @author Bruno Palermo
 */
public enum RecurrentInterval {

    @JsonbProperty(value = "Monthly")
    MONTHLY,

    @JsonbProperty(value = "Bimonthly")
    BI_MONTHLY,

    @JsonbProperty(value = "Quarterly")
    QUATERLY,

    @JsonbProperty(value = "SemiAnnual")
    SEMI_ANNUAL,

    @JsonbProperty(value = "Annual")
    ANNUAL

}
