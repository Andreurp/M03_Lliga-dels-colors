package net.andreu.lliga;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private static String FITXER = "/torneig1.xml";
    public static void main( String[] args ) throws ParserConfigurationException, SAXException, IOException
    {
        SAXParserFactory fabrica=SAXParserFactory.newInstance();
        fabrica.setNamespaceAware(true);
        SAXParser parser=fabrica.newSAXParser();
        parser.parse(new File(App.class.getResource(FITXER).getFile()), new Processar());
    }
}