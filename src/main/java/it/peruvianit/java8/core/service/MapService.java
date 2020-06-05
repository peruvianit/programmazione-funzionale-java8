/**
 * 
 */
package it.peruvianit.java8.core.service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 * @version 1.0.0
 * @since 1.0.7
 */
public interface MapService {

	default Map<Integer, String> mapa() {
		HashMap<Integer, String> mapa = new HashMap<Integer, String>();
		
		mapa.put(1, "Calcio");
		mapa.put(2, "Tennis");
		mapa.put(3, "Basket");
		mapa.put(4, "Palla Volo");
		mapa.put(5, "Pin Pong");
		
		return mapa;
	}
	
	void leggereJava7();
	
	void leggereJava8();
	
	void recolettare();
	
	void aggiungereSeAssente();
	
	void operareSePresente();
	
	void OttenerePredeterminato();
}
