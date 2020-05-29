package main.java;
import java.util.Iterator;
import java.util.ArrayList;

public class Kassa {

    private Dienblad dienblad;
    private Artikel artikel;
    private int totaalArtikelen;
    private int totaalPrijs;

    public Kassa(KassaRij kassarij) {

    }

    public Kassa(int controleTotalenArtikelen, int controleTotalenGeld) {
        this.totaalArtikelen = controleTotalenArtikelen;
        this.totaalPrijs = controleTotalenGeld;
    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op. Tel deze gegevens op bij de controletotalen
     * die voor de kassa worden bijgehouden. De implementatie wordt later vervangen door een echte
     * betaling door de persoon.
     *
     * @param klant - de klant die afrekent.

     *
     */
    public void rekenAf(Dienblad klant) {

        this.totaalArtikelen += klant.artikelen.size();
        this.totaalPrijs += klant.getTotaalPrijs();
    }


    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd, vanaf het moment dat de methode
     * resetWaarden is aangeroepen.
     *
     * @return aantal artikelen
     */
    public int aantalArtikelen() {

        return this.totaalArtikelen;

    }

    /**
     * Geeft het totaalbedrag van alle artikelen die de kassa zijn gepasseerd, vanaf het moment dat
     * de methode resetKassa is aangeroepen.
     *
     * @return hoeveelheid geld in de kassa
     */
    public int hoeveelGeldInKassa() {

        return this.totaalPrijs;
    }

    /**
     * reset de waarden van het aantal gepasseerde artikelen en de totale hoeveelheid geld in de
     * kassa.
     */
    public void resetWaarden() {
        this.totaalArtikelen = 0;
        this.totaalPrijs = 0;
    }
}
