package io.bpic.cielo.core.ecommerce;

import javax.json.bind.annotation.JsonbProperty;

/**
 * Created: 27/10/2018 14:18.
 *
 * @author Bruno Palermo
 */
public class Capture {

    @JsonbProperty(value = "Amount")
    private Integer amount;

}
