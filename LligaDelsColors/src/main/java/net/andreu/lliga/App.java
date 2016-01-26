package net.andreu.lliga;

import java.io.IOException;
import java.io.InputStream;

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
	
	private static String[] FITXER = {"/torneig1.xml", "/torneig2.xml", "/torneig3.xml"};
	
    public static void main( String[] args ) throws ParserConfigurationException, SAXException, IOException
    {
        SAXParserFactory fabrica=SAXParserFactory.newInstance();
        fabrica.setNamespaceAware(true);
        SAXParser parser=fabrica.newSAXParser();
        for(int i=0; i<FITXER.length; i++){
        	InputStream File = App.class.getResourceAsStream(FITXER[i]);
        	parser.parse(File,new Processar());
        }
        
    }
}