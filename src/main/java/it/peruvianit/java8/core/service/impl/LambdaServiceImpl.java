/**
 * 
 */
package it.peruvianit.java8.core.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import it.peruvianit.java8.core.service.IHelloLambda;
import it.peruvianit.java8.core.service.LambdaService;

/**
 * <pre>
 * Lambda è una classe anomina, su è struttura : 
 * 
 * <strong>(parametri) -> espressione</strong>
 * 
 * </code>
 * </pre>
 * 
 * @author Sergio Arellano {PeruViANit}
 *
 * @version 1.0.0
 * @since 1.0.1
 */
@Service
public class LambdaServiceImpl implements LambdaService {

	@Override
	public String helloLambda( final String message) {
		
		IHelloLambda helloLambda = (str_capitalize) -> { return StringUtils.capitalize(str_capitalize);}; 
		
		return message + ",stata capitalizata : " + helloLambda.message(message);
	}

	
	
}
