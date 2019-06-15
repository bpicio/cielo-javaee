package io.bpic.cielo.client.resteasy.providers;

import io.bpic.cielo.client.resteasy.jsonb.adapters.PaymentTypeMapper;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.ws.rs.ext.ContextResolver;

/**
 * Created: 14/06/2019 17:46.
 *
 * @author paler
 */
public class JSONConfigurator implements ContextResolver<Jsonb> {

    @Override
    public Jsonb getContext(Class aClass) {
        JsonbConfig config = new JsonbConfig()
                .withAdapters(
                        new PaymentTypeMapper()
                )
                .withNullValues(false);

        return JsonbBuilder.newBuilder()
                .withConfig(config)
                .build();
    }
}
