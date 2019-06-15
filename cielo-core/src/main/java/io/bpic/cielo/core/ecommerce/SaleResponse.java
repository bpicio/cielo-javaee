package io.bpic.cielo.core.ecommerce;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created: 24/10/2018 00:16.
 *
 * @author Bruno Palermo
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleResponse {

    @XmlElement(name = "MerchantOrderId")
    private String merchantOrderId;

    @XmlElement(name = "Customer")
    private Customer customer;

    @XmlElement(name = "Payment")
    private Payment payment;

    @XmlElement(name = "Status")
    private String status;

    @XmlElement(name = "ReasonCode")
    private String reasonCode;

    @XmlElement(name = "ReasonMessage")
    private String reasonMessage;

    @XmlElement(name = "ProviderReturnCode")
    private String providerReturnCode;

    @XmlElement(name = "ProviderReturnMessage")
    private String providerReturnMessage;

    @XmlElement(name = "ReturnCode")
    private String returnCode;

    @XmlElement(name = "ReturnMessage")
    private String returnMessage;

    @XmlElement(name = "AuthenticationUrl")
    private String authenticationUrl;

    @XmlElement(name = "Link")
    private List<Link> links = new ArrayList<>();

    public SaleResponse() {
    }

    public SaleResponse(String status, String reasonCode, String reasonMessage, String providerReturnCode, String providerReturnMessage, String returnCode, String returnMessage, List<Link> links) {
        this.status = status;
        this.reasonCode = reasonCode;
        this.reasonMessage = reasonMessage;
        this.providerReturnCode = providerReturnCode;
        this.providerReturnMessage = providerReturnMessage;
        this.returnCode = returnCode;
        this.returnMessage = returnMessage;
        this.links = links;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getStatus() {
        return status;
    }

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getReasonMessage() {
        return reasonMessage;
    }

    public void setReasonMessage(String reasonMessage) {
        this.reasonMessage = reasonMessage;
    }

    public String getProviderReturnCode() {
        return providerReturnCode;
    }

    public void setProviderReturnCode(String providerReturnCode) {
        this.providerReturnCode = providerReturnCode;
    }

    public String getProviderReturnMessage() {
        return providerReturnMessage;
    }

    public void setProviderReturnMessage(String providerReturnMessage) {
        this.providerReturnMessage = providerReturnMessage;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public String getAuthenticationUrl() {
        return authenticationUrl;
    }

    public void setAuthenticationUrl(String authenticationUrl) {
        this.authenticationUrl = authenticationUrl;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
    
}
