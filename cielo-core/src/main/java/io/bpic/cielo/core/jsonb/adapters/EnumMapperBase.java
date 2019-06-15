package io.bpic.cielo.client.resteasy.jsonb.adapters;

import javax.json.bind.adapter.JsonbAdapter;
import javax.json.bind.annotation.JsonbProperty;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.Optional.ofNullable;

/**
 * Created: 13/06/2019 12:04.
 *
 * @author paler
 */
@SuppressWarnings({"unchecked", "RedundantClassCall"})
public abstract class EnumMapperBase<A extends Enum<?>> implements JsonbAdapter<A, String> {

    private final Map<String, A> jsonToJavaMapping = new HashMap<>();

    private final Map<A, String> javaToJsonMapping = new IdentityHashMap<>();

    protected EnumMapperBase() {
        Stream.of(getEnumType().getEnumConstants()).forEach(constant -> {
            final String asString;
            try {
                asString = ofNullable(
                        constant.getClass()
                                .getDeclaredField(constant.name())
                                .getAnnotation(JsonbProperty.class))
                        .map(JsonbProperty::value)
                        .orElseGet(constant::name);
            } catch (final NoSuchFieldException e) {
                throw new IllegalArgumentException(e);
            }
            jsonToJavaMapping.put(asString, constant);
            javaToJsonMapping.put(constant, asString);
        });
    }

    private Class<A> getEnumType() {
        return Class.class.cast(ParameterizedType.class.cast(
                getClass().getGenericSuperclass())
                .getActualTypeArguments()[0]);
    }

    @Override
    public String adaptToJson(final A obj) {
        return javaToJsonMapping.get(obj);
    }

    @Override
    public A adaptFromJson(final String obj) {
        return ofNullable(jsonToJavaMapping.get(obj))
                .orElseThrow(() -> new IllegalArgumentException("Unknown enum value: '" + obj + "'"));
    }
}
