/**
 * 
 */
package it.peruvianit.java8.core.service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 * @version 1.0.0
 * @since 1.0.6
 */
public interface StreamParalleloService {
	
	default Set<Integer> numeri(){
		Set<Integer> numeri = new HashSet<>();
		
		for (int i =1 ; i<=10; i++) {
			numeri.add(i);
		}
		
		return numeri;
	}
	
	void leggereNumeriStream();
	
	void leggereNumeriStreamParallelo();
}
