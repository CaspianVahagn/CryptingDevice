package MyObjects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

/**
 * Eine billige Klasse "Zufaller" vom Random-Schwarzmarkt hat die Methoden
    public void setMax()
    public void createZahl()
Sie garantiert, dass die generierten Zahlen zwischen 1 und max liegen und 
gleichverteilt sind.
Sie trauen der Klasse nicht und wollen einen JUnit-Test schreiben, der 10000 
Zahlen zwischen 1 und 100 generieren lässt und prüft,
    *ob die Zahlen im gewählten Bereich liegen und
    *ob jede Zahl mindestens 95x und maximal 105x vorkommt

Java Klasse schreiben
 * @author Dominik
 *
 */

public class Zufaller {
	private int max = 10;
	private Random rando = new Random();
	
	public void setMax(int max){
		this.max = max;
	}
	
	public int createZahl(){
		
		
		int cc = (int) (Math.random()*max)+1;
		return cc;
	}

}
