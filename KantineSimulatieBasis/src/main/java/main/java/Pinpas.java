package main.java;

public class Pinpas extends Betaalwijze {

    private double kredietlimiet;

    /**
     * Methode om kredietlimiet te zetten
     *
     * @param kredietlimiet
     */
    public void setKredietLimiet(double kredietlimiet) {
        // method body omitted
    }

    /**
     * Methode om betaling af te handelen
     */
    public void betaal(double tebetalen) throws TeWeinigGeldExeption {
        if (kredietlimiet <= (saldo - tebetalen)){
            saldo -= tebetalen;
        } else {
            throw new TeWeinigGeldExeption("Error: Te weinig saldo");
        }

    }
}
