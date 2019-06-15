package io.bpic.cielo.core.ecommerce;

import io.bpic.cielo.core.Merchant;

/**
 * Created: 23/10/2018 22:47.
 *
 * @author Bruno Palermo
 */
public class CreateSaleRequest extends AbstractSaleRequest {

    CreateSaleRequest(Environment environment, Merchant merchant) {
        super(environment, merchant);
    }

}
