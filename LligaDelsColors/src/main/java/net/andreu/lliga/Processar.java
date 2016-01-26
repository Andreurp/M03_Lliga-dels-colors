package net.andreu.lliga;

import java.util.HashMap;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Processar extends DefaultHandler {

	int numelements = 0;
	boolean llistatEquips = false;
	boolean nom = false;
	boolean partit = false;
	boolean equip = false;
	boolean local = false;
	boolean visitant = false;
	boolean resultat = false;

	String eLocal, eVisitant;
	int golsLocal, golsVisitant;

	private HashMap<String, Integer> clubs = new HashMap<String, Integer>();

	public void startElement(String uri, String localName, String qName, Attributes attributes) {

		switch (qName) {
		case "llista-equips":
			llistatEquips = true;
			break;
		case "nom":
			nom = true;
			break;
		case "partit":
			partit = true;
			break;
		case "equip":
			equip = true;
			if (attributes.getValue("juga").equals("local")) {
				local = true;
			} else {
				visitant = true;
			}
			break;
		case "resultat":
			resultat = true;
			break;
		}

		numelements++;
	}

	public void characters(char[] ch, int start, int length) {
		if (llistatEquips && nom) {
			clubs.put(new String(ch, start, length), 0);
		}
		if (partit) {
			if (equip) {
				if (local) {
					if (nom) {
						eLocal = new String(ch, start, length);
					} else if (resultat) {
						golsLocal = Integer.parseInt(new String(ch, start, length));
					}
				} else if (visitant) {
					if (nom) {
						eVisitant = new String(ch, start, length);
					} else if (resultat) {
						golsVisitant = Integer.parseInt(new String(ch, start, length));
					}
				}
			}
		}
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {

		switch (qName) {
		case "llista-equips":
			llistatEquips = false;
			break;
		case "nom":
			nom = false;
			break;
		case "partit":
			partit = false;
			calculaPunts();
			break;
		case "equip":
			equip = false;
			local = false;
			visitant = false;
			break;
		case "resultat":
			resultat = false;
			break;
		}

	}

	private void calculaPunts() {
		Partit p = new Partit(eLocal, eVisitant, golsLocal, golsVisitant);
		switch (p.resultat()) {
		case 0:
			clubs.put(p.getLocal(), clubs.get(p.getLocal()) + 1);
			clubs.put(p.getVisitant(), clubs.get(p.getVisitant()) + 1);
			break;
		case 1:
			clubs.put(p.getLocal(), clubs.get(p.getLocal()) + 3);
			break;
		case 2:
			clubs.put(p.getVisitant(), clubs.get(p.getVisitant()) + 3);
			break;
		}

	}

	public void endDocument() {
		String guanyador="";
		int punts=0;
		for (String clau : clubs.keySet()) {
			System.out.println(clau + ": " + clubs.get(clau));
			if(clubs.get(clau)>punts){
				guanyador=clau;
				punts=clubs.get(clau);
			}
		}
		System.out.println("El guanyador es l'equip: "+guanyador);
		System.out.println("");
	}

}
