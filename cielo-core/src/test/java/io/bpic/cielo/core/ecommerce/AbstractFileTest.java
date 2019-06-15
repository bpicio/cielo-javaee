package io.bpic.cielo.core.ecommerce;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import org.junit.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created: 24/10/2018 00:10.
 *
 * @author Bruno Palermo
 */
public abstract class AbstractFileTest {

    private static ObjectMapper mapper;

    @BeforeClass
    public static void beforeClass() {
        JaxbAnnotationModule module = new JaxbAnnotationModule();

        mapper = new ObjectMapper();
        mapper.registerModule(module);
    }

    <T> T readFile(String filename, Class<T> valueType) throws URISyntaxException, IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(filename);
        assert url != null;
        File file = new File(url.toURI());
        return mapper.readValue(file, valueType);
    }

}
