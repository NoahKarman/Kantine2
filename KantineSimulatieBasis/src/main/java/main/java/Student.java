package main.java;

/**
 * Een Student klasse
 *
 * @author Noah Karman & Redouan Klick
 * @version 5/6/2020
 */
public class Student extends Persoon{

    private long studentnummer;
    private String studierichting;

    /**
     * Contructor voor de klasse Student
     * @param BSN - het BSN van de Student
     * @param voornaam - de voornaam van de Student
     * @param achternaam - de achternaam van de Student
     * @param geboortedatum - de geboortedatum van de Student
     * @param geslacht - het geslacht van de Student
     * @param studentnummer - het studentnummer van de Student
     * @param studierichting - de studierichting van de Student
     */
    public Student(long BSN, String voornaam, String achternaam, Datum geboortedatum, char geslacht, long studentnummer, String studierichting) {

        super(BSN, voornaam, achternaam, geboortedatum, geslacht);
        this.studentnummer = studentnummer;
        this.studierichting = studierichting;
    }

    public Student() {
        studentnummer = 0;
        studierichting = null;
    }

    /**
     * Setter voor het studentnummer
     * @return het studentnummer
     */
    public long getStudentnummer() {
        return studentnummer;
    }

    /**
     * Setter voor de studierichting
     * @return de studierichting
     */
    public String getStudierichting() {
        return studierichting;
    }

    /**
     * Setter voor studentnummer
     * @param studentnummer - het studentnummer
     */
    public void setStudentnummer(long studentnummer) {
        this.studentnummer = studentnummer;
    }

    /**
     * Setter voor de studierichting
     * @param studierichting -  de studierichting
     */
    public void setStudierichting(String studierichting) {
        this.studierichting = studierichting;
    }
}
