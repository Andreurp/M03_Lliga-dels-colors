package net.andreu.lliga;

public class Partit {
	
	private String local, visitant;
	private int golsLocal, golsVisitant;
	
	public Partit(String local, String visitant,int golsLocal, int golsVisitant){
		this.local=local;
		this.visitant=visitant;
		this.golsLocal=golsLocal;
		this.golsVisitant=golsVisitant;
	}

	public String getLocal() {
		return local;
	}

	public String getVisitant() {
		return visitant;
	}
	public int resultat(){
		int retorna=0;
		if(golsLocal>golsVisitant){
			retorna=1;
		}else if(golsLocal<golsVisitant){
			retorna=2;
		}
		return retorna;
	}

}
