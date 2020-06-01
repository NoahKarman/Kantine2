package main.java;
public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;


    /**
     * Constructor
     */
    public Kantine() {
        kassarij = new KassaRij();
        kassa = new Kassa(kassarij);
    }

    /**
     * In deze methode wordt een Persoon en Dienblad gemaakt en aan elkaar gekoppeld. Maak twee
     * Artikelen aan en plaats deze op het dienblad. Tenslotte sluit de Persoon zich aan bij de rij
     * voor de kassa.
     */
    public void loopPakSluitAan(Persoon klant) {
        Dienblad dienblad = new Dienblad(0,klant);
        Artikel artikel = new Artikel("Kaasbroodje" , 595);
        Artikel artikel2 = new Artikel("Optimel" , 300);
        dienblad.voegToe(artikel);
        dienblad.voegToe(artikel2);
        kassarij.sluitAchteraan(klant,dienblad);

    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() {
        while (!kassarij.erIsEenRij()) {
            kassarij.eerstePersoonInRij();
        }
    }

  public void

    /**
     * Deze methode reset de bijgehouden telling van het aantal artikelen en "leegt" de inhoud van
     * de kassa.
     */
    public void resetKassa() {

        kassa.resetWaarden();
    }
}
