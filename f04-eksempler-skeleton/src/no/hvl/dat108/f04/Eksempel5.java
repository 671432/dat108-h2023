package no.hvl.dat108.f04;

import static no.hvl.dat108.f04.People.people;

import java.util.List;

/*
 * Eksempel4
 * 
 * Vårt andre stream()-eksempel.
 * Lage en liste av etternavnene til de som er over 50 år.
 */
public class Eksempel5 {

	public static void main(String[] args) {
		
		//2 - Lage en liste av etternavnene til de som er over 50 år
		
		//Gamlemåten:		
//		List<String> etternavnene = new ArrayList<>();
//		for(Person p : people) {
//			if (p.getAge() > 50) {
//				etternavnene.add(p.getLastName());
//			}
//		}
//		System.out.println(etternavnene);
		
		//Med streams:
		//...
		List<String> etternavnene = people.stream() //					From people
				.filter(p -> p.getAge() > 50) //						WHERE age > 50
				.map(Person::getLastName) //or (p -> p.getLastName()) | SELECT lasName
				.toList();

		System.out.println(etternavnene);
	}
}














