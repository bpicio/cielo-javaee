package io.bpic.cielo.client.execptions;

import io.bpic.cielo.core.ecommerce.Error;

import javax.ws.rs.core.Response;

/**
 * Created: 24/10/2018 20:52.
 *
 * @author Bruno Palermo
 */
public class CieloErrorException extends CieloClientException {

    private Error[] error;

    public CieloErrorException(Response response, Error[] error) {
        super(response);
        this.error = error;
    }

    public Error[] getError() {
        return error;
    }
}
