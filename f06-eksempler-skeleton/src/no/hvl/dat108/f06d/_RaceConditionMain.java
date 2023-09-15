package no.hvl.dat108.f06d;

public class _RaceConditionMain {

	public static void main(String[] args) throws InterruptedException {
		
		/*
		 * I dette eksempelet skal vi se at vi må beskytte delte ressurser
		 * mot potensiell samtidig oppdatering fra flere tråder ...
		 * 
		 * Vi lar to tråder ha tilgang til et (og samme) Teller-objekt.
		 * Den ene tråden prøver å øke verdien, mens den andre prøver å redusere verdien
		 *
		 * Vi skal se hvordan dette går, og evt. hva som kan/må gjøres for å
		 * få en mer "kontrollert" utførelse.
		 */
		
		//...
		int antall_ganger = 100_000;

		Teller teller = new Teller();

		Thread telleOppTraad = new TelleOppTraad(teller, antall_ganger);
		Thread telleNedTraad = new TelleNedTraad(teller, antall_ganger);

		telleOppTraad.start();
//		Thread.sleep((100)); //using "synchronized" in "Teller" class, but can use this delay as well,
							//both threads would "talk over each other" without and the result would be wrong.
		telleNedTraad.start();

		telleOppTraad.join();
		telleNedTraad.join();

		System.out.println(teller.getVerdi());
	}

}
