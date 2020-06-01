package main.java;


/**
 * Een Kantine Simulatie1 klasse
 *
 * @author Redouan Klick & Noah Karman

 * @version 22/5/2020
 */

public class KantineSimulatie1 {

    private Kantine kantine;

    public static final int DAGEN = 7;
    private Artikel artikelen;
    private KassaRij kassarij;
    private KantineAanbod kantineaanbod;
    private static final String[] artikelnamen =
            new String[] {"Koffie", "Broodje pindakaas", "Broodje kaas", "Appelsap"};
    private static double[] artikelprijzen = new double[] {1.50, 2.10, 1.65, 1.65};

    /**
     * Constructor
     */
    public KantineSimulatie1() {
        kantine = new Kantine();
        int[] hoeveelheden =
                new int[]{100,100,0,0};
        kantineaanbod = new KantineAanbod(artikelnamen, artikelprijzen, hoeveelheden);
        kantine.setKantineAanbod(kantineaanbod);

    }

    /**
     * Deze methode simuleert een aantal dagen in het
     * verloop van de kantine
     *
     * @param dagen
     */
    public void simuleer(int dagen) {

        // herhaal voor elke dag
        for (int i = 0; i < dagen; i++) {
            System.out.println("----------Het is vandaag dag " + i + "----------");

            // per dag nu even vast 10 + i personen naar binnen
            // laten gaan, wordt volgende week veranderd...

            // for lus voor personen
            for (int j = 0; j < 10 + i; j++) {
                Persoon persoon = new Persoon();
                Dienblad dienblad = new Dienblad(persoon);
                String[] artikelen = new String[]{
                    "Broodje pindakaas",
                    "Koffie"
                };
                System.out.println("Klant " + j + " heeft de volgende artikelen gepakt: " + artikelen[0] + " en " + artikelen[1]);
                kantine.loopPakSluitAan(dienblad,artikelen);



            }

            // verwerk rij voor de kassa
            kantine.verwerkRijVoorKassa();

            // toon dagtotalen (artikelen en geld in kassa)
            kantine.getKassa();


            // reset de kassa voor de volgende dag
            kantine.resetKassa();
        }
    }

    /**
     * Start een simulatie
     */
    public static void main(String[] args) {
        int dagen;

        if (args.length == 0) {
            dagen = DAGEN;
        } else {
            dagen = Integer.parseInt(args[0]);
        }
        KantineSimulatie1 sim = new KantineSimulatie1();
        sim.simuleer(dagen);
    }
}
