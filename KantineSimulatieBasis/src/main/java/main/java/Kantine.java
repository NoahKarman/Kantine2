package main.java;

import java.util.HashMap;

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

    public KantineAanbod getKantineaanbod() {
        return kantineaanbod;
    }

    public void setKantineAanbod(KantineAanbod kantineaanbod) {
        this.kantineaanbod = kantineaanbod;
    }

    /**
     * In deze methode wordt een Persoon en Dienblad gemaakt en aan elkaar gekoppeld. Maak twee
     * Artikelen aan en plaats deze op het dienblad. Tenslotte sluit de Persoon zich aan bij de rij
     * voor de kassa.
     */
    public void loopPakSluitAan(Dienblad dienblad,String[] artikel) {

       int i;
        for(i=0;i<artikel.length;i++){
            String naam = artikel[i];
            Artikel artikelen = kantineaanbod.getArtikel(naam);
            dienblad.voegToe(artikelen);

//            System.out.println("Naam van Artikel: "+naam);
//            System.out.println(dienblad.getArtikelenHashMap());
//
//            HashMap<String,Artikel> Artikelhashmap = dienblad.getArtikelenHashMap();
//            System.out.println("3");
//
//            dienblad.voegToe(Artikelhashmap.get(naam));

        }
        kassarij.sluitAchteraan(dienblad);

    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() {
        while (!kassarij.erIsEenRij()) {
            kassarij.eerstePersoonInRij();
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
