/**
 * 
 */
package it.peruvianit.java8.view;

/**
 * Per utilizzo di riferimento metodi da un costruttore
 * 
 * @author Sergio Arellano {PeruViANit}
 *
 * @version 1.0.0
 * @since 1.0.2
 */
public class PersonaView {
	
	private String nome;
	private String cognome;
	
	public PersonaView(String nome, String cognome) {
		super();
		this.nome = nome;
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}
}
