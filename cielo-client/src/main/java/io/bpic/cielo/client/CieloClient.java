package io.bpic.cielo.client;

import io.bpic.cielo.client.exceptions.CieloClientException;
import io.bpic.cielo.client.exceptions.CieloErrorException;
import io.bpic.cielo.client.filters.CieloClientFilter;
import io.bpic.cielo.core.Merchant;
import io.bpic.cielo.core.ecommerce.Error;
import io.bpic.cielo.core.ecommerce.*;
import io.bpic.cielo.core.jsonb.providers.JSONConfigurator;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.List;

/**
 * Created: 14/06/2019 21:19.
 *
 * @author paler
 */
@SuppressWarnings("WeakerAccess")
public class CieloClient {

    private static final String KEYSTORE_FILENAME = "truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "changeit";

    private static  WebTarget sale;
    private static  WebTarget query;

    public CieloClient(Environment environment, Merchant merchant) {
        this(environment, merchant, true);
    }

    public CieloClient(Environment environment, Merchant merchant, boolean useTruststore) {
        KeyStore trustStore = null;
        if (useTruststore) {
            try {
                trustStore = loadTrustStore();
            } catch (KeyStoreException | CertificateException | IOException | NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }

        Client transactionClient = buildClient(merchant, trustStore);
        sale = transactionClient.target(environment.getApiUrl());

        Client queryClient = buildClient(merchant, trustStore);
        query = queryClient.target(environment.getApiQueryURL());
    }

    public SaleResponse createSale(Sale sale) throws CieloClientException {
        Response response = CieloClient.sale.
                path("/1/sales").
                request(MediaType.APPLICATION_JSON_TYPE).
                post(Entity.entity(sale, MediaType.APPLICATION_JSON_TYPE), Response.class);
        return handleResponse(response, SaleResponse.class);
    }

    public CardToken cardToken(CreditCard card) throws CieloClientException {
        Response response = sale.
                path("/1/card").
                request(MediaType.APPLICATION_JSON_TYPE).
                post(Entity.entity(card, MediaType.APPLICATION_JSON_TYPE), Response.class);
        return handleResponse(response, CardToken.class);
    }

    public Payment cancelSale(String paymentId) throws CieloClientException {
        Response response = sale.
                path(UriBuilder.fromPath("/1/sales/{paymentId}/void").build(paymentId).toString()).
                request(MediaType.APPLICATION_JSON_TYPE).
                put(Entity.json(null), Response.class);
        return handleResponse(response, Payment.class);
    }

    public Payment cancelSale(String paymentId, Integer amount) throws CieloClientException {
        String url = UriBuilder.
                fromPath("/1/sales/{paymentId}/void").
                build(paymentId).
                toString();

        Response response = sale.
                path(url).
                queryParam("amount", amount).
                request(MediaType.APPLICATION_JSON_TYPE).
                put(Entity.json(null), Response.class);
        return handleResponse(response, Payment.class);
    }

    public SaleResponse querySale(String paymentId) throws CieloClientException {
        Response response = query.
                path(UriBuilder.fromPath("/1/sales/{paymentId}").build(paymentId).toString()).
                request(MediaType.APPLICATION_JSON_TYPE).
                get(Response.class);
        return handleResponse(response, SaleResponse.class);
    }

    public BinResponse queryBin(Integer bin) throws CieloClientException {
        Response response = query.
                path(UriBuilder.fromPath("/1/cardBin/{bin}").build(bin).toString()).
                request(MediaType.APPLICATION_JSON_TYPE).
                get(Response.class);
        return handleResponse(response, BinResponse.class);
    }

    @SuppressWarnings("Duplicates")
    private static <T> T handleResponse(Response response, Class<T> classType) throws CieloClientException {
        if (response.getStatusInfo().getFamily() == Response.Status.Family.SUCCESSFUL) {
            return response.readEntity(classType);
        }
        else if (response.getStatusInfo().getFamily() == Response.Status.Family.CLIENT_ERROR) {
            List<Error> error = response.readEntity(new GenericType<List<Error>>(){});
            throw new CieloErrorException(response, error);
        }
        else {
            throw new CieloClientException(response);
        }
    }

    private static Client buildClient(Merchant merchant, KeyStore trustStore) {
        ClientBuilder builder = ClientBuilder.
                newBuilder().
                register(JSONConfigurator.class).
                register(new CieloClientFilter(merchant));

        if (trustStore != null)
            builder = builder.trustStore(trustStore);

        return builder.build();
    }

    private static KeyStore loadTrustStore()
            throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException {
        ClassLoader classLoader = CieloClient.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream(KEYSTORE_FILENAME);

        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());

        trustStore.load(is, TRUSTSTORE_PASSWORD.toCharArray());
        return trustStore;
    }
}
