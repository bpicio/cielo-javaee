package io.bpic.cielo.core.jsonb.providers;

import io.bpic.cielo.core.jsonb.util.JsonbUtil;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.ext.ContextResolver;

/**
 * Created: 14/06/2019 17:46.
 *
 * @author paler
 */
public class JSONConfigurator implements ContextResolver<Jsonb> {

    @Override
    public Jsonb getContext(Class aClass) {
        return JsonbBuilder.newBuilder()
                .withConfig(JsonbUtil.createJSONBConfig())
                .build();
    }

}
