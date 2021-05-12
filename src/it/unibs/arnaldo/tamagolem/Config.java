package it.unibs.arnaldo.tamagolem;

public class Config {
    private static int NUM_ELEMENTI;
    private static int NUM_PIETRE;
    private static int NUM_GOLEM;

    //Imposta i valori calcolati dal numero di elementi
    public static void setConfig(int numElementi){
        NUM_ELEMENTI = numElementi;
        NUM_PIETRE =  (int) (Math.ceil( (double) (NUM_ELEMENTI + 1) / 3) + 1);
        NUM_GOLEM = (int) Math.ceil( (double) (NUM_ELEMENTI-1)*(NUM_ELEMENTI-2)/(2*NUM_PIETRE));
    }

    //Getters
    public static int getNumElementi() {
        return NUM_ELEMENTI;
    }
    public static int getNumPietre() {
        return NUM_PIETRE;
    }
    public static int getNumGolem() {
        return NUM_GOLEM;
    }
}
