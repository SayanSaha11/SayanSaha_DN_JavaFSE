package org.example;

import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the document you want to create (excel/pdf/word) : ");
        String documentType = scanner.next().toLowerCase();

        DocumentFactory factory;

        if (documentType.equalsIgnoreCase("Word")) {
            factory = new WordDocumentFactory();
        } else if (documentType.equalsIgnoreCase("PDF")) {
            factory = new PdfDocumentFactory();
        } else if (documentType.equalsIgnoreCase("Excel")) {
            factory = new ExcelDocumentFactory();
        } else {
            throw new IllegalArgumentException("Unsupported document type: " + documentType);
        }

        Document document = factory.createDocument();

        document.open();

    }
}