/**
 * 
 */
package it.peruvianit.java8.core.service.impl;

import org.springframework.stereotype.Service;

import it.peruvianit.java8.core.service.StreamParalleloService;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 * @version 1.0.0
 * @since 1.0.6
 */
@Service
public class StreamParalleloServiceImpl implements StreamParalleloService {

	/**
	 * Leggere una lista di forma standard e sequenziale
	 */
	@Override
	public void leggereNumeriStream() {
		numeri().stream().forEach(System.out::println);		
	}

	/**
	 * Leggere una lista con threads
	 * 
	 * <pre>
	 * lo Stream parallelo si possa affrontare un task in modo più performante rispetto ad uno 
	 * Stream sequenziale, in realtà le situazioni che si possono avere non sono sempre cosi 
	 * semplici ed immediate. Dobbiamo considerare il fatto che non tutti gli Stream sono 
	 * facilmente divisibili (splitting).
	 * </pre>
	 */
	@Override
	public void leggereNumeriStreamParallelo() {
		numeri().parallelStream().forEach(System.out::println);
		
	}

	
}
