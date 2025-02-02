package no.hvl.dat108.f03a.fikse;

/* Kopiert fra javabrains.io sitt Java 8 Lambda Basics kurs */

import java.util.*;
import java.util.function.*;

public class Main {
	
	static void printAll(List<Person> liste) {
		System.out.println();
		for (Person p : liste) {
			System.out.println(p);
		}
	}
	
	static void printLastNameStartsWithC(List<Person> liste) {
		System.out.println();
		for (Person p : liste) {
			if (p.getLastName().startsWith("C")) {
				System.out.println(p);
			}
		}
	}

	static void NotUsedYet(List<Person> liste) {
		System.out.println();
		for (Person p : liste) {
			if (p.getLastName().startsWith("C")) {
				System.out.println(p);
			}
		}
	}

	static void doConditionally(
			List<Person> liste, Predicate<Person> pred, Consumer<Person> cons) {
		System.out.println();
		for (Person p : liste) {
			if (pred.test(p)) {
				cons.accept(p);
			}
		}
	}

	static void printConditionally(List<Person> liste, Predicate<Person> pred) {
		System.out.println();
		for (Person p : liste) {
			if (pred.test(p)) {
				System.out.println(p);
			}
		}
	}

	
	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
				);

		// 1: Sorter personene på etternavn.
		Collections.sort(people, (a,b) -> a.getLastName().compareTo(b.getLastName()));
		
		// 2: Skriv ut alle personene, én linje per person. 
		printAll(people);
		
		// 3: Skriv ut alle personene som har etternavn som begynner på C.
		printLastNameStartsWithC(people);
		
		// 4: Skriv ut alle personene som har fornavn som begynner på C.
		//		Vi ser nå at det er tungvint å lage én utskriftsmetode per
		//      spesialtilfelle. Lag en generell hjelpemetode printConditionally(...)
		//		gjør jobben i stedet. Denne tar inn listen + et lambdauttrykk.
		printConditionally(people, p -> p.getFirstName().startsWith("C"));
		
		// 5: Skriv ut ALLE personene ved å bruke printConditionally(...)
		printConditionally(people, p -> true);
		
		// 6: Skriv ut alder til alle over 50 år.
		//    	Lag en metode doConditionally(...)
		doConditionally(people, p -> p.getAge()>50,
				p -> System.out.println(p.getAge())); // x -> System.out.println(x) = System.out::println
		
	}
	
}
