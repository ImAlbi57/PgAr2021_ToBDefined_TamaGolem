package it.unibs.arnaldo.tamagolem;

/***
 * Classe per contenere gli output stringa costanti per tutto il programma
 * @author ToBdefined
 */
public class TamaMessage {

    //output iniziale del programma
    private static final String SALUTO =""
            + "***********************************************\r\n"
            + "    Benvenuto nel mondo dei Tamagolem! :-) \r\n"
            + "***********************************************\r\n"
            + "\r\nRicordati che la vita di un tamagolem e' 5"
            + "\r\nLo scontro termina quando tutti i Tamagolem di uno dei giocatori non sono piu in grado di lottare.\r\n";


    //menu visualizzato dall'utente nel primo switch
    private static final String MENU = ""
            + "\r\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°"
            + "\r\n 1) Nuova Partita"
            + "\r\n 0) Esci"
            + "\r\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°\r\n"
            + "\r\nScelta: ";


    //menu che verrà poi mostrato prima far inserire all'utente il valore della scelta del secondo switch
    private static final String MENU2 = ""
            + " 1) SCELTA NOMI                           "
            + "\r\n 2) LOTTA                               "
            + "\r\n 3) FUGA    "
            + "\r\n//////////////////////////////////////////\r\n"
            + "\r\nScelta: ";

    //output per indicare all'utente che dato sta per inserire
    private static final String MESS_NOME = "INSERISCI IL NOME DEL GIOCATORE: ";


    //GETTERS

    /***
     * Getter della stringa visualizzata per inserire il nome del giocatore
     * @return MESS_NOME
     */
    public static String getMessNome() {
        return MESS_NOME;
    }

    /***
     * Getter della stringa visualizzata all'inizio del programma
     * @return SALUTO
     */
    public static String getSaluto() {
        return SALUTO;
    }

    /***
     * Getter della stringa visualizzata come primo menu
     * @return MENU
     */
    public static String getMenu() {
        return MENU;
    }

    /***
     * Getter della stringa visualizzata come secondo menu
     * @return MENU2
     */
    public static String getMenu2() {
        return MENU2;
    }



}