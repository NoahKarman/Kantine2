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
    public static double berekenGemiddeldAantal(int[] aantal) {
        // method body omitted

        double   count =0;
        for (int i=0;i<aantal.length;++i){

            count += aantal[i];
    }
    double average = count/aantal.length;
        return  average;

    }

    /**
     * Deze methode berekent van de double array omzet de gemiddelde waarde
     *
     * @param omzet
     */
    public static void main(String[] args) {

        int []aantal = new int[] {45, 56, 34, 39, 40, 31};
        berekenGemiddeldAantal(aantal);
        double [] omzet = new double[] {567.70,498.25,458.90};

        berekenGemiddeldeOmzet(omzet);
        double[] dagOmzet = new double[]{321.35, 450.50, 210.45, 190.85, 193.25, 159.90, 214.25, 220.90, 201.90, 242.70, 260.35};
        double[] temp = berekenDagOmzet(dagOmzet);
        laatDagOmzetZien(temp);

    }

    public static double berekenGemiddeldeOmzet(double[] omzet) {
        // method body omitted

        double count =0;
        for (int i=0;i<omzet.length;++i){

            count += omzet[i];
        }
        double average = count/omzet.length;
        return average;
    }

    /**
     * Methode om dagomzet uit te rekenen
     *
     * @param omzet
     * @return array (7 elementen) met dagomzetten
     */

    public static double[] berekenDagOmzet(double[] omzet) {
        double[] temp = new double[DAYS_IN_WEEK];
        for(int i = 0; i < DAYS_IN_WEEK; i++) {

            int j = 0;
            while ((i + (DAYS_IN_WEEK * j)) < omzet.length  ) {

                temp[i] += omzet[i + DAYS_IN_WEEK * j];
                j++;

            }
        }
        return temp;
    }

    public static void laatDagOmzetZien (double [] temp){

        for (double omzet: temp) {
            double roundOff = Math.round(omzet*100.0)/100.0;
            System.out.println(roundOff);

        }
    }
}
