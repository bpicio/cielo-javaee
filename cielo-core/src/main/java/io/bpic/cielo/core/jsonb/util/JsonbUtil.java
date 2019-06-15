package io.bpic.cielo.core.jsonb.util;

import io.bpic.cielo.core.jsonb.adapters.*;

import javax.json.bind.JsonbConfig;

/**
 * Created: 14/06/2019 19:15.
 *
 * @author paler
 */
public class JsonbUtil {

    public static JsonbConfig createJSONBConfig() {
        return new JsonbConfig()
                .withAdapters(
                        new YearMonthAdapter(),
                        new PaymentTypeAdapter(),
                        new BrandAdapter(),
                        new SaleStatusAdapter(),
                        new BoletoExpirationDateAdapter(),
                        new InterestAdapter(),
                        new ProviderAdapter(),
                        new LocalDateISOAdapter(),
                        new RecurrentInternvalAdapter(),
                        new BinStatusAdapter(),
                        new CardTypeAdapter()
                )
                .withNullValues(false);
    }

}
