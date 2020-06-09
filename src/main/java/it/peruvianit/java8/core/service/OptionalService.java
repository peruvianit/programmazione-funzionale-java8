/**
 * 
 */
package it.peruvianit.java8.core.service;

/**
 * Implementazione per evitare l'eccezion
 * {@code NullPointerException}
 * @author Sergio Arellano {PeruViANit}
 *
 * @see NullPointerException
 * 
 * @version 1.0.0
 * @since 1.0.5
 */
public interface OptionalService {
	
	void prova(String valore);
	
	void orElse(String valore);
	
	void orElseThrow(String valore);
	
	void isPresent(String valore);
	
	void ifPresent(String valore);

}
