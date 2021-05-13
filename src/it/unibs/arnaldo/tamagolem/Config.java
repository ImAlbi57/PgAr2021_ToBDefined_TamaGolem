package it.unibs.arnaldo.tamagolem;

import java.util.ArrayList;

public class Config {
    private static ArrayList<TipoElemento> magazzino;
    private static int NUM_ELEMENTI;
    private static int NUM_PIETRE;
    private static int NUM_GOLEM;
    private static int MAX_POTENZA;


    //Imposta i valori calcolati dal numero di elementi
    public static void init(int numElementi){
        NUM_ELEMENTI = numElementi;
        NUM_PIETRE =  (int) (Math.ceil( (double) (NUM_ELEMENTI + 1) / 3) + 1);
        NUM_GOLEM = (int) Math.ceil( (double) (NUM_ELEMENTI-1)*(NUM_ELEMENTI-2)/(2*NUM_PIETRE));
        MAX_POTENZA = numElementi-1;

        magazzino = new ArrayList<>();
    }

    private static void init_magazzino(){
        //magazzino.add()
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
    public static int getMaxPotenza() {
        return MAX_POTENZA;
    }

    public static String toStr() {
        return Config.getNumElementi() + " " + Config.getNumGolem() + " " + Config.getNumPietre();
    }
}
