package io.bpic.cielo.client.filters;

import io.bpic.cielo.client.CieloHeaders;
import io.bpic.cielo.core.Merchant;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import java.io.IOException;
import java.util.UUID;

/**
 * Created: 24/10/2018 19:59.
 *
 * @author Bruno Palermo
 */
public class CieloClientFilter implements ClientRequestFilter {

    private String merchantId;

    private String merchantKey;

    public CieloClientFilter(Merchant merchant) {
        this(merchant.getId(), merchant.getKey());
    }

    public CieloClientFilter(String merchantId, String merchantKey) {
        this.merchantId = merchantId;
        this.merchantKey = merchantKey;
    }

    @Override
    public void filter(ClientRequestContext ctx) throws IOException {
        ctx.getHeaders().add(CieloHeaders.HEADER_MERCHANT_ID, merchantId);
        ctx.getHeaders().add(CieloHeaders.HEADER_MERCHANT_KEY, merchantKey);
        ctx.getHeaders().add(CieloHeaders.HEADER_REQUEST_ID, UUID.randomUUID().toString());
    }
}
