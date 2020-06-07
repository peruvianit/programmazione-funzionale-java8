/**
 * 
 */
package it.peruvianit.java8.core.service;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 * @version 1.0.0
 * @since 1.0.8
 */
public interface FunzioniAltoOrdineService {

	void convertirStringa(String valore);
	
	Function<String, String> visualizza(String prefisso);
	
	void filtrare(List<String> list, Consumer<String> consumer, int lunghezza);
}
