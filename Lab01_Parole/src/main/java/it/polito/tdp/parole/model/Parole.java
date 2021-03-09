package it.polito.tdp.parole.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Parole {
		
	List<String> listaParole;
	
	public Parole() {
		//TODO
		listaParole = new LinkedList<>();
	}
	
	public void addParola(String p) {
		//TODO
		listaParole.add(p);
	}
	
	public List<String> getElenco() {
		//TODO
		Collections.sort(listaParole, new ComparatoreAlf());
		return listaParole;
	}
	
	public void reset() {
		// TODO
		listaParole.removeAll(getElenco());
	}

	@Override
	public String toString() {
		String s="";
		for (String p: this.listaParole) {
			s = s+p.toString()+"\n";
		}
		return s;
	}

	
}


