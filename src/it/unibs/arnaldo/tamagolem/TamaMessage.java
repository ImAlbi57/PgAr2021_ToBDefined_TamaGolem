package it.unibs.arnaldo.tamagolem;

/***
 * Classe per contenere gli output stringa costanti per tutto il programma
 * @author ToBdefined
 */
public class TamaMessage {

    //output iniziale del programma
    public static final String SALUTO =""
            + "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\r\n"
            + "║   Benvenuto nel mondo dei Tamagolem! :-)    ║ \r\n"
            + "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\r\n"
            + "\r\nLo scontro termina quando tutti i Tamagolem di uno dei giocatori non sono piu in grado di lottare.\r\n";


    //menu visualizzato dall'utente nel primo switch
    public static final String MENU = ""
            + "\r\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°"
            + "\r\n ➢ 1. Nuova Partita"
            + "\r\n ➢ 2. Rivincita"
            + "\r\n ➢ 0. Esci"
            + "\r\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°\r\n"
            + "\r\nScelta: ";


    //menu che verrà poi mostrato prima far inserire all'utente il valore della scelta del secondo switch
    public static final String MENU2 = ""
            + " ➢ 1. SCELTA NOMI"
            + "\r\n ➢ 2. SCONTRO"
            + "\r\n ➢ 3. FUGA"
            + "\r\n~~~~~~~~~~~~~~~~~~~~\r\n"
            + "\r\nScelta: ";

    //output per indicare all'utente che dato sta per inserire
    public static final String MESS_NOME = "INSERISCI IL NOME DEL GIOCATORE: ";
    public static final String NUMERO_ELEMENTI = ""
            + "Inserisci il numero di elementi con la quale vuoi giocare:\r\n"
            + "➢ Facile    [3-5]\r\n"
            + "➢ Medio     [6-8]\r\n"
            + "➢ Difficile [9-10]\r\n"
            + "~~~~~~~~~~~~~~~~~~~~\r\n"
            + "Scelta [3-10]: ";
}