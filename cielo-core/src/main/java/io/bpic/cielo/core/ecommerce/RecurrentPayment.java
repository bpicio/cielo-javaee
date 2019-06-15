package io.bpic.cielo.core.ecommerce;

import javax.json.bind.annotation.JsonbProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Created: 23/10/2018 23:02.
 *
 * @author Bruno Palermo
 */
@SuppressWarnings("WeakerAccess")
public class RecurrentPayment {

    @JsonbProperty(value ="RecurrentPaymentId")
    private String recurrentPaymentId;

    @JsonbProperty(value ="NextRecurrency")
    private String nextRecurrence;

    @JsonbProperty(value ="StartDate")
    private String startDate;

    @JsonbProperty(value ="EndDate")
    private String endDate;

    @JsonbProperty(value ="Interval")
    private RecurrentInterval interval;

    @JsonbProperty(value ="Amount")
    private Integer amount;

    @JsonbProperty(value ="Country")
    private String country;

    @JsonbProperty(value ="CreateDate")
    private String createDate;

    @JsonbProperty(value ="Currency")
    private Currency currency;

    @JsonbProperty(value ="CurrentRecurrencyTry")
    private Integer currentRecurrenceTry;

    @JsonbProperty(value ="Provider")
    private Provider provider;

    @JsonbProperty(value ="RecurrencyDay")
    private Integer recurrenceDay;

    @JsonbProperty(value ="SuccessfulRecurrences")
    private Integer successfulRecurrences;

    @JsonbProperty(value ="AuthorizeNow")
    private boolean authorizeNow;

    @JsonbProperty(value ="ReasonCode")
    private Integer reasonCode;

    @JsonbProperty(value ="ReasonMessage")
    private String reasonMessage;

    @JsonbProperty(value ="SaleStatus")
    private Integer status;

    @JsonbProperty(value ="Link")
    private Object[] links;

    @JsonbProperty(value ="RecurrentTransactions")
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

    public void setLinks(Object[] links) {
        this.links = links;
    }
}
