package it.unibs.arnaldo.tamagolem;

import java.util.ArrayList;

/***
 * Classe per configurare tutte le costanti ad ogni partita
 * @author ToBdefined
 */
public class Config {

    //inizializzazione arraylist della scorta di pietre
    private static ArrayList<TipoElemento> magazzino;

    //variabili
    private static int NUM_ELEMENTI;
    private static int NUM_PIETRE;
    private static int NUM_GOLEM;
    private static int MAX_POTENZA;

    /***
     * Metodo per inizializzare tutte le costanti del gioco inserendo il numero di elementi
     * @param numElementi, cioe il numero di elementi presenti nell'equilibrio del mondo
     */
    //Imposta i valori calcolati dal numero di elementi
    public static void init(int numElementi){
        NUM_ELEMENTI = numElementi;
        NUM_PIETRE =  (int) (Math.ceil( (double) (NUM_ELEMENTI + 1) / 3) + 1);
        NUM_GOLEM = (int) Math.ceil( (double) (NUM_ELEMENTI-1)*(NUM_ELEMENTI-2)/(2*NUM_PIETRE));
        MAX_POTENZA = numElementi-1;
    }

    //Getters
    /***
     * Getter della variabile num_elementi
     * @return NUM_ELEMENTI
     */
    public static int getNumElementi() {
        return NUM_ELEMENTI;
    }

    /***
     * Getter della variabile num_pietre
     * @return NUM_PIETRE
     */
    public static int getNumPietre() {
        return NUM_PIETRE;
    }

    /***
     * Getter della variabile num_golem
     * @return NUM_GOLEM
     */
    public static int getNumGolem() {
        return NUM_GOLEM;
    }

    /***
     * Getter della variabile max_potenza, ossia la vita del tamagolem
     * @return MAX_POTENZA
     */
    public static int getMaxPotenza() {
        return MAX_POTENZA;
    }


    /***
     * Metodo toString per informare del numero di pietre, elementi e golem presenti in questa partita
     * @return Stringa con i valori delle costanti di questa partita
     */
    public static String toStr() {
        return Config.getNumElementi() + " " + Config.getNumGolem() + " " + Config.getNumPietre();
    }
}
