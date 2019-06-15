package io.bpic.cielo.core.ecommerce;

import io.bpic.cielo.core.jsonb.util.JsonbUtil;
import org.junit.Before;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.InputStream;

/**
 * Created: 24/10/2018 00:10.
 *
 * @author Bruno Palermo
 */
public abstract class AbstractFileTest {

    private static Jsonb jsonB;

    @Before
    public void before() {
        jsonB = JsonbBuilder.newBuilder()
                .withConfig(JsonbUtil.createJSONBConfig())
                .build();
    }

    <T> T readFile(String filename, Class<T> valueType) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream stream = classLoader.getResourceAsStream(filename);

        return jsonB.fromJson(stream, valueType);
    }

}
