package it.polito.tdp.alien.traduttore;

import java.util.LinkedList;

public class Parole {
	String parola; 
	LinkedList <String>traduz= new LinkedList<String>();
	public Parole(String parola) {
		super();
		this.parola = parola;
		
	}
	@Override
	public String toString() {
		String elenco="";
		for(String a:traduz)
			elenco=elenco+a;
		return elenco ;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parole other = (Parole) obj;
		if (parola == null) {
			if (other.parola != null)
				return false;
		} else if (!parola.equals(other.parola))
			return false;
		return true;
	}

	
}
