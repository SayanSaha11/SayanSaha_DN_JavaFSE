package org.example;

public class ExcelDocumentFactory extends DocumentFactory{
    public Document createDocument(){
        return new ExcelDocument();
    }
}
