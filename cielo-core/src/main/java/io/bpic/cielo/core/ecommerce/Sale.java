package io.bpic.cielo.core.ecommerce;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created: 23/10/2018 22:50.
 *
 * @author Bruno Palermo
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Sale {

    @XmlElement(name ="MerchantOrderId")
    private String merchantOrderId;

    @XmlElement(name ="Customer")
    private Customer customer;

    @XmlElement(name ="Payment")
    private Payment payment;

    public Sale() {
    }

    public Sale(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    public Customer customer(String name) {
        setCustomer(new Customer(name));

        return getCustomer();
    }

    public Payment payment(Integer amount, Integer installments) {
        setPayment(new Payment(amount, installments));

        return getPayment();
    }

    public Payment payment(Integer amount) {
        return payment(amount, 1);
    }

    public Customer getCustomer() {
        return customer;
    }

    public Sale setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public Sale setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
        return this;
    }

    public Payment getPayment() {
        return payment;
    }

    public Sale setPayment(Payment payment) {
        this.payment = payment;
        return this;
    }

}
