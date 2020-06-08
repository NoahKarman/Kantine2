package main.java;

import java.util.HashMap;


/**
 * Een Kantine klasse
 *
 * @author Redouan Klick & Noah Karman

 * @version 22/5/2020
 */

public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;
    private KantineAanbod kantineaanbod;


    /**
     * Constructor
     */
    public Kantine() {
        kassarij = new KassaRij();
        kassa = new Kassa(kassarij);
    }

    /**
     * Getter voor kassa
     */
    public Kassa getKassa() {
        return kassa;
    }

    /**
     * Getter voor kantine aanbod
     */
    public KantineAanbod getKantineaanbod() {
        return kantineaanbod;
    }

    /**
     * Stelt he kantine aanbod in
     */
    public void setKantineAanbod(KantineAanbod kantineaanbod) {
        this.kantineaanbod = kantineaanbod;
    }

    /**
     * In deze methode wordt een Persoon en Dienblad gemaakt en aan elkaar gekoppeld. Maak twee
     * Artikelen aan en plaats deze op het dienblad. Tenslotte sluit de Persoon zich aan bij de rij
     * voor de kassa.
     */
    public void loopPakSluitAan(Dienblad dienblad,String[] artikel) {


        for(int i=0;i<artikel.length;i++){
            String naam = artikel[i];
            Artikel artikelen = kantineaanbod.getArtikel(naam);
            dienblad.voegToe(artikelen);
        }
        kassarij.sluitAchteraan(dienblad);

    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() {
        while (!kassarij.erIsEenRij()) {
            Dienblad dienblad = kassarij.eerstePersoonInRij();
            this.getKassa().rekenAf(dienblad);
        }
    }


    /**
     * Deze methode reset de bijgehouden telling van het aantal artikelen en "leegt" de inhoud van
     * de kassa.
     */
    public void resetKassa() {

        kassa.resetWaarden();
    }
}
