package main.java;
public class Administratie {

    private static final int DAYS_IN_WEEK = 7;


private Administratie(){

}
    /**
     * Deze methode berekent van de int array aantal de gemiddelde waarde
     *
     * @param aantal
     */
    public static void berekenGemiddeldAantal(int[] aantal) {
        // method body omitted
        aantal = new int[] {45, 56, 34, 39, 40, 31};
        int count =0;
        for (int i=0;i<aantal.length -1;++i){

            count += aantal[i];
    }
    int average = count/aantal.length;
        System.out.println(average);

    }

    /**
     * Deze methode berekent van de double array omzet de gemiddelde waarde
     *
     * @param omzet
     */
//    public static void main(String[] args) {
//        berekenGemiddeldAantal();
//    }

    public void berekenGemiddeldeOmzet(double[] omzet) {
        // method body omitted
        omzet = new double[] {567.70,498.25,458.90};
        double count =0;
        for (int i=0;i<omzet.length -1;++i){

            count += omzet[i];
        }
        double average = count/omzet.length;
        System.out.println(average);
    }

    /**
     * Methode om dagomzet uit te rekenen
     *
     * @param omzet
     * @return array (7 elementen) met dagomzetten
     */

    public static double[] berekenDagOmzet(double[] omzet) {
        double[] temp = new double[7];
        for(int i = 0; i < 7; i++) {

            int j = 0;
            while (j < 7) {

                temp[i] += omzet[i + 7 * j];
                j++;

                // omitted

            }
        }
        return temp;
    }
}
