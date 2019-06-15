package io.bpic.cielo.core.ecommerce;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created: 23/10/2018 22:52.
 *
 * @author Bruno Palermo
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Payment {

    @XmlElement(name ="ServiceTaxAmount")
    private Integer serviceTaxAmount;

    @XmlElement(name ="Installments")
    private Integer installments;

    @XmlElement(name ="Interest")
    private Interest interest;

    @XmlElement(name ="Capture")
    private boolean capture = false;

    @XmlElement(name ="Authenticate")
    private boolean authenticate = false;

    @XmlElement(name ="Recurrent")
    private boolean recurrent;

    @XmlElement(name ="RecurrentPayment")
    private RecurrentPayment recurrentPayment;

    @XmlElement(name ="CreditCard")
    private CreditCard creditCard;

    @XmlElement(name ="DebitCard")
    private DebitCard debitCard;

    @XmlElement(name ="Tid")
    private String tid;

    @XmlElement(name ="ProofOfSale")
    private String proofOfSale;

    @XmlElement(name ="AuthorizationCode")
    private String authorizationCode;

    @XmlElement(name ="SoftDescriptor")
    private String softDescriptor = "";

    @XmlElement(name ="ReturnUrl")
    private String returnUrl;

    @XmlElement(name ="Provider")
    private Provider provider;

    @XmlElement(name ="PaymentId")
    private String paymentId;

    @XmlElement(name ="Type")
    private CardType type;

    @XmlElement(name ="Amount")
    private Integer amount;

    @XmlElement(name ="ReceivedDate")
    private String receivedDate;

    @XmlElement(name ="CapturedAmount")
    private Integer capturedAmount;

    @XmlElement(name ="CapturedDate")
    private String capturedDate;

    @XmlElement(name ="Currency")
    private Currency currency;

    @XmlElement(name ="Country")
    private String country;

    @XmlElement(name ="ReturnCode")
    private String returnCode;

    @XmlElement(name ="ReturnMessage")
    private String returnMessage;

    @XmlElement(name ="Status")
    private Status status;

    @XmlElement(name = "IsSplitted")
    private boolean splitted;

    @XmlElement(name ="Links")
    private List<Link> links = new ArrayList<>();

    @XmlElement(name ="ExtraDataCollection")
    private Object extraDataCollection[];

    @XmlElement(name ="ExpirationDate")
    private String expirationDate;

    @XmlElement(name ="Url")
    private String url;

    @XmlElement(name ="Number")
    private String number;

    @XmlElement(name ="BarCodeNumber")
    private String barCodeNumber;

    @XmlElement(name ="DigitableLine")
    private String digitableLine;

    @XmlElement(name ="Address")
    private String address;

    @XmlElement(name ="BoletoNumber")
    private String boletoNumber;

    @XmlElement(name ="Assignor")
    private String assignor;

    @XmlElement(name ="Demonstrative")
    private String demonstrative;

    @XmlElement(name ="Identification")
    private String identification;

    @XmlElement(name ="Instructions")
    private String instructions;

    @XmlElement(name ="AuthenticationUrl")
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
        setType(CardType.CREDIT_CARD);
        setCreditCard(new CreditCard(securityCode, brand));

        return getCreditCard();
    }

    public DebitCard debitCard(String securityCode, Brand brand) {
        setType(CardType.DEBIT_CARD);
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

    public Status getStatus() {
        return status;
    }

    public Payment setStatus(Status status) {
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

    public CardType getType() {
        return type;
    }

    public Payment setType(CardType type) {
        this.type = type;
        return this;
    }

    public String getAddress() {
        return address;
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

    public String getDigitableLine() {
        return digitableLine;
    }

    public String getExpirationDate() {
        return expirationDate;
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

}