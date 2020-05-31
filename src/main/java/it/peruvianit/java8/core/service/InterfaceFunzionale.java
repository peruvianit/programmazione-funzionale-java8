/**
 * 
 */
package it.peruvianit.java8.core.service;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 * @version 1.0.0
 * @since 1.0.2
 */
public interface InterfaceFunzionale {
	
	String mostraMessaggio(); 
	
	default public String message() {
		return "Un metodo di una interface funzionale";
	}
}
