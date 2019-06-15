package io.bpic.cielo.core.ecommerce;

import io.bpic.cielo.core.jsonb.util.JsonbUtil;

import javax.json.bind.JsonbBuilder;
import javax.json.bind.annotation.JsonbProperty;

/**
 * Created: 23/10/2018 22:50.
 *
 * @author Bruno Palermo
 */
@SuppressWarnings("WeakerAccess")
public class Sale {

    @JsonbProperty(value ="MerchantOrderId")
    private String merchantOrderId;

    @JsonbProperty(value ="Customer")
    private Customer customer;

    @JsonbProperty(value ="Payment")
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

    public String toJson() {
        return JsonbBuilder.newBuilder().
                withConfig(JsonbUtil.createJSONBConfig()).
                build().
                toJson(this);
    }

}
