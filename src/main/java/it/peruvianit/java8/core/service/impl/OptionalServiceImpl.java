/**
 * 
 */
package it.peruvianit.java8.core.service.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.peruvianit.java8.core.service.OptionalService;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 * @version 1.0.0
 * @since 1.5.0
 */
@Service
public class OptionalServiceImpl implements OptionalService {

	/**
	 * Scatta ina eccezione : 
	 * {@code NoSuchElementException} perchè il contenuto del optional non stato inizializzato
	 */
	@Override
	public void prova(String valore) {
		try {
			Optional<String> optional = Optional.empty();		
			optional.get();
		}catch(Exception ex) {
			System.out.println("Non ci sono elementi");
		}

	}

	/**
	 * se il valore è {@code null} le posso dare una valore per difetto
	 */
	@Override
	public void orElse(String valore) {
		Optional<String> optional = Optional.ofNullable(valore);
		
		System.out.println(optional.orElse("predeterminato"));

	}

	/* 
	 * se il valore è {@code null} le posso fare lanciare una eccezione.
	 * Come esempio genero una eccezione qualunque.
	 */
	@Override
	public void orElseThrow(String valore) {
		Optional<String> optional = Optional.ofNullable(valore);
		optional.orElseThrow(NumberFormatException::new);

	}

	/* 
	 * verifica se stato inizializzato il oggetto Optional
	 */
	@Override
	public void isPresent(String valore) {
		Optional<String> optional = Optional.ofNullable(valore);
		System.out.println(optional.isPresent());

	}

}
