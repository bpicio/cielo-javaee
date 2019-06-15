package io.bpic.cielo.core.ecommerce;

/**
 * API Environment URLs
 *
 * {@link #PRODUCTION}
 * {@link #SANDBOX}
 */
public enum Environment implements io.bpic.cielo.core.Environment {

    /**
     * Environment.PRODUCTION
     *
     * apiUrl = https://api.cieloecommerce.cielo.com.br/
     * apiQueryUrl = https://apiquery.cieloecommerce.cielo.com.br/
     */
    PRODUCTION("https://api.cieloecommerce.cielo.com.br/", "https://apiquery.cieloecommerce.cielo.com.br/"),

    /**
     * Environment.SANDBOX
     *
     * apiUrl = https://apisandbox.cieloecommerce.cielo.com.br/
     * apiQueryUrl = https://apiquerysandbox.cieloecommerce.cielo.com.br/
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
