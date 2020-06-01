package main.java;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Een KassaRij klasse
 *
 * @author Redouan Klick & Noah Karman

 * @version 22/5/2020
 */
public class KassaRij {

    private Dienblad dienblad;
    private LinkedList<Dienblad> kassarij;


    /**
     * Constructor voor de KassaRij klase
     * @param kassarij - Een arraylist met daarin klanten
     */
    public KassaRij(LinkedList<Dienblad> kassarij) {

        this.kassarij = kassarij;
    }

    public KassaRij() {
        kassarij = new LinkedList<Dienblad>();
    }

    /**
     * Persoon sluit achter in de rij aan
     */
    public void sluitAchteraan(Dienblad dienblad) {

        kassarij.add(dienblad);
    }

    /**
     * Indien er een rij bestaat, de eerste klant uit de rij verwijderen en retourneren. Als er
     * niemand in de rij staat geeft deze null terug.
     *
     * @return Eerste klant in de rij of null
     */
    public Dienblad eerstePersoonInRij() {
        if (erIsEenRij()) {
            return null;
        } else {
            Dienblad temp = kassarij.get(0);
            kassarij.remove(0);
            return temp;
        }
    }

    /**
     * Methode kijkt of er personen in de rij staan.
     *
     * @return Of er wel of geen rij bestaat
     */
    public boolean erIsEenRij() {

        return kassarij.isEmpty();
    }
}
