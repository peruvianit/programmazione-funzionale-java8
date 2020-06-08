/**
 * 
 */
package it.peruvianit.java8.common.util;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

/**
 * Utilizzo di interfacia funzionale
 * 
 * @author Sergio Arellano {PeruViANit}
 *
 * @version 1.0.0
 * @since 1.0.11
 */
public class AgeUtils {
	
	@FunctionalInterface 
	public interface TriFunction<T, U, V, R>{
		R apply(T t, U u, V v);
	}
	
	Function<Integer, String> addZero = x -> x < 10 ? "0" +  x : String.valueOf(x);
	
	TriFunction<Integer, Integer, Integer, LocalDate> parseDate =
			(day, month, year) -> LocalDate.parse(year + "-" +
					addZero.apply(month) + "-" + addZero.apply(day));
			
	
	public TriFunction<Integer, Integer, Integer, Integer> calculateAge = 
			(day, month, year) -> Period.between(parseDate.apply(day, month, year), LocalDate.now()).getYears();
	
			
}
