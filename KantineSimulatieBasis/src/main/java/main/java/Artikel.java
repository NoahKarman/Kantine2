package main.java;
/**
 * Een Artikel klasse
 *
 * @author Noah Karman & Redouan Klick
 * @version 15/5/2020
 */

public class Artikel {

    private String naam;
    private int prijs;


    /**
     * Artikel constructor
     *
     * @param naam De naam van het artikel
     * @param prijs De prijs van het artikel
     */

    public Artikel (String naam, int prijs) {

        this.naam = naam;
        this.prijs = prijs;
    }

    /**
     * 2e Artikel constructor
     *
     * (parameterloos)
     */

    public Artikel () {

        String naam = getNaam();
        int prijs = getPrijs();
    }

    /**
     * Stel de naam van het artikel in
     *
     * @param naam - de naam van het artikel
     */

    public void setNaam(String naam) {
        this.naam = naam;
    }

    /**
     * Stel de prijs van het artikel in
     *
     * @param prijs - de prijs van het artikel
     */

    public void setPrijs(int prijs) {

        this.prijs = prijs;
    }

    /**
     * Vraag de prijs van het artikel op
     *
     * @return - prijs de prijs van het artikel
     */

    public int getPrijs() {
        return prijs;
    }

    /**
     * Vraag de naam van het artikel op
     *
     * @return - de naam van het artikel
     */

    public String getNaam() {
        return naam;
    }

}
