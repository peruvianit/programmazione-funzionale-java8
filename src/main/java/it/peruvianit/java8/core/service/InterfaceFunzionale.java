/**
 * 
 */
package it.peruvianit.java8.core.service;

/**
 * SAM : Single Abstract Method, è una interface che ha un unico metodo
 * @FunctionalInterface con questa annotazione java sa che questa interfacia
 * non può avere più di un metodo
 *  
 * @author Sergio Arellano {PeruViANit}
 *
 * @version 1.0.0
 * @since 1.0.2
 */
@FunctionalInterface
public interface InterfaceFunzionale {
	
	String mostraMessaggio(); 
	
	default public String message() {
		return "Un metodo di una interface funzionale";
	}
}
