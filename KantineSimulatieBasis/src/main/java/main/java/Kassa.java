package main.java;
import java.io.IOException;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Een Een Kassa klasse
 *
 * @author Redouan Klick & Noah Karman

 * @version 22/5/2020
 */


public class Kassa {

    private Dienblad dienblad;
    private Artikel artikel;
    private int totaalArtikelenKassa;
    private int totaalGeldKassa;
    private KassaRij kassarij;

    public Kassa(KassaRij kassarij) {
        this.kassarij = kassarij;
    }

    /**
     * Constructor voor de Kassa klase
     * @param controleTotalenArtikelen - Geeft het totale nummer van artikelen door
     * @param controleTotalenGeld - Geeft het totale aantal geld door
     */
    public Kassa(int controleTotalenArtikelen, int controleTotalenGeld) {
        this.totaalArtikelenKassa = controleTotalenArtikelen;
        this.totaalGeldKassa = controleTotalenGeld;
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


        Betaalwijze betaalwijze = klant.getKlant().getBetaalwijze();
        if (klant.getKlant() instanceof KortingskaartHouder) {
            Persoon p = klant.getKlant();
            double kortingsBon;
            kortingsBon = klant.geefPrijs() * (((KortingskaartHouder) p).geefKortingsPercentage() * 0.01);
            if (((KortingskaartHouder) p).heeftMaximum()){
            if((kortingsBon > ((KortingskaartHouder) p).geefMaximum())){
                kortingsBon = ((KortingskaartHouder)p).geefMaximum();
                }
            }
            totaalGeldKassa -= kortingsBon;
            //tester korting
            System.out.println("Kortingsbon: " + kortingsBon + " $");
        }
        try
        {
            betaalwijze.betaal(klant.geefPrijs());
            this.totaalArtikelenKassa += klant.geefAantalArtikelen();
            this.totaalGeldKassa += klant.geefPrijs();

        }catch(TeWeinigGeldExeption e){
            System.out.println(klant.getKlant().getVoornaam() + "ERROR:Niet genoeg saldo");
        }
    }


    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd, vanaf het moment dat de methode
     * resetWaarden is aangeroepen.
     *
     * @return aantal artikelen
     */
    public int aantalArtikelen() {

        return this.totaalArtikelenKassa;

    }
    /**
     * Stelt het totale geld wat in de kassa zit
     * @param totaalPrijsKassa - Geeft aan hoe veel geld er in de kassa zit
     */

    public void setTotaalPrijsKassa(int totaalPrijsKassa) {
        this.totaalGeldKassa = totaalPrijsKassa;
        double roundOff = Math.round(totaalGeldKassa*100.0)/100.0;
        System.out.println(roundOff);
    }

    /**
     * Geeft het totaalbedrag van alle artikelen die de kassa zijn gepasseerd, vanaf het moment dat
     * de methode resetKassa is aangeroepen.
     *
     * @return hoeveelheid geld in de kassa
     */
    public int hoeveelGeldInKassa() {

        return this.totaalGeldKassa;
    }

    /**
     * reset de waarden van het aantal gepasseerde artikelen en de totale hoeveelheid geld in de
     * kassa.
     */
    public void resetWaarden() {
        this.totaalArtikelenKassa = 0;
        this.totaalGeldKassa = 0;
    }
}
