/**
 * 
 */
package it.peruvianit.java8.core.service.impl;

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

}
