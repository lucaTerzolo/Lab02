package it.polito.tdp.alien.model;

import java.util.Map;
import java.util.TreeMap;

public class Model {
	
	private Map<String,String> dizionario;
	//Italiano alieno
	
	public Model() {
		this.dizionario = new TreeMap<>();
	}
	
	public String traduci(String string) {
		String s=new String();
		String it=string;
		if(!valido(string)) {
			s="Erore di inserimento";
			return s;
		}
		if(!dizionario.containsKey(it))
			s="Non trovato";
		else
			s=dizionario.get(it);
		return s;
	}

	public String aggiungi(String string, String string2) {
		String s=new String();
		if(!valido(string)||!valido(string2)) {
			s="Erore di inserimento";
			return s;
		}
		if(dizionario.containsKey(string)) {
			String ss=new String();
			ss=dizionario.get(string)+" ";
			ss+=string2;
			dizionario.put(string, ss);
		}
		else {
			dizionario.put(string, string2);
		}
		return s;
	}
	
	public boolean valido(String string) {
		string.toCharArray();
		boolean prova=false;
		for(int i=0;i<string.length();i++) {
			if(Character.isAlphabetic(string.charAt(i)))
				prova=true;
			else
				prova=false;
		
		}
		return prova;
	}
}	
