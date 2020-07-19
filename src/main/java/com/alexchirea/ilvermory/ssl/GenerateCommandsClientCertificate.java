package com.alexchirea.ilvermory.ssl;

import java.util.Scanner;

public class GenerateCommandsClientCertificate {

    public static void main(String[] args) {

        String fileName;
        String commonName;
        String emailAddress;

        Scanner reader = new Scanner(System.in);

        System.out.print("Filename: ");
        fileName = reader.nextLine().toUpperCase();
        System.out.print("Common Name (CN): ");
        commonName = reader.nextLine().toUpperCase();

        emailAddress = commonName.toUpperCase() + "@ILVERMORY.MAGIC";

        String command1 = String.format("openssl req -new -newkey rsa:4096 -nodes -keyout %s.key -out %s.csr -subj " +
                        "'/CN=%s/O=Ilvermory/C=RO/ST=Romania/L=Bucharest/OU=Ilvemory IT/emailAddress=%s'",
                fileName, fileName, commonName, emailAddress);
        String command2 = String.format("openssl x509 -req -CA rootCA.crt -CAkey rootCA.key -in %s.csr -out %s.crt " +
                "-days 365 -CAcreateserial", fileName, fileName);
        String command3 = String.format("openssl pkcs12 -export -out %s.p12 -name \"%s\" -inkey %s.key -in %s.crt",
                fileName, fileName, fileName, fileName);

        System.out.println(command1);
        System.out.println(command2);
        System.out.println(command3);

    }

}
