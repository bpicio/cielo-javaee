package io.bpic.cielo.core.jsonb.adapters;

import javax.json.bind.adapter.JsonbAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created: 14/06/2019 19:31.
 *
 * @author paler
 */
public class BoletoExpirationDateMapper implements JsonbAdapter<LocalDate, String> {

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy");

    @Override
    public String adaptToJson(LocalDate v) throws Exception {
        if (v == null) return null;
        return dtf.format(v);
    }

    @Override
    public LocalDate adaptFromJson(String v) throws Exception {
        if (v == null || v.isEmpty()) return null;
        try {
            return LocalDate.parse(v, dtf);
        } catch (Exception e) {
            return null;
        }
    }
}
