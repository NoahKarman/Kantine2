package main.java;
        import main.java.Artikel;
        import main.java.Persoon;

        import java.util.*;
        import java.util.ArrayList;
/**
 * Een Dienblad klasse
 *
 * @author Noah Karman & Redouan Klick
 * @version 15/5/2020
 */
public class Dienblad {
    public Stack<Artikel> artikelen;
    private Artikel artikel;
    private Persoon persoon;
    private double totaalPrijs;
    private Persoon klant;
//    private HashMap<String,Artikel> artikelHashMap;
    /**
     * Constructor
     */
    public Dienblad() {

        totaalPrijs = 0;
        artikelen = new Stack<>();

    }
    /**
     * Constructor
     * @param klant - Het persoon die het dienblad afrekent
     */
    public Dienblad(Persoon klant){
        artikelen = new Stack<>();
        this.klant = klant;
    }

    /**
     * Methode om artikel aan dienblad toe te voegen
     *
     * @param artikel - De artikel die op de dienblad terecht komt
     */
    public void voegToe(Artikel artikel) {

        artikelen.push(artikel);

    }



    public void setKlant(Persoon klant) {
        this.klant = klant;
    }

    public Persoon getKlant() {
        return klant;
    }

    /**
     * Methode om aantal artikelen op dienblad te tellen
     *
     * @return Het aantal artikelen
     */
    public int getAantalArtikelen() {

        return artikelen.size();
    }

    /**
     * Stel het totale prijs in van het dienblad
     * @param totaalPrijs - het totale prijs van het dienblad
     */

    public void setTotaalPrijs(double totaalPrijs) {
        this.totaalPrijs = totaalPrijs;
        double roundOff = Math.round(totaalPrijs*100.0)/100.0;
        System.out.println(roundOff);
    }

    /**
     * Methode om de totaalprijs van de artikelen op dienblad uit te rekenen
     *
     * @return De totaalprijs
     */
    public double getTotaalPrijs() {

        for (Artikel artikel : artikelen) {
            this.totaalPrijs += artikel.getPrijs();
        } return this.totaalPrijs;
    }

    /**
     * Methode om door de arrayList te gaan van artikelen , waar als er een volgende artikel op de dienblad ligt
     * die ook pakt met de Iterator
     * @return De totaalprijs
     */

    public void getAllArtikel(){
        Iterator<Artikel> it = artikelen.iterator();
        while(it.hasNext()){
            Artikel a = it.next();
            System.out.println(a.getNaam());
            System.out.println(a.getPrijs());

        }
    }

//    public HashMap<String,Artikel> getArtikelenHashMap(){
//        System.out.println(artikelen.size());
//        Iterator<Artikel> it = artikelen.iterator();
//        while(it.hasNext()){
//            Artikel a = it.next();
//            artikelHashMap.put(a.getNaam(),a);
//
//        }
//        return artikelHashMap;
//    }
}

