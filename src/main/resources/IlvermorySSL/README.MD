# SSL Guide

## Root Certificate Authority

```
openssl req -x509 -sha256 -days 3650 -newkey rsa:4096 -keyout rootCA.key -out rootCA.crt
```

```
PEM Password: w^j!-k4C<6+H-@g`x>/1-_\IbXakwB1?
```

## Server Side Certificate
```
openssl req -new -newkey rsa:4096 -keyout localhost.key -out localhost.csr
```

```
PEM Password: 6!YUwf?$HX4/YZ/AOF!%}("1_f5w<Nf+
```
```
openssl x509 -req -CA rootCA.crt -CAkey rootCA.key -in localhost.csr -out localhost.crt -days 365 -CAcreateserial -extfile localhost.ext
```
```
openssl x509 -in localhost.crt -text
```
```
openssl pkcs12 -export -out localhost.p12 -name "localhost" -inkey localhost.key -in localhost.crt
```
```
keytool -importkeystore -srckeystore localhost.p12 -srcstoretype PKCS12 -destkeystore keystore.jks -deststoretype JKS
```
```
Keystore & Export password: .r0K!1,;C&gF&yPz6kJ6W_4a7a{>`-<
```

## Client Side Certificate
```
keytool -import -trustcacerts -noprompt -alias ca -ext san=dns:localhost,ip:127.0.0.1 -file rootCA.crt -keystore truststore.jks
```
```
Keystore password: .r0K!1,;C&gF&yPz6kJ6W_4a7a{>`-<
```
### Generate
```
openssl req -new -newkey rsa:4096 -nodes -keyout kerdeva.key -out kerdeva.csr
```
```
openssl x509 -req -CA rootCA.crt -CAkey rootCA.key -in kerdeva.csr -out kerdeva.crt -days 365 -CAcreateserial
```
```
openssl pkcs12 -export -out kerdeva.p12 -name "kerdeva" -inkey kerdeva.key -in kerdeva.crt
```
### Export Passwords
```
kerdeva             eUhEY^KNS+EXB7?R
```