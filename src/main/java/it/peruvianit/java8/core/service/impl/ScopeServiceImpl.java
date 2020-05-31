/**
 * 
 */
package it.peruvianit.java8.core.service.impl;

import org.springframework.stereotype.Service;

import it.peruvianit.java8.core.service.IOperation;
import it.peruvianit.java8.core.service.ScopeService;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 * @version 1.0.0
 * @since 1.0.1
 */
@Service
public class ScopeServiceImpl implements ScopeService {

	private static double risultato;
	
	@Override
	public String provaLocalVariabile(double a, double b) {
		// La variabile deve essere final, se non è dechiarato, java lo interpreta come final
		final String message = "Il resultato di (" + a + "+" + b + ") = ";
		
		IOperation operation = (double d1, double d2) -> {
			/*
			*   Per il scope di una variabile locale, non può essere modificata. 
			*	message ="cambio valore"; 
			*	Errore : The final local variable message cannot be assigned. It must be blank and not using a compound assignment
			*/
			double ope = d1 + d2;
			return  message + ope;
		};
		
		return operation.provaLocalVariabile(a,b);
	}

	@Override
	public String provaAttributiVariabileStatici(double a, double b) {
		IOperation operation = (double d1, double d2) -> {
			
			String message = "Il resultato di (" + a + "+" + b + ") = ";
			
			/*
			 *  modifica della variabile statica della classe
			 *  
			 *  potrebbe essere declarata non statica, e l'effetto è lo stesso
			 *  private double risultato;
			 *  
			 */
			
			double risultato = d1 + d2;
			return  message + risultato;
		};
		
		return operation.provaLocalVariabile(a,b);
	}

	
}
