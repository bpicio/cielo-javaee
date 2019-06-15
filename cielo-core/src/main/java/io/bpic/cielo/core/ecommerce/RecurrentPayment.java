package io.bpic.cielo.core.ecommerce;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created: 23/10/2018 23:02.
 *
 * @author Bruno Palermo
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RecurrentPayment {

    @XmlElement(name ="RecurrentPaymentId")
    private String recurrentPaymentId;

    @XmlElement(name ="NextRecurrency")
    private String nextRecurrence;

    @XmlElement(name ="StartDate")
    private String startDate;

    @XmlElement(name ="EndDate")
    private String endDate;

    @XmlElement(name ="Interval")
    private RecurrentInterval interval;

    @XmlElement(name ="Amount")
    private Integer amount;

    @XmlElement(name ="Country")
    private String country;

    @XmlElement(name ="CreateDate")
    private String createDate;

    @XmlElement(name ="Currency")
    private Currency currency;

    @XmlElement(name ="CurrentRecurrencyTry")
    private Integer currentRecurrenceTry;

    @XmlElement(name ="Provider")
    private Provider provider;

    @XmlElement(name ="RecurrencyDay")
    private Integer recurrenceDay;

    @XmlElement(name ="SuccessfulRecurrences")
    private Integer successfulRecurrences;

    @XmlElement(name ="AuthorizeNow")
    private boolean authorizeNow;

    @XmlElement(name ="ReasonCode")
    private Integer reasonCode;

    @XmlElement(name ="ReasonMessage")
    private String reasonMessage;

    @XmlElement(name ="Status")
    private Integer status;

    @XmlElement(name ="Link")
    private Object links[];

    @XmlElement(name ="RecurrentTransactions")
    private List<RecurrentTransaction> recurrentTransactions = new ArrayList<>();

    public RecurrentPayment() {
    }

    public RecurrentPayment(boolean authorizeNow) {
        this.authorizeNow = authorizeNow;
    }

    public boolean isAuthorizeNow() {
        return authorizeNow;
    }

    public RecurrentPayment setAuthorizeNow(boolean authorizeNow) {
        this.authorizeNow = authorizeNow;
        return this;
    }

    public String getRecurrentPaymentId() {
        return recurrentPaymentId;
    }

    public RecurrentPayment setRecurrentPaymentId(String recurrentPaymentId) {
        this.recurrentPaymentId = recurrentPaymentId;
        return this;
    }

    public String getNextRecurrence() {
        return nextRecurrence;
    }

    public RecurrentPayment setNextRecurrence(String nextRecurrence) {
        this.nextRecurrence = nextRecurrence;
        return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public RecurrentPayment setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getEndDate() {
        return endDate;
    }

    public RecurrentPayment setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    public RecurrentInterval getInterval() {
        return interval;
    }

    public RecurrentPayment setInterval(RecurrentInterval interval) {
        this.interval = interval;
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    public RecurrentPayment setAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public RecurrentPayment setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCreateDate() {
        return createDate;
    }

    public RecurrentPayment setCreateDate(String createDate) {
        this.createDate = createDate;
        return this;
    }

    public Currency getCurrency() {
        return currency;
    }

    public RecurrentPayment setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public Integer getCurrentRecurrenceTry() {
        return currentRecurrenceTry;
    }

    public RecurrentPayment setCurrentRecurrenceTry(Integer currentRecurrenceTry) {
        this.currentRecurrenceTry = currentRecurrenceTry;
        return this;
    }

    public Provider getProvider() {
        return provider;
    }

    public RecurrentPayment setProvider(Provider provider) {
        this.provider = provider;
        return this;
    }

    public Integer getRecurrenceDay() {
        return recurrenceDay;
    }

    public RecurrentPayment setRecurrenceDay(Integer recurrenceDay) {
        this.recurrenceDay = recurrenceDay;
        return this;
    }

    public Integer getSuccessfulRecurrences() {
        return successfulRecurrences;
    }

    public RecurrentPayment setSuccessfulRecurrences(Integer successfulRecurrences) {
        this.successfulRecurrences = successfulRecurrences;
        return this;
    }

    public Integer getReasonCode() {
        return reasonCode;
    }

    public RecurrentPayment setReasonCode(Integer reasonCode) {
        this.reasonCode = reasonCode;
        return this;
    }

    public String getReasonMessage() {
        return reasonMessage;
    }

    public RecurrentPayment setReasonMessage(String reasonMessage) {
        this.reasonMessage = reasonMessage;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public RecurrentPayment setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public List<RecurrentTransaction> getRecurrentTransactions() {
        return recurrentTransactions;
    }

    public RecurrentPayment setRecurrentTransactions(List<RecurrentTransaction> recurrentTransactions) {
        this.recurrentTransactions = recurrentTransactions;
        return this;
    }

    public Object[] getLinks() {
        return links;
    }

}
