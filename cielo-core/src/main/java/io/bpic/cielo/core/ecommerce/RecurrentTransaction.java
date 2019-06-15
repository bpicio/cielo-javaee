package io.bpic.cielo.core.ecommerce;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created: 23/10/2018 23:08.
 *
 * @author Bruno Palermo
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RecurrentTransaction {

    @XmlElement(name ="PaymentId")
    private String paymentId;

    @XmlElement(name ="PaymentNumber")
    private Integer paymentNumber;

    @XmlElement(name ="TryNumber")
    private Integer tryNumber;

    public String getPaymentId() {
        return paymentId;
    }

    public Integer getPaymentNumber() {
        return paymentNumber;
    }

    public Integer getTryNumber() {
        return tryNumber;
    }

}
