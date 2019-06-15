package io.bpic.cielo.client;

import io.bpic.cielo.client.exceptions.CieloClientException;
import io.bpic.cielo.client.exceptions.CieloErrorException;
import io.bpic.cielo.core.Merchant;
import io.bpic.cielo.core.ecommerce.Error;
import io.bpic.cielo.core.ecommerce.*;
import io.bpic.cielo.core.jsonb.util.JsonbUtil;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.json.bind.JsonbBuilder;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.ResourceBundle;

import static org.junit.Assert.*;

/**
 * Created: 24/10/2018 20:08.
 *
 * @author Bruno Palermo
 */
public class CieloClientTest {

    private static final String CARD_AUTHORIZED = "1234123412341231";
    private static final String CARD_NOT_AUTHORIZED = "1234123412341232";
    private static final String CARD_NOT_AUTHORIZED_EXPIRED = "1234123412341233";
    private static final String CARD_NOT_AUTHORIZED_BLOCKED = "1234123412341235";
    private static final String CARD_NOT_AUTHORIZED_TIMEOUT = "1234123412341236";
    private static final String CARD_NOT_AUTHORIZED_CARD_CANCELLED = "1234123412341237";
    private static final String CARD_NOT_AUTHORIZED_CARD_PROBLEM = "1234123412341238";

    private static String merchantId;
    private static String merchantKey;

    private CieloClient client;

    @BeforeClass
    public static void beforeClass() {
        ResourceBundle settings = ResourceBundle.getBundle("cielo");
        merchantId = settings.getString("merchantId");
        merchantKey = settings.getString("merchantKey");
    }

    @Before
    public void before() {
        Environment environment = Environment.SANDBOX;
        Merchant merchant = new Merchant(merchantId, merchantKey);
        this.client = new CieloClient(environment, merchant);
    }

    @org.junit.Test
    public void ccSaleSimpleTest() throws CieloClientException {
        Sale sale = ccCreateSimpleSale();
        SaleResponse response = client.createSale(sale);

        assertNotNull(response);

        Customer customer = response.getCustomer();
        assertNotNull(customer);

        Payment payment = response.getPayment();
        assertNotNull(payment);
        assertEquals(SaleStatus.AUTHORIZED, payment.getStatus());
        assertEquals("4", payment.getReturnCode());

        CreditCard creditCard = payment.getCreditCard();
        assertNotNull(creditCard);
    }

    @org.junit.Test
    public void ccSaleFullTest() throws CieloClientException {
        Sale sale = ccCreateFullSale();

        SaleResponse response = null;
        try {
            response = client.createSale(sale);
        } catch (CieloErrorException e) {
            System.out.println("Status " + e.getResponse().getStatus() + ": " + e.getError().get(0).getMessage());
            System.out.println(JsonbBuilder.newBuilder().withConfig(JsonbUtil.createJSONBConfig()).build().toJson(sale));
        }
        assertNotNull(response);

        Customer customer = response.getCustomer();
        assertNotNull(customer);

        Payment payment = response.getPayment();
        assertNotNull(payment);
        assertEquals(Interest.SANDBOX, payment.getInterest());
        // assertEquals(Interest.BY_MERCHANT, payment.getInterest());
        assertTrue(payment.getCapture());
        assertFalse(payment.getAuthenticate());
        assertEquals(SaleStatus.PAYMENT_CONFIRMED, payment.getStatus());
        assertEquals("6", payment.getReturnCode());

        CreditCard creditCard = payment.getCreditCard();
        assertNotNull(creditCard);
    }

    @org.junit.Test
    public void ccSaleAuthTest() throws CieloClientException {
        Sale sale = new Sale()
                .setMerchantOrderId("2014111903")
                .setCustomer(new Customer()
                        .setName("Comprador crédito autenticação")
                )
                .setPayment(new Payment()
                        .setType(PaymentType.CREDIT_CARD)
                        .setAmount(15700)
                        .setInstallments(1)
                        .setAuthenticate(true)
                        .setSoftDescriptor("123456789ABCD")
                        .setReturnUrl("https://www.cielo.com.br")
                        .setCreditCard(new CreditCard()
                                .setCardNumber("1234123412341231")
                                .setHolder("Test Holder")
                                .setExpirationDate(YearMonth.of(2030, 12))
                                .setSecurityCode("123")
                                .setBrand(Brand.VISA)
                        )
                );

        SaleResponse response = client.createSale(sale);
        assertNotNull(response);

        Payment payment = response.getPayment();
        assertNotNull(payment);
        assertNotNull(payment.getAuthenticationUrl());
        assertEquals(SaleStatus.NOT_FINISH, payment.getStatus());
        assertEquals("1", payment.getReturnCode());

    }

    @org.junit.Test
    public void ccSaleNotAuthorized() throws CieloClientException {
        Sale sale = ccCreateFullSale();
        sale.getPayment().getCreditCard().setCardNumber(CARD_NOT_AUTHORIZED);

        SaleResponse response = client.createSale(sale);
        assertNotNull(response);

        Payment payment = response.getPayment();
        assertNotNull(payment);
        assertEquals(SaleStatus.DENIED, payment.getStatus());
        assertEquals("05", payment.getReturnCode());
    }

    @org.junit.Test
    public void ccSaleNotAuthorizedExpired() throws CieloClientException {
        Sale sale = ccCreateFullSale();
        sale.getPayment().getCreditCard().setCardNumber(CARD_NOT_AUTHORIZED_EXPIRED);

        SaleResponse response = client.createSale(sale);
        assertNotNull(response);

        Payment payment = response.getPayment();
        assertNotNull(payment);
        assertEquals(SaleStatus.DENIED, payment.getStatus());
        assertEquals("57", payment.getReturnCode());
    }

    @org.junit.Test
    public void ccSaleNotAuthorizedBlocked() throws CieloClientException {
        Sale sale = ccCreateFullSale();
        sale.getPayment().getCreditCard().setCardNumber(CARD_NOT_AUTHORIZED_BLOCKED);

        SaleResponse response = client.createSale(sale);
        assertNotNull(response);

        Payment payment = response.getPayment();
        assertNotNull(payment);
        assertEquals(SaleStatus.DENIED, payment.getStatus());
        assertEquals("78", payment.getReturnCode());
    }

    @org.junit.Test
    public void ccSaleNotAuthorizedTimeOut() throws CieloClientException {
        Sale sale = ccCreateFullSale();
        sale.getPayment().getCreditCard().setCardNumber(CARD_NOT_AUTHORIZED_TIMEOUT);

        SaleResponse response = client.createSale(sale);
        assertNotNull(response);

        Payment payment = response.getPayment();
        assertNotNull(payment);
        assertEquals(SaleStatus.NOT_FINISH, payment.getStatus());
        assertEquals("99", payment.getReturnCode());
    }

    @org.junit.Test
    public void ccSaleNotAuthorizedCanceled() throws CieloClientException {
        Sale sale = ccCreateFullSale();
        sale.getPayment().getCreditCard().setCardNumber(CARD_NOT_AUTHORIZED_CARD_CANCELLED);

        SaleResponse response = client.createSale(sale);
        assertNotNull(response);

        Payment payment = response.getPayment();
        assertNotNull(payment);
        assertEquals(SaleStatus.DENIED, payment.getStatus());
        assertEquals("77", payment.getReturnCode());
    }

    @org.junit.Test
    public void ccSaleNotAuthorizedProblem() throws CieloClientException {
        Sale sale = ccCreateFullSale();
        sale.getPayment().getCreditCard().setCardNumber(CARD_NOT_AUTHORIZED_CARD_PROBLEM);

        SaleResponse response = client.createSale(sale);
        assertNotNull(response);

        Payment payment = response.getPayment();
        assertNotNull(payment);
        assertEquals(SaleStatus.DENIED, payment.getStatus());
        assertEquals("70", payment.getReturnCode());
    }

    @org.junit.Test
    public void ccSaleCreateToken() throws CieloClientException {
        Sale sale = ccCreateFullSale();
        sale.getPayment().getCreditCard().setSaveCard(true);

        SaleResponse response = client.createSale(sale);
        assertNotNull(response);

        Payment payment = response.getPayment();
        assertNotNull(payment);

        CreditCard creditCard = payment.getCreditCard();
        assertNotNull(creditCard);
        assertTrue(creditCard.isSaveCard());
        assertNotNull(creditCard.getCardToken());

    }

    @org.junit.Test
    public void ccSaleWithToken() throws CieloClientException {
        CreditCard card = new CreditCard()
                .setCustomerName("Comprador Teste Cielo")
                .setCardNumber("4532117080573700")
                .setHolder("Comprador T Cielo")
                .setExpirationDate(YearMonth.of(2020, 12))
                .setBrand(Brand.VISA);

        CardToken cardToken = client.cardToken(card);
        assertNotNull(cardToken);

        String token = cardToken.getCardToken();
        assertNotNull(token);

        Sale sale = new Sale()
                .setMerchantOrderId("2014111706")
                .setCustomer(new Customer()
                        .setName("Test Buyer")
                )
                .setPayment(new Payment()
                        .setType(PaymentType.CREDIT_CARD)
                        .setAmount(100)
                        .setInstallments(1)
                        .setSoftDescriptor("123456789ABCD")
                        .setCreditCard(new CreditCard()
                                .setCardToken(token)
                                .setSecurityCode("123")
                                .setBrand(Brand.VISA)
                        )
                );

        SaleResponse response = client.createSale(sale);
        assertNotNull(response);

        Payment payment = response.getPayment();
        assertNotNull(payment);

        CreditCard creditCard = payment.getCreditCard();
        assertNotNull(creditCard);
        assertEquals(token, creditCard.getCardToken());
        assertEquals(SaleStatus.AUTHORIZED, payment.getStatus());
    }

    @org.junit.Test
    public void dcSaleSimpleTest() throws CieloClientException {
        Sale sale = new Sale()
                .setMerchantOrderId("2014121201")
                .setCustomer(new Customer()
                        .setName("Comprador Cartão de débito")
                )
                .setPayment(new Payment()
                        .setType(PaymentType.DEBIT_CARD)
                        .setAuthenticate(true)
                        .setAmount(15700)
                        .setReturnUrl("htts://www.cielo.com.br")
                        .setDebitCard(new DebitCard()
                                .setCardNumber("4551870000000183")
                                .setHolder("Test Holder")
                                .setExpirationDate(YearMonth.of(2030, 12))
                                .setSecurityCode("123")
                                .setBrand(Brand.VISA)
                        )
                );

        SaleResponse response = client.createSale(sale);
        assertNotNull(response);

        Payment payment = response.getPayment();
        assertNotNull(payment);
        assertNotNull(payment.getAuthenticationUrl());
        assertEquals(SaleStatus.NOT_FINISH, payment.getStatus());
    }

    @org.junit.Test
    public void etSaleSimpleTest() throws CieloClientException {
        Sale sale = new Sale()
                .setMerchantOrderId("2014111706")
                .setCustomer(new Customer()
                        .setName("Comprador Transferência Eletronica")
                )
                .setPayment(new Payment()
                        .setType(PaymentType.ELECTRONIC_TRANSFER)
                        .setAmount(15700)
                        .setProvider(Provider.BRADESCO)
                        .setReturnUrl("htts://www.cielo.com.br")
                );

        SaleResponse response = client.createSale(sale);
        assertNotNull(response);

        Payment payment = response.getPayment();
        assertNotNull(payment);
        assertNotNull(payment.getUrl());
        assertEquals(SaleStatus.NOT_FINISH, payment.getStatus());
    }

    @org.junit.Test
    public void boletoSaleSimpleTest() throws CieloClientException {
        Sale sale = new Sale()
                .setMerchantOrderId("2014111706")
                .setCustomer(new Customer()
                        .setName("Billet Buyer")
                        .setIdentity(IdentityType.CPF,"1234567890")
                        .setAddress(new Address()
                                .setStreet("Avenida Marechal Câmara")
                                .setNumber("160")
                                .setComplement("Room 934")
                                .setDistrict("Centro")
                                .setZipCode("22750012")
                                .setCity("Rio de Janeiro")
                                .setState("RJ")
                                .setCountry("BRA")
                        )
                )
                .setPayment(new Payment()
                        .setType(PaymentType.BOLETO)
                        .setAmount(15700)
                        .setProvider(Provider.BRADESCO)
                        .setAddress("Test Street")
                        .setBoletoNumber("123")
                        .setAssignor("Empresa Teste")
                        .setDemonstrative("Desmonstrative Teste")
                        .setExpirationDate(LocalDate.of(2030, 12, 31))
                        .setIdentification("11884926754")
                        .setInstructions("Aceitar somente até a data de vencimento, após essa data juros de 1% dia.")
                );

        // System.out.println(sale.toJson());
        SaleResponse response = client.createSale(sale);
        assertNotNull(response);

        Payment payment = response.getPayment();
        assertNotNull(payment);
        assertNotNull(payment.getUrl());
        // assertNotNull(payment.getNumber());
        assertNotNull(payment.getBarCodeNumber());
        assertNotNull(payment.getDigitableLine());
        assertEquals(SaleStatus.AUTHORIZED, payment.getStatus());
    }

    @org.junit.Test
    public void cancelSaleTest() throws CieloClientException {
        Sale sale = ccCreateSimpleSale();

        SaleResponse response = client.createSale(sale);
        assertNotNull(response);
        Payment payment = response.getPayment();
        assertNotNull(payment);
        String paymentId = payment.getPaymentId();
        assertNotNull(paymentId);

        payment = client.cancelSale(paymentId);
        assertNotNull(payment);
        assertEquals(SaleStatus.VOIDED, payment.getStatus());
        assertEquals((Integer) 0, payment.getProviderReturnCode());
        assertEquals("Operation Successful", payment.getProviderReturnMessage());
        assertEquals((Integer) 0, payment.getReasonCode());
        assertEquals("Successful", payment.getReasonMessage());
        assertEquals(SaleStatus.VOIDED, payment.getStatus());
    }

    @org.junit.Test
    public void cancelPartialSaleTest() throws CieloClientException {
        Sale sale = ccCreateSimpleSale();

        SaleResponse response = client.createSale(sale);
        assertNotNull(response);
        Payment payment = response.getPayment();
        assertNotNull(payment);
        String paymentId = payment.getPaymentId();
        assertNotNull(paymentId);

        payment = client.cancelSale(paymentId, 700);
        assertNotNull(payment);
        assertEquals(SaleStatus.VOIDED, payment.getStatus());
        // assertEquals(SaleStatus.PAYMENT_CONFIRMED, payment.getStatus());
        assertEquals((Integer) 0, payment.getProviderReturnCode());
        assertEquals("Operation Successful", payment.getProviderReturnMessage());
        assertEquals((Integer) 0, payment.getReasonCode());
        assertEquals("Successful", payment.getReasonMessage());
        assertEquals(SaleStatus.VOIDED, payment.getStatus());
    }

    @org.junit.Test
    public void querySaleTest() throws CieloClientException {
        Sale sale = ccCreateSimpleSale();

        SaleResponse response = client.createSale(sale);
        assertNotNull(response);
        Payment payment = response.getPayment();
        assertNotNull(payment);
        String paymentId = payment.getPaymentId();
        assertNotNull(paymentId);

        response = client.querySale(paymentId);
        assertNotNull(response);
        assertNotNull(response.getPayment());
        assertEquals(paymentId, response.getPayment().getPaymentId());
    }

    @org.junit.Test
    public void queryBinTest() throws CieloClientException {
        BinResponse response = client.queryBin(549167);
        assertNotNull(response);
    }

    @org.junit.Test
    public void queryBinErrorTest() throws CieloClientException {
        try {
            client.queryBin(420020);
        } catch (CieloErrorException e) {
            List<Error> errors = e.getError();
            assertNotNull(errors);
            assertEquals(1, errors.size());
            assertEquals((Integer) 1, errors.get(0).getCode());
            assertEquals("Bandeira não suportada", errors.get(0).getMessage());

        }
    }

    private Sale ccCreateSimpleSale() {
        return new Sale()
                .setMerchantOrderId("2014111703")
                .setCustomer(new Customer()
                        .setName("Comprador crédito simples")
                )
                .setPayment(new Payment()
                        .setType(PaymentType.CREDIT_CARD)
                        .setAmount(15700)
                        .setInstallments(1)
                        .setSoftDescriptor("123456789ABCD")
                        .setCreditCard(new CreditCard()
                                .setCardNumber(CARD_AUTHORIZED)
                                .setHolder("Teste Holder")
                                .setExpirationDate(YearMonth.of(2030, 12))
                                .setSecurityCode("123")
                                .setBrand(Brand.VISA)
                        )
                );
    }

    private Sale ccCreateFullSale() {
        Address address = new Address()
                .setStreet("Rua Teste")
                .setNumber("123")
                .setComplement("AP 123")
                .setZipCode("12345987")
                .setCity("Rio de Janeiro")
                .setState("RJ")
                .setCountry("BRA");

        return new Sale()
                .setMerchantOrderId("2014111701")
                .setCustomer(new Customer()
                        .setName("Comprador crédito completo")
                        .setEmail("compradorteste@teste.com")
                        .setBirthDate(LocalDate.of(1991, 1, 2))
                        .setAddress(address)
                        .setDeliveryAddress(address)
                )
                .setPayment(new Payment()
                        .setType(PaymentType.CREDIT_CARD)
                        .setAmount(15700)
                        .setCurrency(Currency.BRL)
                        .setCountry("BRA")
                        .setServiceTaxAmount(0)
                        .setInstallments(1)
                        .setInterest(Interest.BY_MERCHANT)
                        .setCapture(true)
                        .setAuthenticate(false)
                        .setSoftDescriptor("123456789ABCD")
                        .setCreditCard(new CreditCard()
                                .setCardNumber(CARD_AUTHORIZED)
                                .setHolder("Teste Holder")
                                .setExpirationDate(YearMonth.of(2030, 12))
                                .setSecurityCode("123")
                                .setSaveCard(false)
                                .setBrand(Brand.VISA)
                        )
                );
    }

}
