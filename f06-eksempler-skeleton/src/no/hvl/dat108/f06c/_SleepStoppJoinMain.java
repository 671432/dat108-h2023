package no.hvl.dat108.f06c;

public class _SleepStoppJoinMain {

	public static void main(String[] args) throws InterruptedException {
		
		/*
		 * I dette eksempelet skal vi se på
		 * - Hvordan legge inn pause i en tråd
		 * - Hvordan stoppe en tråd som ellers går "evig"
		 * - Hvordan vente på at en tråd gjør seg ferdig
		 * - Hvordan avslutte program selv om ikke alle tråder er ferdige
		 */

		TraadSomKanStoppes t = new TraadSomKanStoppes("Traad");
		t.setDaemon(true);
		t.start();

		System.out.println("Pause i 2 sekunder ...");
		Thread.sleep(2000);
		System.out.println("Pause slutt!");

		t.stopp();

		t.join(); //makes the code w8 until the method is done before it continues (gets to stop main)

		System.out.println(Thread.currentThread().getName() + " avsluttes");
	}
}
