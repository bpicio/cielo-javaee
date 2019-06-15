package io.bpic.cielo.core.ecommerce;

import javax.json.bind.annotation.JsonbProperty;

/**
 * Created: 24/10/2018 00:18.
 *
 * @author Bruno Palermo
 */
public class Link {

    @JsonbProperty(value = "Method")
    private String method;

    @JsonbProperty(value = "Rel")
    private String rel;

    @JsonbProperty(value = "Href")
    private String href;

    public Link() {
    }

    public Link(String method, String rel, String href) {
        this.method = method;
        this.rel = rel;
        this.href = href;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
