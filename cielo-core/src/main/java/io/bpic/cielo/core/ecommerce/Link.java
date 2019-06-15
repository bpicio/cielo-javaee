package io.bpic.cielo.core.ecommerce;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created: 24/10/2018 00:18.
 *
 * @author Bruno Palermo
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Link {

    @XmlElement(name = "Method")
    private String method;

    @XmlElement(name = "Rel")
    private String rel;

    @XmlElement(name = "Href")
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
