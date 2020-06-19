package main.java;

/**
 * Een KantineMedewerker klass
 *
 * @author Noah Karman & Redouan Klick
 * @version 5/6/2020
 */
public class KantineMedewerker extends Persoon implements KortingskaartHouder{

    private int medewerkersnummer;
    private boolean kassastatus;

    /**
     * Constructor voor de klasse KantineMedewerker
     * @param BSN - het BSN van de KantineMedewerker
     * @param voornaam - de voornaam van de KantineMedewerker
     * @param achternaam - de achternaam van de KantineMedewerker
     * @param geboortedatum - de geboortedatum van de KantineMedewerker
     * @param geslacht - het geslacht van de KantineMedewerker
     * @param medewerkersnummer - het medewerkersnummer van de KantineMedewerker
     * @param kassastatus - de kassastatus van de KantineMedewerker
     */
    public KantineMedewerker(long BSN, String voornaam, String achternaam, Datum geboortedatum, char geslacht, int medewerkersnummer, boolean kassastatus) {

        super(BSN, voornaam, achternaam, geboortedatum, geslacht);
        this.medewerkersnummer = medewerkersnummer;
        this.kassastatus = kassastatus;
    }

    public KantineMedewerker() {
        medewerkersnummer = 0;
        kassastatus = false;
    }

    /**
     * Getter voor het medewerkersnummer
     * @return het medwerkersnummer
     */
    public int getMedewerkersnummer() {
        return medewerkersnummer;
    }

    /**
     * Getter voor de kassastatus
     * @return de kassastatus
     */
    public boolean isKassawaardig() {
        return kassastatus;
    }

    /**
     * Setter voor het medewerkersnummer
     * @param medewerkersnummer - het medewerkersnummer
     */
    public void setMedewerkersnummer(int medewerkersnummer) {
        this.medewerkersnummer = medewerkersnummer;
    }

    /**
     * Setter voor de kassastatus
     * @param kassastatus - de kassastatus
     */
    public void setKassawaardig(boolean kassastatus) {
        this.kassastatus = kassastatus;
    }

    /**
     * Methode om kortingspercentage op te vragen
     */
    @Override
    public double geefKortingsPercentage() {
        return 35;
    }

    /**
     * Methode om op te vragen of er maximum per keer aan de korting zit
     */
    @Override
    public boolean heeftMaximum() {
        return false;
    }

    /**
     * Methode om het maximum kortingsbedrag op te vragen
     */
    @Override
    public double geefMaximum() {
        return 0;
    }
}
