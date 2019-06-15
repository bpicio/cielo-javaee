package io.bpic.cielo.core.ecommerce;

import org.junit.Test;

import java.time.YearMonth;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created: 23/10/2018 23:12.
 *
 * @author Bruno Palermo
 */
public class SaleTest extends AbstractFileTest {

    @Test
    public void ccSimpleTransactionRequestTest() {
        Sale sale = readFile("cc-transaction-simple-request.json", Sale.class);

        assertNotNull(sale);
        assertEquals("2014111703", sale.getMerchantOrderId());

        Customer customer = sale.getCustomer();
        assertNotNull(customer);
        assertEquals("Comprador crédito simples", customer.getName());

        Payment payment = sale.getPayment();
        assertNotNull(payment);
        assertEquals(PaymentType.CREDIT_CARD, payment.getType());
        assertEquals((Integer) 15700, payment.getAmount());
        assertEquals((Integer) 1, payment.getInstallments());
        assertEquals("123456789ABCD", payment.getSoftDescriptor());

        CreditCard creditCard = payment.getCreditCard();
        assertNotNull(creditCard);
        assertEquals("Teste Holder", creditCard.getHolder());
        assertEquals("123", creditCard.getSecurityCode());
        assertEquals(Brand.VISA, creditCard.getBrand());

        YearMonth ym = creditCard.getExpirationDate();
        assertNotNull(ym);
        assertEquals(2030, ym.getYear());
        assertEquals(12, ym.getMonthValue());
    }

    @Test
    public void ccSimpleTransactionResponseTest() {
        SaleResponse response = readFile("cc-transaction-simple-response.json", SaleResponse.class);
        assertNotNull(response);

        assertEquals("2014111706", response.getMerchantOrderId());

        Customer customer = response.getCustomer();
        assertNotNull(customer);
        assertEquals("Comprador crédito simples", customer.getName());

        Payment payment = response.getPayment();
        assertNotNull(payment);
        assertEquals(Interest.BY_MERCHANT, payment.getInterest());
        assertEquals((Integer) 0, payment.getServiceTaxAmount());
        assertEquals((Integer) 1, payment.getInstallments());
        assertFalse(payment.getCapture());
        assertFalse(payment.getAuthenticate());

        CreditCard creditCard = payment.getCreditCard();
        assertNotNull(creditCard);
        assertEquals("455187******0183", creditCard.getCardNumber());
        assertEquals("Teste Holder", creditCard.getHolder());
        assertNotNull(creditCard.getExpirationDate());
        assertEquals(2030, creditCard.getExpirationDate().getYear());
        assertEquals(12, creditCard.getExpirationDate().getMonthValue());
        assertFalse(creditCard.isSaveCard());
        assertEquals(Brand.VISA, creditCard.getBrand());

        assertEquals("674532", payment.getProofOfSale());
        assertEquals("0305023644309", payment.getTid());
        assertEquals("123456", payment.getAuthorizationCode());
        assertEquals("24bc8366-fc31-4d6c-8555-17049a836a07", payment.getPaymentId());
        assertEquals(PaymentType.CREDIT_CARD, payment.getType());
        assertEquals((Integer) 15700, payment.getAmount());
        assertEquals(Currency.BRL, payment.getCurrency());
        assertEquals("BRA", payment.getCountry());
        assertEquals(SaleStatus.AUTHORIZED, payment.getStatus());
        assertEquals("4", payment.getReturnCode());
        // assertEquals(SaleStatus.AUTHORIZED, payment.getReturnCode());


        assertEquals("Operation Successful", payment.getReturnMessage());

        List<Link> links = payment.getLinks();
        assertNotNull(links);
        assertEquals(3, links.size());
    }

    @Test
    public void ccFullTransactionRequestTest() {
        Sale sale = readFile("cc-transaction-full-request.json", Sale.class);

        assertNotNull(sale);
    }

}
