package io.bpic.cielo.core.ecommerce;

import io.bpic.cielo.core.Merchant;

/**
 * Created: 23/10/2018 22:46.
 *
 * @author Bruno Palermo
 */
public abstract class AbstractSaleRequest {

    private final Environment environment;

    private final Merchant merchant;

    AbstractSaleRequest(Environment environment, Merchant merchant) {
        this.environment = environment;
        this.merchant = merchant;
    }

}
