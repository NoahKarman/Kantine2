package main.java;

public class Contant extends Betaalwijze {
    /**
     * Methode om betaling af te handelen
     */
    public void betaal(double tebetalen) throws TeWeinigGeldExeption {
        if (saldo >= tebetalen){
            saldo -= tebetalen;
        } else {
            throw new TeWeinigGeldExeption("Error: Te weinig saldo");
        }

    }
}
