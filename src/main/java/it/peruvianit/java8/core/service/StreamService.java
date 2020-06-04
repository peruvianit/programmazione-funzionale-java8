/**
 * 
 */
package it.peruvianit.java8.core.service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 * @version 1.0.0
 * @since 1.0.4
 */
public interface StreamService {
	
	void filtrare();
	
	void ordinare();
	
	void transformare();
	
	void limitare();
	
	long contare();
	
	default List<String> lista(){
		List<String> linguaggi = new ArrayList<>();
		
		linguaggi.add("Java");
		linguaggi.add("Kodlin");
		linguaggi.add("Pyhton");
		linguaggi.add("Scala");
		linguaggi.add("Go");
		
		return linguaggi;
		
	}

}
