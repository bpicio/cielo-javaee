#!/usr/bin/env bash

### 1) If we do not have the server certificate, we use openssl to retrieve it
echo -n | openssl s_client -connect api.cieloecommerce.cielo.com.br:443 -servername api.cieloecommerce.cielo.com.br | sed -ne '/-BEGIN CERTIFICATE-/,/-END CERTIFICATE-/p' | tee ../certificates/ecommerce_cielo.pem

### 2) Create the Truststore from them server certificate
keytool -import -alias ecommercecielo -file ../certificates/ecommerce_cielo.pem -keystore truststore.jks -deststorepass changeit