/**
 * 
 */
package it.peruvianit.java8.core.service;

import java.util.List;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 * @version 1.0.0
 * @since 1.0.1
 */
public interface CollectionService {

	/**
	 * ordena una lista utlizzando espresioni Lambda
	 * 
	 * @param list
	 * 
	 * @return
	 * 
	 * @version 1.0.0
	 * @since 1.0.1
	 */
	void ordena(List<String> list);
	
	void utilizzoForEach();
	
	void utilizzoRemoveIf();
	
	void utlizzoSort();
	
	String info();
}
