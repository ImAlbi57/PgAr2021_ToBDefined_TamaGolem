package it.unibs.arnaldo.tamagolem;

import it.unibs.fp.mylib.InputDati;

/***
 * Classe principale main
 * @author ToBdefined
 */
public class Main {

    /***
     *Metodo main
     * @param args
     */
    public static void main(String[] args) {
        //richiamo il messaggio di benvenuto
        System.out.println(TamaMessage.getSaluto());


        //inizializzo le variabili
        int scelta;

        //comincio il ciclo do while con lo switch
        do {
            //assegno alla variabile il valore inserito da tastiera dopo aver mostrato il menu di scelta
            scelta = InputDati.leggiInteroNonNegativo(TamaMessage.getMenu());

            switch(scelta) {
                //inizia una nuova partita
                case 1:
                    do {
                        //assegno alla variabile il valore inserito da tastiera dopo aver mostrato il menu di scelta
                        scelta = InputDati.leggiInteroNonNegativo(TamaMessage.getMenu2());

                        switch(scelta) {
                            //scegli o modifica i nomi dei giocatori
                            case 1:

                                break;

                            //comincia lo scontro
                            case 2: break;

                            //abbandona la partita
                            case 3: break;

                            //messaggio di errore per altri valori inseriti
                            default: System.out.println("Scelta non valida");
                        }


                    }while(scelta!=3);

                    //termina il programma
                case 0: break;

                //messaggio di errore per altri valori inseriti
                default: System.out.println("Scelta non valida");
            }

        }while(scelta != 0);
    }
}
