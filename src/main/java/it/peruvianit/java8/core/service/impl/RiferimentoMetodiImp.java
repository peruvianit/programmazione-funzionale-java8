/**
 * 
 */
package it.peruvianit.java8.core.service.impl;

import java.util.Arrays;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.stereotype.Service;

import it.peruvianit.java8.core.service.IPersona;
import it.peruvianit.java8.core.service.IRiferimentoMetodi;
import it.peruvianit.java8.core.service.RiferimentoMetodi;
import it.peruvianit.java8.view.PersonaView;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 */
@Service
public class RiferimentoMetodiImp implements RiferimentoMetodi{

	public static void riferimentoMetodoStatico() {
		System.out.println("Messaggio per riferimento metodo statico");
	}

	private void riferimentoMetodoIstanzaOggettoArbitrario() {
		String[] nomi = {"Sergio", "Alessandro", "Vanessa"};
		
		Arrays.sort(nomi, String::compareToIgnoreCase);
		System.out.println(Arrays.toString(nomi));
	}
	
	private void riferimentoMetodoIstanzaOggetto() {
		System.out.println("Messaggio per riferimento metodo istanza oggetto");
	}
	
	private void riferimentoMetodoConstruttore() {
		IPersona persona = PersonaView::new;
		
		PersonaView personaView = persona.crear("Sergio", "Arellano");
		
		System.out.println(ReflectionToStringBuilder.toString(personaView, ToStringStyle.MULTI_LINE_STYLE));
	}
	@Override
	public void testRiferimentoStatico() {
		// TODO Auto-generated method stub
		
		IRiferimentoMetodi riferimentoMetodi = RiferimentoMetodiImp::riferimentoMetodoStatico;
		
		riferimentoMetodi.riferimentoMetodo();
	}


	@Override
	public void testRiferimentoMetodoIstanzaOggettoArbitrario() {
		riferimentoMetodoIstanzaOggettoArbitrario();
		
	}
	
	@Override
	public void testRiferimentoMetodoIstanzaOggetto() {
		RiferimentoMetodiImp riferimentoMetodiImp = new RiferimentoMetodiImp();
		
		IRiferimentoMetodi riferimentoMetodi = riferimentoMetodiImp::riferimentoMetodoIstanzaOggetto;
		riferimentoMetodi.riferimentoMetodo();
		
	}

	@Override
	public void testRiferimentoMetodoConstruttore() {
		riferimentoMetodoConstruttore();
	}
	
}
