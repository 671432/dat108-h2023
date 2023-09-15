package no.hvl.dat108.f06d;

public class Teller {

	private int verdi = 0;

	public void tellOpp() {
		synchronized(this) { //can either use synchronized inside the method...
			verdi++;
		}
	}

	public synchronized void tellNed() { //...or we can use synchronized to define the whole method.
			verdi--;

	}

	public int getVerdi() {
		return verdi;
	}
}
