package it.polito.tdp.alien.traduttore;

import java.util.LinkedList;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class Traduttore {

 LinkedList<Parole> lista = new LinkedList <Parole>();
 Parole e=null;;
 public boolean  aggiuntaParole(String parola,String traduzione ) {
	
	 boolean continua = false;
	   if(Pattern.matches("[a-zA-Z]+", parola)==true && Pattern.matches("[a-zA-Z]+", (CharSequence) traduzione)==true) //verifico che la parola e la traduzione sia formata solo da lettere 
		   continua=true;
	  
	//SE HO GIA LA PAROLA NELL'EELNCO NON DEVO CREARE UN NUOVO RIFERIMENTO 
	if(continua==true) {
		
	
		
		 e=new Parole(parola);
		for(Parole a: lista )
			if(a.equals(e)==true)
	 e=a;
	
	lista.add(e);
	 e.traduz.add(traduzione.toLowerCase());
	 return true;}
	else
		return false;
 
}
 
 public LinkedList<String> cercaParola(Object  parola)
 { 
	 
	 if(Pattern.matches("[a-zA-Z]+", (String)parola)==true) 
	 for(Parole a:lista)
		 if(a.equals(parola)) 
			 e=a;
    if(e!=null)
    	return e.traduz;
    else 
    return null;
	 
 }
 public void cancellaTutto( ) {
	
	 for(Parole a : lista)
		 a.traduz.clear();
	 lista.clear();
 }
}
