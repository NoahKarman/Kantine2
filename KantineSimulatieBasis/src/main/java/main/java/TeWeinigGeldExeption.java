package main.java;

import org.w3c.dom.ls.LSOutput;

public class TeWeinigGeldExeption extends Exception{
    String error;

    public TeWeinigGeldExeption(){
        super("Error:te weinig saldo");
    }

    public TeWeinigGeldExeption(Exception e) {
        super(e);
    }

    public TeWeinigGeldExeption(String error){
        super(error);
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
