package io.bpic.cielo.core.ecommerce;

import javax.json.bind.annotation.JsonbProperty;
import java.time.LocalDate;
import java.util.List;

/**
 * Created: 23/10/2018 22:52.
 *
 * @author Bruno Palermo
 */
@SuppressWarnings("WeakerAccess")
public class Payment {

    @JsonbProperty(value ="ServiceTaxAmount")
    private Integer serviceTaxAmount;

    @JsonbProperty(value ="Installments")
    private Integer installments;

    @JsonbProperty(value ="Interest")
    private Interest interest;

    @JsonbProperty(value ="Capture")
    private boolean capture = false;

    @JsonbProperty(value ="Authenticate")
    private boolean authenticate = false;

    @JsonbProperty(value ="Recurrent")
    private boolean recurrent;

    @JsonbProperty(value ="RecurrentPayment")
    private RecurrentPayment recurrentPayment;

    @JsonbProperty(value ="CreditCard")
    private CreditCard creditCard;

    @JsonbProperty(value ="DebitCard")
    private DebitCard debitCard;

    @JsonbProperty(value ="Tid")
    private String tid;

    @JsonbProperty(value ="ProofOfSale")
    private String proofOfSale;

    @JsonbProperty(value ="AuthorizationCode")
    private String authorizationCode;

    @JsonbProperty(value ="SoftDescriptor")
    private String softDescriptor = "";

    @JsonbProperty(value ="ReturnUrl")
    private String returnUrl;

    @JsonbProperty(value ="Provider")
    private Provider provider;

    @JsonbProperty(value ="ProviderReturnCode")
    private Integer providerReturnCode;

    @JsonbProperty(value ="ProviderReturnMessage")
    private String providerReturnMessage;

    @JsonbProperty(value ="PaymentId")
    private String paymentId;

    @JsonbProperty(value ="Type")
    private PaymentType type;

    @JsonbProperty(value ="Amount")
    private Integer amount;

    @JsonbProperty(value ="ReceivedDate")
    private String receivedDate;

    @JsonbProperty(value ="CapturedAmount")
    private Integer capturedAmount;

    @JsonbProperty(value ="CapturedDate")
    private String capturedDate;

    @JsonbProperty(value ="Currency")
    private Currency currency;

    @JsonbProperty(value ="Country")
    private String country;

    @JsonbProperty(value ="ReasonCode")
    private Integer reasonCode;

    @JsonbProperty(value ="ReasonMessage")
    private String reasonMessage;

    @JsonbProperty(value ="ReturnCode")
    private String returnCode;

    @JsonbProperty(value ="ReturnMessage")
    private String returnMessage;

    @JsonbProperty(value ="Status")
    private SaleStatus status;

    @JsonbProperty(value = "IsSplitted")
    private boolean splitted;

    @JsonbProperty(value ="Links")
    private List<Link> links;

    @JsonbProperty(value = "ExtraDataCollection")
    private Object[] extraDataCollection;

    @JsonbProperty(value ="ExpirationDate")
    private LocalDate expirationDate;

    @JsonbProperty(value ="Url")
    private String url;

    @JsonbProperty(value ="Number")
    private String number;

    @JsonbProperty(value ="BarCodeNumber")
    private String barCodeNumber;

    @JsonbProperty(value ="DigitableLine")
    private String digitableLine;

    @JsonbProperty(value ="Address")
    private String address;

    @JsonbProperty(value ="BoletoNumber")
    private String boletoNumber;

    @JsonbProperty(value ="Assignor")
    private String assignor;

    @JsonbProperty(value ="Demonstrative")
    private String demonstrative;

    @JsonbProperty(value ="Identification")
    private String identification;

    @JsonbProperty(value ="Instructions")
    private String instructions;

    @JsonbProperty(value ="AuthenticationUrl")
    private String authenticationUrl;

    public Payment() {
    }

    public Payment(Integer amount, Integer installments) {
        setAmount(amount);
        setInstallments(installments);
    }

    public Payment(Integer amount) {
        this(amount, 1);
    }

    public CreditCard creditCard(String securityCode, Brand brand) {
        setType(PaymentType.CREDIT_CARD);
        setCreditCard(new CreditCard(securityCode, brand));

        return getCreditCard();
    }

    public DebitCard debitCard(String securityCode, Brand brand) {
        setType(PaymentType.DEBIT_CARD);
        setDebitCard(new DebitCard(securityCode, brand));

        return getDebitCard();
    }

    public RecurrentPayment recurrentPayment(boolean authorizeNow) {
        setRecurrentPayment(new RecurrentPayment(authorizeNow));

        return getRecurrentPayment();
    }

    public Integer getAmount() {
        return amount;
    }

    public Payment setAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public boolean getAuthenticate() {
        return authenticate;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public String getAuthenticationUrl() {
        return authenticationUrl;
    }

    public void setSplitted(boolean splitted) {
        this.splitted = splitted;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public void setExtraDataCollection(Object[] extraDataCollection) {
        this.extraDataCollection = extraDataCollection;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setAuthenticationUrl(String authenticationUrl) {
        this.authenticationUrl = authenticationUrl;
    }

    public Payment setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
        return this;
    }

    public boolean getCapture() {
        return capture;
    }

    public Integer getCapturedAmount() {
        return capturedAmount;
    }

    public Payment setCapturedAmount(Integer capturedAmount) {
        this.capturedAmount = capturedAmount;
        return this;
    }

    public String getCapturedDate() {
        return capturedDate;
    }

    public Payment setCapturedDate(String capturedDate) {
        this.capturedDate = capturedDate;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Payment setCountry(String country) {
        this.country = country;
        return this;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public Payment setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
        return this;
    }

    public Payment setDebitCard(DebitCard debitCard) {
        this.debitCard = debitCard;
        return this;
    }

    public DebitCard getDebitCard() {
        return debitCard;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Payment setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public Integer getInstallments() {
        return installments;
    }

    public Payment setInstallments(Integer installments) {
        this.installments = installments;
        return this;
    }

    public Interest getInterest() {
        return interest;
    }

    public Payment setInterest(Interest interest) {
        this.interest = interest;
        return this;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public Payment setPaymentId(String paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    public String getProofOfSale() {
        return proofOfSale;
    }

    public Payment setProofOfSale(String proofOfSale) {
        this.proofOfSale = proofOfSale;
        return this;
    }

    public Provider getProvider() {
        return provider;
    }

    public Payment setProvider(Provider provider) {
        this.provider = provider;
        return this;
    }

    public String getReceivedDate() {
        return receivedDate;
    }

    public Payment setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
        return this;
    }

    public boolean isRecurrent() {
        return recurrent;
    }

    public Payment setRecurrent(boolean recurrent) {
        this.recurrent = recurrent;
        return this;
    }

    public RecurrentPayment getRecurrentPayment() {
        return recurrentPayment;
    }

    public Payment setRecurrentPayment(RecurrentPayment recurrentPayment) {
        this.recurrentPayment = recurrentPayment;
        return this;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public Payment setReturnCode(String returnCode) {
        this.returnCode = returnCode;
        return this;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public Payment setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
        return this;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public Payment setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
        return this;
    }

    public Integer getServiceTaxAmount() {
        return serviceTaxAmount;
    }

    public Payment setServiceTaxAmount(Integer serviceTaxAmount) {
        this.serviceTaxAmount = serviceTaxAmount;
        return this;
    }

    public String getSoftDescriptor() {
        return softDescriptor;
    }

    public Payment setSoftDescriptor(String softDescriptor) {
        this.softDescriptor = softDescriptor;
        return this;
    }

    public SaleStatus getStatus() {
        return status;
    }

    public Payment setStatus(SaleStatus status) {
        this.status = status;
        return this;
    }

    public boolean isSplitted() {
        return splitted;
    }

    public String getTid() {
        return tid;
    }

    public Payment setTid(String tid) {
        this.tid = tid;
        return this;
    }

    public PaymentType getType() {
        return type;
    }

    public Payment setType(PaymentType type) {
        this.type = type;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Payment setAddress(String address) {
        this.address = address;
        return this;
    }

    public boolean isAuthenticate() {
        return authenticate;
    }

    public Payment setAuthenticate(boolean authenticate) {
        this.authenticate = authenticate;
        return this;
    }

    public String getBarCodeNumber() {
        return barCodeNumber;
    }

    public void setBarCodeNumber(String barCodeNumber) {
        this.barCodeNumber = barCodeNumber;
    }

    public boolean isCapture() {
        return capture;
    }

    public Payment setCapture(boolean capture) {
        this.capture = capture;
        return this;
    }

    public String getBoletoNumber() {
        return boletoNumber;
    }

    public Payment setBoletoNumber(String boletoNumber) {
        this.boletoNumber = boletoNumber;
        return this;
    }

    public String getAssignor() {
        return assignor;
    }

    public Payment setAssignor(String assignor) {
        this.assignor = assignor;
        return this;
    }

    public String getDemonstrative() {
        return demonstrative;
    }

    public Payment setDemonstrative(String demonstrative) {
        this.demonstrative = demonstrative;
        return this;
    }

    public String getIdentification() {
        return identification;
    }

    public Payment setIdentification(String identification) {
        this.identification = identification;
        return this;
    }

    public String getInstructions() {
        return instructions;
    }

    public Payment setInstructions(String instructions) {
        this.instructions = instructions;
        return this;
    }

    public Integer getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(Integer reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getDigitableLine() {
        return digitableLine;
    }

    public void setDigitableLine(String digitableLine) {
        this.digitableLine = digitableLine;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public Payment setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public Object[] getExtraDataCollection() {
        return extraDataCollection;
    }

    public List<Link> getLinks() {
        return links;
    }

    public String getNumber() {
        return number;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getReasonMessage() {
        return reasonMessage;
    }

    public void setReasonMessage(String reasonMessage) {
        this.reasonMessage = reasonMessage;
    }

    public Integer getProviderReturnCode() {
        return providerReturnCode;
    }

    public void setProviderReturnCode(Integer providerReturnCode) {
        this.providerReturnCode = providerReturnCode;
    }

    public String getProviderReturnMessage() {
        return providerReturnMessage;
    }

    public void setProviderReturnMessage(String providerReturnMessage) {
        this.providerReturnMessage = providerReturnMessage;
    }
}
