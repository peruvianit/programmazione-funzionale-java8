package it.peruvianit.java8;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import it.peruvianit.java8.core.service.CollectionService;
import it.peruvianit.java8.core.service.InterfaceFunzionale;
import it.peruvianit.java8.core.service.LambdaService;
import it.peruvianit.java8.core.service.RiferimentoMetodi;
import it.peruvianit.java8.core.service.ScopeService;
import it.peruvianit.java8.core.service.StreamParalleloService;
import it.peruvianit.java8.core.service.StreamService;

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
		
		// Scope Variabile
		
		ScopeService scopeService = applicationContext.getBean(ScopeService.class);
		
		System.out.println(scopeService.provaLocalVariabile(3, 5));
		System.out.println(scopeService.provaAttributiVariabileStatici(5, 5));
		
		// Interface funzionale
		
		InterfaceFunzionale InterfaceFunzionale = applicationContext.getBean(InterfaceFunzionale.class);
		System.out.println(InterfaceFunzionale.message());
		
		// Riferimento Metodi
		
		RiferimentoMetodi riferimentoMetodi = applicationContext.getBean(RiferimentoMetodi.class);
		riferimentoMetodi.testRiferimentoStatico();
		riferimentoMetodi.testRiferimentoMetodoIstanzaOggettoArbitrario();
		riferimentoMetodi.testRiferimentoMetodoIstanzaOggetto();
		riferimentoMetodi.testRiferimentoMetodoConstruttore();
		
		// foreach, removeIf e Sort
		
		System.out.println("\nutilizzoForEach:");
		collectionService.utilizzoForEach();
		System.out.println("\nutilizzoRemoveIf:");
		collectionService.utilizzoRemoveIf();
		
		collectionService.utlizzoSort();
		
		// Stream
		
		StreamService streamService = applicationContext.getBean(StreamService.class);
		System.out.println("\nfilter:");
		streamService.filtrare();
		System.out.println("\nordinare:");
		streamService.ordinare();
		System.out.println("\ntransformare:");
		streamService.transformare();
		System.out.println("\nlimitare:");
		streamService.limitare();
		System.out.println("\ncontare:");
		System.out.println(streamService.contare());
		
		// Stream Parallelo
		
		StreamParalleloService streamParalleloService = applicationContext.getBean(StreamParalleloService.class);
		System.out.println("\nstream standard:");
		streamParalleloService.leggereNumeriStream();
		System.out.println("\nstream parallelo:");
		streamParalleloService.leggereNumeriStreamParallelo();
	}

}
