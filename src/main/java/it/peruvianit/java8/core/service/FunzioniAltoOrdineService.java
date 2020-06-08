/**
 * 
 */
package it.peruvianit.java8.core.service;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 * @version 1.0.0
 * @since 1.0.8
 */
public interface FunzioniAltoOrdineService {

	void convertirStringa(String valore);
	
	Function<String, String> prefisso(String prefisso);
	
	void filtrare(List<String> list, Consumer<String> consumer, int lunghezza);
	
	UnaryOperator<String> suffiso(String suffiso);
	
	BiFunction<Integer, Integer, Integer> multiplicazione();
	
	BinaryOperator<Integer> divizione();
	
	BiFunction<String, Integer, String> leftPad();
}
