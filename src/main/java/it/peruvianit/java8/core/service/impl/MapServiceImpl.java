/**
 * 
 */
package it.peruvianit.java8.core.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import it.peruvianit.java8.core.service.MapService;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 * @version 1.0.0
 * @since 1.0.7
 */
@Service
public class MapServiceImpl implements MapService {

	@Override
	public void leggereJava7() {
		for (Entry<Integer, String> e : mapa().entrySet()) {
			System.out.println("chiave: " + e.getKey() +
					" , valore: " + e.getValue());
		}
		
	}

	@Override
	public void leggereJava8() {
		// diretto
		mapa().forEach((k,v) -> System.out.println("chiave: " + k +
				" , valore: " +v));
		
		// utilizzando stream
		mapa().entrySet().stream().forEach(System.out::println);
	}

	@Override
	public void recolettare() {
		Map<Integer, String> mapaRecolettato = 
				mapa().entrySet().stream().filter(e -> e.getValue()
				.startsWith("P"))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
				
		mapaRecolettato.entrySet().stream().forEach(System.out::println);
		
	}

	/**
	 * Aggiunge elemento a la lista se è assente
	 */
	@Override
	public void aggiungereSeAssente() {
		mapa().putIfAbsent(2, "Non lo aggiunge"); // KO
		mapa().putIfAbsent(6, "Billiardo"); // OK
		mapa().entrySet().stream().forEach(System.out::println);		
	}

	@Override
	public void operareSePresente() {
		
		HashMap<Integer, String> wordCount = new HashMap<>(); 
        wordCount.put(1,"persona"); 
        wordCount.put(2,",macchina" ); 
        wordCount.put(3,"palazzo"); 
        wordCount.put(3,"lago");
        wordCount.put(3,"pala");
        
        wordCount.computeIfPresent(2,(k, v) -> v + " ::> operato");
		System.out.println(wordCount);
        
	}

	/**
	 * obtenere un valore predeterminato quando non esiste nella mapa
	 */
	@Override
	public void OttenerePredeterminato() {
		String valore = mapa().getOrDefault(10, "valore predeterminato");
		System.out.println(valore);
	}

}
