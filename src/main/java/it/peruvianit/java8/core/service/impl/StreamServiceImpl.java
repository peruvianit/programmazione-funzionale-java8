/**
 * 
 */
package it.peruvianit.java8.core.service.impl;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import it.peruvianit.java8.core.service.StreamService;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 */
@Service
public class StreamServiceImpl implements StreamService {

	/**
	 * filtrare tutti elementi che finiscono con "a" 
	 * e stampare a video con il metodo con riferimento
	 */
	@Override
	public void filtrare() {
		lista().stream().filter(ele -> ele.endsWith("a")).forEach(System.out::println);
	}

	/**
	 * ordinament ascendente e descendente(fare il compareTo invertendo la condizione)
	 */
	@Override
	public void ordinare() {
		System.out.println("\nascendente:");
		lista().stream().sorted().forEach(System.out::println);
		System.out.println("\ndescendente:");
		lista().stream().sorted((x, y) -> y.compareTo(x)).forEach(System.out::println);
	}

	/**
	 * transforma tutti elementi a maiuscula.
	 */
	@Override
	public void transformare() {
		lista().stream().map(String::toUpperCase).forEach(System.out::println);
	}

	/**
	 * seleziona i primi 2 elementi della lista
	 */
	@Override
	public void limitare() {
		lista().stream().limit(2).forEach(System.out::println);
	}

	/**
	 * conta elementi della lista
	 */
	@Override
	public long contare() {
		return lista().stream().count();
	}

	/**
	 * Utilizzo del Stream, può essere solo ciclato una sola volta
	 * 
	 * @since 1.0.14
	 */
	@Override
	public void stream() {
		System.out.println("\nStream");
		System.out.println("\nlinguaggi:");
		Stream<String> linguaggi = Stream.of(lista().toArray(new String[lista().size()]));
		linguaggi.forEach(System.out::println);
		
		// Crea un nuovo stream da uno esistente
		
		System.out.println("\ncrea un nuovo stream da uno esistente");
		Stream<Integer> lunghezzaParola = linguaggi.map(ele -> ele.length());
		lunghezzaParola.forEach(System.out::println);

		// Linguaggio con la parola più lunga
		
		System.out.println("\nlinguaggio con la parola più lunga");
		Optional<Integer> maxLunghuezza = lunghezzaParola.max(( x, y ) -> y - x);
		maxLunghuezza.ifPresent(max -> System.out.println("Lunghezzza massima: " + max));
		
		// Creare altro Stream da uno esistente
		System.out.println("\ncreare altro Stream da uno esistente con un carattere finale: !");		
		Stream<String> linguaggioSimbolo = lista().stream().map((String ele) -> ele + "!");		
		linguaggioSimbolo.forEach(System.out::println);
		
		// Filtrare per la creazione di un nuovo stream
		// Questo codice genera una exception IllegalStateException perché il Stream 
		// già stato consumato prima.
		// Quello che se fa è utilizzare la lista (lista()) e creare un stream se ha bisogno di
		// leggerlo più di una volta : "lista().stream()"
		System.out.println("\nfiltrare per la creazione di un nuovo stream");		
		// Stream<String> linguaggiConP = lista().stream().filter(ele -> ele.startsWith("P")); CREA EXCEPTION
		Stream<String> linguaggiConP = linguaggioSimbolo.filter(ele -> ele.startsWith("P")); // Per non avere eccezioni, utilizzo il stream precedente
		linguaggiConP.forEach(System.out::println);
		// Stream a partire di una List<String>
		// Peek : legge solo il stream senza alterarlo
		/*
		 * Stream.of("one", "two", "three", "four")
         * .filter(e -> e.length() > 3)
         * .peek(e -> System.out.println("Filtered value: " + e))
         * .map(String::toUpperCase)
         * .peek(e -> System.out.println("Mapped value: " + e))
         * .collect(Collectors.toList());
		 */
		System.out.println("\nstream a partire di una List<String>: !");	
		Stream<String> linguaggiConP2 = lista().stream().filter(ele -> ele.startsWith("P")); 
		linguaggiConP2.peek(System.out::println);
		
	}

}
