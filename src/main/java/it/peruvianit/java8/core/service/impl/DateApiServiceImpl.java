/**
 * 
 */
package it.peruvianit.java8.core.service.impl;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import it.peruvianit.java8.DateApiService;

/**
 * Lavorazione con le date
 * 
 * @author Sergio Arellano {PeruViANit}
 *
 * @version 1.0.0
 * @since 1.0.8
 */
@Service
public class DateApiServiceImpl implements DateApiService {

	/**
	 * Creazione delle data, tempo e datetime
	 * e verifica {@code isAfter} e {@code isBefore}
	 */
	@Override
	public void comparazioneDataOra() {
		
		// Date
		LocalDate data1 = LocalDate.of(2020, 06, 05);
		LocalDate data2 = LocalDate.now();
		System.out.println("data1: " + data1 + ", data2:" + data2);
		System.out.println("isAfter: " + data1.isAfter(data2));
		System.out.println("isBefore: " + data1.isBefore(data2));
		
		// Time
		// Formato 24
		
		LocalTime time1 = LocalTime.of(23, 19, 00);
		LocalTime time2 = LocalTime.now();
		
		System.out.println("time1: " + time1 + ", time2:" + time2);
		System.out.println("isAfter: " + time1.isAfter(time2));
		System.out.println("isBefore: " + time1.isBefore(time2));
		
		// Date Time
		
		LocalDateTime dateTime1 = LocalDateTime.of(2020,06,05,23, 19, 00);
		LocalDateTime dateTime2 = LocalDateTime.now();
		
		System.out.println("dateTime1: " + dateTime1 + ", dateTime2:" + dateTime2);
		System.out.println("isAfter: " + dateTime1.isAfter(dateTime2));
		System.out.println("isBefore: " + dateTime1.isBefore(dateTime2));
		
	}

	/**
	 * Tempo transcorso tra 2 date
	 */
	@Override
	public void misuraTempo() throws InterruptedException {
		Instant instantInizio = Instant.now();
		
		Thread.sleep(1000);
		
		Instant instantFine = Instant.now();
		
		// Ritorna PT1S : Convensione della clase instant
		System.out.println("Durazione tra " + instantInizio + ", " + instantFine);
		System.out.println(Duration.between(instantInizio, instantFine));
		System.out.println("Durazione tra " + instantInizio + ", " + instantFine + " in millisecondi");
		System.out.println(Duration.between(instantInizio, instantFine).toMillis());
	}

	/**
	 * Diff con le date
	 */
	@Override
	public void differenzaTraDate() {
		LocalDate dataNascita = LocalDate.of(1975, 05, 28);
		LocalDate dataAttuale = LocalDate.now();
		
		Period period = Period.between(dataNascita, dataAttuale);
		
		System.out.println("Hanno trascorso " + period.getYears() +" anni, " +
					period.getMonths() + " mesi, " +  period.getDays() + 
					" giorni. Dalla data del nacimiento " + dataNascita + " a oggi");
		
	}

	/**
	 * Dare formati alle date
	 */
	@Override
	public void transformare() {
		String data = "06/06/2020";
		DateTimeFormatter dateTimeFormatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		LocalDate dataFormat= LocalDate.parse(data, dateTimeFormatter);
		System.out.println(dataFormat);
		System.out.println(dateTimeFormatter.format(dataFormat));
		dateTimeFormatter =  DateTimeFormatter.ofPattern("ddMMyyyy");
		System.out.println(dateTimeFormatter.format(dataFormat));
	}

}
