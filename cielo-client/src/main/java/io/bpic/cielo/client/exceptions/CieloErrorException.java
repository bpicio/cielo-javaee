package io.bpic.cielo.client.exceptions;

import io.bpic.cielo.core.ecommerce.Error;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created: 24/10/2018 20:52.
 *
 * @author Bruno Palermo
 */
public class CieloErrorException extends CieloClientException {

    private List<Error> error;

    public CieloErrorException(Response response, List<Error> error) {
        super(response);
        this.error = error;
    }

    public List<Error> getError() {
        return error;
    }
}
