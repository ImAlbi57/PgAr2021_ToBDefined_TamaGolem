package it.unibs.arnaldo.tamagolem;

import it.unibs.fp.mylib.InputDati;

import java.util.Scanner;

/***
 * Classe main
 * @author ToBdefined
 */
public class Main {

    /***
     *Metodo main
     * @param args
     */
    public static void main(String[] args) {
        //richiamo il messaggio di benvenuto
        System.out.println(TamaMessage.SALUTO);

        //inizializzo le variabili
        int scelta;
        boolean blocca = true;
        Scontro partita = null;

        //comincio il ciclo do while con lo switch
        do {
            //assegno alla variabile il valore inserito da tastiera dopo aver mostrato il menu di scelta
            scelta = InputDati.leggiInteroNonNegativo(TamaMessage.MENU);

            switch(scelta) {
                //inizia una nuova partita
                case 1:
                    do {
                        //assegno alla variabile il valore inserito da tastiera dopo aver mostrato il menu di scelta
                        scelta = InputDati.leggiInteroNonNegativo(TamaMessage.MENU2);

                        switch(scelta) {
                            //scegli o modifica i nomi dei giocatori
                            case 1:
                                partita = inputScontro();
                                partita.gioca();
                                blocca = false;
                                break;

                            //comincia lo scontro
                            case 2: break;

                            //abbandona la partita
                            case 3: break;

                            //messaggio di errore per altri valori inseriti
                            default: System.out.println("Scelta non valida");
                        }


                    }while(scelta!=3);
                    break;
                //inizia una nuova partita con gli stessi dati
                case 2:
                    if(!blocca){
                        partita.rivincita();
                    }
                    else
                        System.out.println("Non puoi usare questa opzione finché non giochi almeno una volta");
                    break;
                //termina il programma
                case 0: break;

                //messaggio di errore per altri valori inseriti
                default: System.out.println("Scelta non valida");
            }

        }while(scelta != 0);
    }

    private static Scontro inputScontro(){
        String nome1 = InputDati.leggiStringa(TamaMessage.MESS_NOME);
        String nome2 = InputDati.leggiStringa(TamaMessage.MESS_NOME);
        while(nome1.equals(nome2)){
            nome2 = InputDati.leggiStringa(TamaMessage.MESS_NOME);
        }
        int nElementi = InputDati.leggiIntero(TamaMessage.NUMERO_ELEMENTI,3,10);
        return new Scontro(nome1, nome2, nElementi);
    }
}
