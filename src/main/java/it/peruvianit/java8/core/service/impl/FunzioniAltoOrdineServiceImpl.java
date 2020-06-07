/**
 * 
 */
package it.peruvianit.java8.core.service.impl;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import it.peruvianit.java8.core.service.FunzioniAltoOrdineService;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 * @version 1.0.0
 * @since 1.0.8
 */
@Service
public class FunzioniAltoOrdineServiceImpl implements FunzioniAltoOrdineService {

	/**
	 * Function<[Input], [Output]>
	 * 
	 * str : input
	 * str.toUpperCase() : output 
	 */
	private Function<String, String> convertirMaiuscula = str -> str.toUpperCase();
	
	private Function<String, String> convertireMinuscule = str -> str.toLowerCase();
	
	/**
	 * con la dichiarazione {@code Function<String, String>}
	 * <pre>
	 * Il primo parametro è in ingreso (Input)
	 * Il secondo in uscita (Outpu)
	 * </pre>
	 * 
	 * @param function
	 * @param valore
	 */
	private void convertirStringaCallFunction(Function<String, String> function, String valore) {
		System.out.println(function.apply(valore));
	}

	/**
	 * Esempio simple per chiamare metodi con funzioni
	 */
	@Override
	public void convertirStringa(String valore) {
		convertirStringaCallFunction(convertirMaiuscula, valore);
		convertirStringaCallFunction(convertireMinuscule, valore);
	}

	/**
	 * (String str) è il parametro in Input
	 */
	@Override
	public Function<String, String> visualizza(String prefisso) {
		return (String str) -> prefisso + "_" + str;
	}

	/**
	 * Utilizzare funzioni alto ordine con il esempio di 
	 * un filtro custom sul stream, utilizzando l'implementazione di {@code Predica<T>}
	 * 
	 * @see #evaluaLunghezza(int)
	 */
	@Override
	public void filtrare(List<String> list, Consumer<String> consumer, int lunghezza) {
		list.stream().filter(evaluaLunghezza(lunghezza)).forEach(consumer);
	}
	
	private Predicate<String> evaluaLunghezza(int lunghezza){
		return (String str) -> str.length() >= lunghezza;
	}
}
