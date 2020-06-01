package main.java;

public class KantineSimulatie1 {

    private Kantine kantine;

    public static final int DAGEN = 7;
    private Artikel artikelen;
    /**
     * Constructor
     */
    public KantineSimulatie1() {
        kantine = new Kantine();

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
        KantineSimulatie2 sim = new KantineSimulatie2();
        sim.simuleer(dagen);
    }
}
