package main.java;

/**
 * Een Persoon klasse
 * 
 * @author Redouan Klick & Noah Karman
 * @version 15/5/2020
 * 
 */
public class Persoon {
    
    private long BSN;
    private String voornaam;
    private String achternaam;
    private Datum geboortedatum;
    private char geslacht;

    /**
     * Constructor voor de klasse Persoon
     * 
     * @param BSN - de BSN van de persoon
     * @param voornaam - de voornaam van de persoon
     * @param achternaam - de achternaam van de persoon
     * @param geboortedatum - de geboortedatum van de persoon
     * @param geslacht - het geslacht van de persoon
     */


    public Persoon(long BSN, String voornaam, String achternaam, Datum geboortedatum, char geslacht) {

        this.BSN = BSN;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
        this.geslacht = geslacht;
    }

    public Persoon() {
        this.BSN = 0;
        voornaam = "";
        achternaam = "";
        geboortedatum = null;
        geslacht = 'O';
    }

    /**
     * Stel de BSN van de persoon in
     * @param BSN - De BSN van de persoon
     */
    public void setBSN(long BSN) {

        this.BSN = BSN;
    } 

    /**
     * Stel de voornaam van de persoon in
     * @param Voornaam = De voornaam van de persoon
     */
    public void setVoornaam (String Voornaam) {

        this.voornaam = Voornaam;
    }

    /**
     * Stel de achternaam van de persoon in
     * @param Achternaam - Achternaam van de persoon
     */
    public void setAchternaam (String Achternaam) {

        this.achternaam = Achternaam;
    }

    /**
     * Stel de geboortedatum van de persoon in
     *@param Geboortedatum - De geboortedatum van de persoon 
     */
    public void setGeboortedatum (Datum Geboortedatum) {

        this.geboortedatum = Geboortedatum;
    }

    /**
     * Stel het geslacht van de persoon in
     * @param Geslacht - het geslacht van de persoon
     */
    public void setGeslacht (char Geslacht) {

        if (Geslacht == ('M'|'V')) {
            this.geslacht = Geslacht;
        } else this.geslacht = 'O';
    }

    /**
     * Getter voor BSN
     * @return BSN
     */
    public long getBSN() {
        return BSN;
    }

    /**
     * Getter voor Voornaam
     * @return Voornaam
     */
    public String getVoornaam() {
        return voornaam;
    }

    /**
     * Getter voor Achternaam
     * @return Achternaam
     */
    public String getAchternaam() {
        return achternaam;
    }

    /**
     * Getter voor Geboortedatum
     * @return Geboortedatum
     */
    public Datum getGeboortedatum() {
        return geboortedatum;
    }

    /**
     * Getter voor Geslacht
     * @return Geslacht
     */
    public String getGeslacht() {

        if (geslacht == 'M') {
            return "Man";
        } else if (geslacht == 'V') {
            return "Vrouw";
        } else {
            return "Onbekend";
        }
    }
}