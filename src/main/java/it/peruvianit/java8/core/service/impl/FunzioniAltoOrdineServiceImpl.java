/**
 * 
 */
package it.peruvianit.java8.core.service.impl;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import org.springframework.stereotype.Service;

import it.peruvianit.java8.core.service.FunzioniAltoOrdineService;

/**
 * <pre>
 * Come sa Java che tipo di dato è in input o output ?? 
 * A eso se le conoce <strong>inferenza di tipo</strong>, java se incarica di validare
 * che tipo di dato che se le sta passando alla funzione correspondano.
 * 
 * Le funzioni lavorano sui oggetti non su tipo di dato primitivo
 * </pre>
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
	public Function<String, String> prefisso(String prefisso) {
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

	/**
	 * 
	 * <pre>
	 * è inclussa nelle funzioni chiamate <strong>Function Operator</strong> 
	 * UnaryOperator : Utilizza il stesso tipo di dato come Input/Output 
	 * </pre>
	 */
	@Override
	public UnaryOperator<String> suffiso(String suffiso) {
		return (String str) -> str + "_" +  suffiso;
	}

	/**
	 * Quando se bisogna passare più di un  argomento, se può utilizzare 
	 * {@code BiFunction}
	 * 
	 * @since 1.0.10
	 */
	@Override
	public BiFunction<Integer, Integer, Integer> multiplicazione() {
		return (Integer ope1,Integer ope2) -> ope1 * ope2;
	}

	/**
	 * Stesso concetto di UnaryOperator però adesso con
	 * BiFunction : Utilizza il stesso tipo di dato come Input1/Input12/Output 
	 * 
	 * @since 1.0.10
	 */
	@Override
	public BinaryOperator<Integer> divizione() {
		return (Integer ope1,Integer ope2) -> ope1 / ope2;
	}

	/**
	 * Scondo espemio di BiFuncion
	 * 
	 *  @since 1.0.10
	 */
	@Override
	public BiFunction<String, Integer, String> leftPad() {
		return (String str, Integer numeriSpazi) -> String.format("%" + numeriSpazi + "s ", str);
	}
}
