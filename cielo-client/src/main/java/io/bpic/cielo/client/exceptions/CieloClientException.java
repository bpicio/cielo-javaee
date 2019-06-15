package io.bpic.cielo.client.exceptions;

import javax.ws.rs.core.Response;

/**
 * Created: 24/10/2018 20:52.
 *
 * @author Bruno Palermo
 */
public class CieloClientException extends Exception {

    private Response response;

    public CieloClientException(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }
}
