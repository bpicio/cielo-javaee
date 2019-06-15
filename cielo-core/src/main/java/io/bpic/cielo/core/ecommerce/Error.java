package io.bpic.cielo.core.ecommerce;

import javax.json.bind.annotation.JsonbProperty;

/**
 * Created: 27/10/2018 13:23.
 *
 * @author Bruno Palermo
 */
public class Error {

    @JsonbProperty(value = "Code")
    private Integer code;

    @JsonbProperty(value = "Message")
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
