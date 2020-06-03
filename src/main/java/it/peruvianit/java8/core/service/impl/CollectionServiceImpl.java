/**
 * 
 */
package it.peruvianit.java8.core.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import it.peruvianit.java8.core.service.CollectionService;

/**
 * <pre>
 * 	Utilizzo delle collezione nella progrmazione funzionale
 * </pre>
 * 
 * @author Sergio Arellano {PeruViANit}
 *
 */
@Service
public class CollectionServiceImpl implements  CollectionService {

	@Override
	public String info() {
		return "Classe per il utilizzo delle prove per la programazione funzionale";
		
	}

	@Override
	public void ordena(List<String> list) {
		
		list.sort((String p1, String p2) -> p1.compareTo(p2));;
	}

	/**
	 * Tre modi diversi di gestire le lista
	 * 
	 */
	@Override
	public void utilizzoForEach() {
		
		List<String> colori = new ArrayList<>();
		
		colori.add("Rosso");
		colori.add("Bianco");
		colori.add("Blue");
		colori.add("Marrone");
		
		// Metodo Standard
		
		System.out.println("\nMetodo Standard");
		for(String colore : colori) {
			System.out.println(colore);
		}
		
		// Metodo Lambda
		System.out.println("\nMetodo Lambda");
		colori.forEach((String ele) -> System.out.println(ele));
		
		// lambda con riferimento
		System.out.println("\nMetodo Lambda con riferimento");
		colori.forEach(System.out::println);
		
	}

	@Override
	public void utilizzoRemoveIf() {
		List<String> frutte = new ArrayList<>();
		
		frutte.add("Pera");
		frutte.add("Mela");
		frutte.add("Banana");
		frutte.add("Anguria");
		
		frutte.forEach(System.out::println); // mostra lista
		
		System.out.println("Prima della cancellazione di [Pera]");
		
		// Metodo Standard -> Errore
		
		for(String frutta : frutte) {
			if (frutta.equalsIgnoreCase("Pera")) {
				/* 
				 * Non è possibile fare un'eliminazione utilizzando foreach
				 * va in eccepzione ConcurrentModificationException
				 */
				
				//frutte.remove(frutta); 
			}
		}
		
		// Metodo Standard -> OK
		
		Iterator<String> it = frutte.iterator();
		
		while(it.hasNext()) {
			if (it.next().equalsIgnoreCase("Pera")) {
				it.remove();
			}
		}
		
		// paradigma funzional
		
		frutte.removeIf(frutta -> frutta.equalsIgnoreCase("Banana"));
		
		frutte.forEach(System.out::println); // mostra lista
		
	}

	@Override
	public void utlizzoSort() {
		List<String> forme = new ArrayList<>();
		
		forme.add("Triangulo");
		forme.add("Quadrato");
		forme.add("Circolo");
		forme.add("Rettangulo");
		
		// Metodo Standard
		
		Collections.sort(forme, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		} );
		
		// Lambda
		
		forme.sort(( x, y) -> x.compareTo(y) );
		
		forme.forEach(System.out::println); // mostra lista
	}
	
}
