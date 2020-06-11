/**
 * 
 */
package it.peruvianit.java8.core.service.impl;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import it.peruvianit.java8.core.service.ComposizioniFunzioniService;

/**
 * Utilizzo della composizione delle funzioni, prima di effetuare il codice lambda
 * compose : prima di elaborazione
 * antThen : dopo elaborazione 
 * 
 * @author Sergio Arellano {PeruViANit}
 *
 * @version 1.0.0
 * @since 1.0.13
 */
@Service
public class ComposizioniFunzioniImp implements ComposizioniFunzioniService {

	Function<Integer, Integer> multiplicaPer3 = 
		x -> {
			System.out.println("Multiplica per 3 a " + x  + " = " +  (x * 1));
			return x * 3;
		};
	
	Function<Integer, Integer> aggiungeUno = 
			multiplicaPer3.compose(
			x -> {
				System.out.println("Aggiungendo 1 a " + x  + " = " +  (x + 1));
				
				return x + 1;
			});
	
	Function<Integer, Integer> dopoCalcolo = 
			aggiungeUno.andThen(
			x -> {
				System.out.println("Effettuando il quadratto al numero : " + x);
				
				return x  * x;
			});
	
	@Override
	public void operazione(Integer numero) {
		System.out.println(dopoCalcolo.apply(numero));

	}

}
