package io.bpic.cielo.core.ecommerce;

import javax.json.bind.annotation.JsonbProperty;

/**
 * Created: 27/10/2018 12:56.
 *
 * @author Bruno Palermo
 */
public class BinResponse {

    @JsonbProperty(value = "Status")
    private BinStatus status;

    @JsonbProperty(value = "Provider")
    private String provider;

    @JsonbProperty(value = "CardType")
    private CardType type;

    @JsonbProperty(value = "ForeignCard")
    private boolean foreign;

    public BinStatus getStatus() {
        return status;
    }

    public void setStatus(BinStatus status) {
        this.status = status;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public boolean isForeign() {
        return foreign;
    }

    public void setForeign(boolean foreign) {
        this.foreign = foreign;
    }
}
