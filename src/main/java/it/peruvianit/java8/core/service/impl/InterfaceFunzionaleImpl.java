/**
 * 
 */
package it.peruvianit.java8.core.service.impl;

import org.springframework.stereotype.Service;

import it.peruvianit.java8.core.service.InterfaceFunzionale;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 * @version 1.0.0
 * @since 1.0.2
 */
@Service
public class InterfaceFunzionaleImpl implements InterfaceFunzionale {

	@Override
	public String mostraMessaggio() {
		/*
		 * Se ci sono più di una interfaccia implementata sulla classe e esiste lo stesso metodo in due interface diverse,
		 * se potrebbe dechiarare con 
		 * InterfaceFunzionale.super.message()
		 */
		return message();
	}
	
}
