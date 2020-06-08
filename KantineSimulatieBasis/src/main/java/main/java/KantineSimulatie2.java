package main.java;

import java.util.*;


/**
 * Een Een Kantine Simulatie2 klasse
 *
 * @author Redouan Klick & Noah Karman

 * @version 22/5/2020
 */

public class KantineSimulatie2 {

    // kantine
    private Kantine kantine;

    // kantineaanbod
    private KantineAanbod kantineaanbod;

    // random generator
    private Random random;
    private Dienblad dienblad;

    // aantal artikelen
    private static final int AANTAL_ARTIKELEN = 4;

    // artikelen
    private static final String[] artikelnamen =
            new String[] {"Koffie", "Broodje pindakaas", "Broodje kaas", "Appelsap"};

    // prijzen
    private static double[] artikelprijzen = new double[] {1.50, 2.10, 1.65, 1.65};

    // minimum en maximum aantal artikelen per soort
    private static final int MIN_ARTIKELEN_PER_SOORT = 10;
    private static final int MAX_ARTIKELEN_PER_SOORT = 20;

    // minimum en maximum aantal personen per dag
    private static final int MIN_PERSONEN_PER_DAG = 50;
    private static final int MAX_PERSONEN_PER_DAG = 100;

    // minimum en maximum aantal dagen voorbij
    private static final int MIN_DAGEN_PER_MAAND = 1;
    private static final int MAX_DAGEN_PER_MAAND = 31;

    // minimum en maximum artikelen per persoon
    private static final int MIN_ARTIKELEN_PER_PERSOON = 1;
    private static final int MAX_ARTIKELEN_PER_PERSOON = 4;

    /**
     * Constructor
     * Maakt nieuw kantine aan met willekurige waarde van (hoevelheiden en soorten artikelen).
     * Er komt ook een nieuwe kantine aanbod met de artikel namen en prijzen + de willekurige waarden.
     * Print een artikel uit om te testen dat het werk
     */
    public KantineSimulatie2() {
        kantine = new Kantine();
        random = new Random();
        int[] hoeveelheden =
                getRandomArray(AANTAL_ARTIKELEN, MIN_ARTIKELEN_PER_SOORT, MAX_ARTIKELEN_PER_SOORT);


        kantineaanbod = new KantineAanbod(artikelnamen, artikelprijzen, hoeveelheden);


        kantine.setKantineAanbod(kantineaanbod);
        //Print een artikel uit om te testen dat het werk

    }

    /**
     * Methode om een array van random getallen liggend tussen min en max van de gegeven lengte te
     * genereren
     *
     * @param lengte
     * @param min
     * @param max
     * @return De array met random getallen
     */
    private int[] getRandomArray(int lengte, int min, int max) {
        int[] temp = new int[lengte];
        for (int i = 0; i < lengte; i++) {
            temp[i] = getRandomValue(min, max);
        }

        return temp;
    }

    /**
     * Methode om een random getal tussen min(incl) en max(incl) te genereren.
     *
     * @param min
     * @param max
     * @return Een random getal
     */
    private int getRandomValue(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Methode om op basis van een array van indexen voor de array artikelnamen de bijhorende array
     * van artikelnamen te maken
     *
     * @param indexen
     * @return De array met artikelnamen
     */
    private String[] geefArtikelNamen(int[] indexen) {
        String[] artikelen = new String[indexen.length];

        for (int i = 0; i < indexen.length; i++) {
            artikelen[i] = artikelnamen[indexen[i]];

        }

        return artikelen;
    }

    /**
     * Deze methode simuleert een aantal dagen
     * in het verloop van de kantine
     *
     * @param dagen
     */
    public void simuleer(int dagen) {
        // for lus voor dagen
        for(int i = 0; i < dagen; i++) {

            // bedenk hoeveel personen vandaag binnen lopen
            int aantalpersonen = 100;
            int kans = new Random().nextInt(100);

            // laat de studenten binnenkomen
            for (int j = 0; j < aantalpersonen; j++) {

                if (kans <= 88) {
                    Student student = new Student();
                    Dienblad dienblad = new Dienblad(student);
                }
                if (kans <= 9) {
                    Docent docent  = new Docent();
                    Dienblad dienblad = new Dienblad(docent);
                }
                if (kans == 1) {
                    KantineMedewerker kantineMedewerker = new KantineMedewerker();
                    Dienblad dienblad = new Dienblad(kantineMedewerker);
                }

                // en bedenk hoeveel artikelen worden gepakt
                int aantalartikelen = getRandomValue(1, 10);

                // genereer de "artikelnummers", dit zijn indexen
                // van de artikelnamen
                int[] tepakken = getRandomArray(
                        aantalartikelen, 0, AANTAL_ARTIKELEN - 1);

                // vind de artikelnamen op basis van
                // de indexen hierboven
                String[] artikelen = geefArtikelNamen(tepakken);
                kantine.loopPakSluitAan(dienblad, artikelen);

                // loop de kantine binnen, pak de gewenste
                // artikelen, sluit aan
            }


            kantine.verwerkRijVoorKassa();
            // verwerk rij voor de kassa

            System.out.println("dag" + " " + (i + 1));
            // druk de dagtotalen af

            System.out.println(aantalpersonen + " Personen geweest" + "\n" + "----------------");
            // druk af hoeveel personen binnen zijn gekomen

            kantine.resetKassa();
            // reset de kassa voor de volgende dag


        }
    }
}


    /*public void simuleer(int dagen) {
        // for lus voor dagen
        for(int i = 0; i < dagen; i++) {

            // bedenk hoeveel personen vandaag binnen lopen
            int aantalpersonen = 100;
            int aantalstudenten = 89;
            int aantaldocenten = 10;

            // laat de studenten binnenkomen
            for (int j = 0; j < aantalstudenten; j++) {

                // maak persoon en dienblad aan, koppel ze
                for (int k = 0; k < aantalstudenten; k++) {
                    Student student = new Student();
                    Dienblad dienblad = new Dienblad(student);
                }

                // en bedenk hoeveel artikelen worden gepakt
                int aantalartikelen = getRandomValue(1, 10);

                // genereer de "artikelnummers", dit zijn indexen
                // van de artikelnamen
                int[] tepakken = getRandomArray(
                        aantalartikelen, 0, AANTAL_ARTIKELEN - 1);

                // vind de artikelnamen op basis van
                // de indexen hierboven
                String[] artikelen = geefArtikelNamen(tepakken);
                kantine.loopPakSluitAan(dienblad, artikelen);

                // loop de kantine binnen, pak de gewenste
                // artikelen, sluit aan
            }

            // laat de docenten maar komen...
            for (int l = 0; l < aantaldocenten; l++) {

                // maak persoon en dienblad aan, koppel ze
                for (int m = 0; m < aantaldocenten; m++) {
                    Docent docent = new Docent();
                    Dienblad dienblad = new Dienblad(docent);
                }

                // en bedenk hoeveel artikelen worden gepakt
                int aantalartikelen = getRandomValue(1, 10);

                // genereer de "artikelnummers", dit zijn indexen
                // van de artikelnamen
                int[] tepakken = getRandomArray(
                        aantalartikelen, 0, AANTAL_ARTIKELEN - 1);

                // vind de artikelnamen op basis van
                // de indexen hierboven
                String[] artikelen = geefArtikelNamen(tepakken);
                kantine.loopPakSluitAan(dienblad, artikelen);

                // loop de kantine binnen, pak de gewenste
                // artikelen, sluit aan
            }

            KantineMedewerker kantinemedewerker = new KantineMedewerker();
            Dienblad dienblad = new Dienblad(kantinemedewerker);

            // en bedenk hoeveel artikelen worden gepakt
            int aantalartikelen = getRandomValue(1, 10);

            // genereer de "artikelnummers", dit zijn indexen
            // van de artikelnamen
            int[] tepakken = getRandomArray(
                    aantalartikelen, 0, AANTAL_ARTIKELEN - 1);
            
            // vind de artikelnamen op basis van
            // de indexen hierboven
            String[] artikelen = geefArtikelNamen(tepakken);
            kantine.loopPakSluitAan(dienblad, artikelen);

            // loop de kantine binnen, pak de gewenste
            // artikelen, sluit aan

            kantine.verwerkRijVoorKassa();
            // verwerk rij voor de kassa

            System.out.println("dag" + " " + (i + 1));
            // druk de dagtotalen af


            System.out.println(aantalpersonen + " Personen geweest" + "\n" + "----------------");
            // druk af hoeveel personen binnen zijn gekomen

            kantine.resetKassa();
            // reset de kassa voor de volgende dag


        }
    }
}
*/