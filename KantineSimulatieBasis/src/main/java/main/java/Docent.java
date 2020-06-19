package main.java;

/**
 * Een Docent klasse
 *
 * @author Noah Karman & Redouan Klick
 * @version 5/6/2020
 */
public class Docent extends Persoon implements KortingskaartHouder {

    private String afkorting;
    private String afdeling;

    /**
     * Constructor voor de klasse Docent
     * @param BSN - het BSN van de Docent
     * @param voornaam - de voornaam van de Docent
     * @param achternaam - de achternaam van de Docent
     * @param geboortedatum - de geboortedatum van de Docent
     * @param geslacht - het geslacht van de Docent
     * @param afkorting - de afkorting van de Docent
     * @param afdeling - de afdeling van de Docent
     */
    public Docent(long BSN, String voornaam, String achternaam, Datum geboortedatum, char geslacht, String afkorting, String afdeling) {

        super(BSN, voornaam, achternaam, geboortedatum, geslacht);
        this.afkorting = afkorting;
        this.afdeling = afdeling;
    }

    public Docent() {
        afkorting = null;
        afdeling = null;
    }

    /**
     * Getter voor de afkorting
     * @return de afkorting
     */
    public String getAfkorting() {
        return afkorting;
    }

    /**
     * Getter voor de afdeling
     * @return de afdeling
     */
    public String getAfdeling() {
        return afdeling;
    }

    /**
     * Setter voor de afkorting
     * @param afkorting - de afkorting
     */
    public void setAfkorting(String afkorting) {
        this.afkorting = afkorting;
    }

    /**
     * Setter voor de afdeling
     * @param afdeling - de afdeling
     */
    public void setAfdeling(String afdeling) {
        this.afdeling = afdeling;
    }

    /**
     * Methode om kortingspercentage op te vragen
     */
    @Override
    public double geefKortingsPercentage() {
        return 25;
    }

    /**
     * Methode om op te vragen of er maximum per keer aan de korting zit
     */
    @Override
    public boolean heeftMaximum() {
        return true;
    }

    /**
     * Methode om het maximum kortingsbedrag op te vragen
     */
    @Override
    public double geefMaximum() {
        return 1;
    }
}
