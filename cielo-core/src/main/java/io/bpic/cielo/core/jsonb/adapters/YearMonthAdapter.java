package io.bpic.cielo.core.jsonb.adapters;

import javax.json.bind.adapter.JsonbAdapter;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

/**
 * Created: 14/06/2019 19:27.
 *
 * @author paler
 */
public class YearMonthMapper implements JsonbAdapter<YearMonth, String> {

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/yyyy");

    @Override
    public String adaptToJson(YearMonth v) throws Exception {
        if (v == null) return null;
        return dtf.format(v);
    }

    @Override
    public YearMonth adaptFromJson(String v) throws Exception {
        if (v == null || v.isEmpty()) return null;
        try {
            return YearMonth.parse(v, dtf);
        } catch (Exception e) {
            return null;
        }
    }
}
