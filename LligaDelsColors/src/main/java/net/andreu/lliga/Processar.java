package net.andreu.lliga;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Processar extends DefaultHandler {    
        int numelements=0;            

        public void endDocument() throws SAXException{
            
             System.out.println("Total etiquetes: " + numelements); 
        }
           
        public void startElement(String uri, String localName,                      
        		String qName, Attributes attributes){

             numelements++;                              
        }            
}

