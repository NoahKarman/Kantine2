package main.java;

import java.util.*;

/**
 * Een Een Kantine aanbod klasse
 *
 * @author Redouan Klick & Noah Karman

 * @version 22/5/2020
 */


public class KantineAanbod {
    // interne opslag voorraad
    private HashMap<String, ArrayList<Artikel>> aanbod;
    private HashMap<String, Integer> startVoorraad;
    private HashMap<String, Double> prijzen;

    /**
     * Constructor. Het eerste argument is een lijst met artikelnamen, het tweede argument is
     * eenlijst met prijzen en het derde argument is een lijst met hoeveelheden. Let op: de
     * dimensies van de drie arrays moeten wel gelijk zijn!
     */
    public KantineAanbod(String[] artikelnaam, double[] prijs, int[] hoeveelheid) {
        aanbod = new HashMap<String, ArrayList<Artikel>>();
        startVoorraad = new HashMap<String, Integer>();
        prijzen = new HashMap<String, Double>();
        for (int i = 0; i < artikelnaam.length; i++) {
            ArrayList<Artikel> artikelen = new ArrayList<Artikel>();
            for (int j = 0; j < hoeveelheid[i]; j++) {
                artikelen.add(new Artikel(artikelnaam[i], prijs[i]));
            }
            startVoorraad.put(artikelnaam[i], hoeveelheid[i]);
            prijzen.put(artikelnaam[i], prijs[i]);
            aanbod.put(artikelnaam[i], artikelen);
        }
    }

    /**
     * Stel de aanbod van de dag in
     *
     * @param aanbod  - de naam van het Hashmap
     */

    public void setAanbod(HashMap<String, ArrayList<Artikel>> aanbod) {
        this.aanbod = aanbod;
    }

    /**
     * Vraag de aanbod  op
     *
     * @return - Geeft aanbod terug
     */

    public HashMap<String, ArrayList<Artikel>> getAanbod() {

        //HashMap<String, ArrayList<Artikel>> aanbod = aanbod;

        return aanbod;
    }
    /**
     * Stel de prijzen in van de artikelen
     *
     * @param prijzen  - de naam van het Hashmap die de artikel prijzen weergeeft
     */

    public void setPrijzen(HashMap<String, Double> prijzen) {
        this.prijzen = prijzen;
    }

    /**
     * Vraag de prijzen van de artikelen op
     *
     * @return - Geeft prijzen van de artikelen terug
     */

    public HashMap<String, Double> getPrijzen() {
        return prijzen;
    }
    /**
     * Stel de vorrad waarme je begint in de kantine
     *
     * @param startVoorraad  - Het aantal artikelen die op vorrad liggen
     */

    public void setStartVoorraad(HashMap<String, Integer> startVoorraad) {
        this.startVoorraad = startVoorraad;
    }

    /**
     * Vraag de start vorrad op
     *
     * @return - Geeft de start vorrad terug van de kantine
     */

    public HashMap<String, Integer> getStartVoorraad() {
        return startVoorraad;
    }

    /**
     * In deze methode wordt de vorrad aangevuld als de huidige hoevelheid artikelen kleiner is dan
     * de start vorrad
     */
    private void vulVoorraadAan(String productnaam) {
        ArrayList<Artikel> huidigeVoorraad = aanbod.get(productnaam);
        int startHoeveelheid = startVoorraad.get(productnaam);
        int huidigeHoeveelheid = huidigeVoorraad.size();
        double prijs = prijzen.get(productnaam);
        for (int j = huidigeHoeveelheid; j < startHoeveelheid; j++) {
            huidigeVoorraad.add(new Artikel(productnaam, prijs));
        }
        for (int j = huidigeHoeveelheid; j < 1; j++) {
            huidigeVoorraad.add(new Artikel(productnaam, prijs));
        }
        aanbod.put(productnaam, huidigeVoorraad);
    }

    /*
     * Private methode om de lijst van artikelen te krijgen op basis van de naam van het artikel.
     * Retourneert null als artikel niet bestaat.
     */
    private ArrayList<Artikel> getArrayList(String productnaam) {
        return aanbod.get(productnaam);
    }

    /**
     * Private methode om een Artikel van de stapel artikelen af te pakken. Retourneert null als de
     * stapel leeg is.
     */
    private Artikel getArtikel(ArrayList<Artikel> stapel) {
        if (stapel == null) {
            return null;
        }
        if (stapel.size() == 0) {
            return null;
        } else {
            Artikel a = stapel.get(0);
            stapel.remove(0);
            if (stapel.size() <= 10)
                vulVoorraadAan(a.getNaam());
            return a;
        }
    }

    /**
     * Publieke methode om een artikel via naam van de stapel te pakken. Retouneert null als artikel
     * niet bestaat of niet op voorraad is.
     *
     * @param productnaam (van artikel)
     * @return artikel (of null)
     */
    public Artikel getArtikel(String productnaam) {
        return getArtikel(getArrayList(productnaam));
    }
}
