/**
 * 
 */
package it.peruvianit.java8.core.service;

import it.peruvianit.java8.view.PersonaView;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 * @version 1.0.0
 * @since 1.0.1
 */
@FunctionalInterface
public interface IPersona {
	PersonaView crear(String nome, String cognome);
}
