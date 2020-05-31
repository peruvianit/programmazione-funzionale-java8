package it.peruvianit.java8;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import it.peruvianit.java8.core.service.CollectionService;
import it.peruvianit.java8.core.service.LambdaService;

@SpringBootApplication
public class LambdaApplication {

	public static void main(String[] args) {
		//SpringApplication.run(LambdaApplication.class, args);
		ApplicationContext applicationContext = SpringApplication.run(LambdaApplication.class, args);
		
		LambdaService lambdaService = applicationContext.getBean(LambdaService.class);
		
		System.out.println(lambdaService.helloLambda("helloLambda"));
		
		
		// Collezioni
		
		List<String> list = new ArrayList<>();
		list.add("Pera");
		list.add("Mela");
		list.add("Arancia");
		list.add("Kiwi");
		
		
		CollectionService collectionService = applicationContext.getBean(CollectionService.class);
		
		// Ordena lista
		collectionService.ordena(list);
		
		list.forEach((String ele) -> System.out.println(ele));
	}

}
