package io.bpic.cielo.core.ecommerce;

/**
 * API Environment URLs
 * <p/>
 * <li>{@link #PRODUCTION}</li>
 * <li>{@link #SANDBOX}</li>
 */
public enum Environment implements io.bpic.cielo.core.Environment {

    /**
     * Environment.PRODUCTION
     * <p/>
     * <li>apiUrl = https://api.cieloecommerce.cielo.com.br/</li>
     * <li>apiQueryUrl = https://apiquery.cieloecommerce.cielo.com.br/</li>
     */
    PRODUCTION("https://api.cieloecommerce.cielo.com.br/", "https://apiquery.cieloecommerce.cielo.com.br/"),

    /**
     * Environment.SANDBOX
     * <p/>
     * <li>apiUrl = https://apisandbox.cieloecommerce.cielo.com.br/</li>
     * <li>apiQueryUrl =
     * https://apiquerysandbox.cieloecommerce.cielo.com.br/</li>
     */
    SANDBOX("https://apisandbox.cieloecommerce.cielo.com.br/", "https://apiquerysandbox.cieloecommerce.cielo.com.br/");

    private final String apiUrl;
    private final String apiQueryUrl;

    Environment(String apiUrl, String apiQueryUrl) {
        this.apiUrl = apiUrl;
        this.apiQueryUrl = apiQueryUrl;
    }

    @Override
    public String getApiUrl() {
        return this.apiUrl;
    }

    @Override
    public String getApiQueryURL() {
        return this.apiQueryUrl;
    }
}