/**
 * 
 */
package it.peruvianit.java8.core.service.impl;

import org.springframework.stereotype.Service;

import it.peruvianit.java8.core.service.IRiferimentoMetodi;
import it.peruvianit.java8.core.service.RiferimentoMetodi;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 */
@Service
public class RiferimentoMetodiImp implements RiferimentoMetodi{

	public static void riferimentoMetodoStatico() {
		System.out.println("Messaggio per riferimento metodo statico");
	}

	@Override
	public void testRiferimentoStatico() {
		// TODO Auto-generated method stub
		
		IRiferimentoMetodi riferimentoMetodi = RiferimentoMetodiImp::riferimentoMetodoStatico;
		
		riferimentoMetodi.riferimentoMetodo();
	}
}
