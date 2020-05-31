/**
 * 
 */
package it.peruvianit.java8.core.service.impl;

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

}
