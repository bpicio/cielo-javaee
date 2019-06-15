package io.bpic.cielo.core.ecommerce;

import javax.json.bind.annotation.JsonbProperty;

/**
 * Created: 25/10/2018 19:25.
 *
 * @author Bruno Palermo
 */
public class TokenResponse {

    @JsonbProperty(value = "CardToken")
    private String cardToken;

    @JsonbProperty(value = "Links")
    private Link link;

    public String getCardToken() {
        return cardToken;
    }

    public void setCardToken(String cardToken) {
        this.cardToken = cardToken;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }
}
