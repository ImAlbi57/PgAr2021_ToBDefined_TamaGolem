package it.unibs.arnaldo.tamagolem;

import it.unibs.fp.mylib.InputDati;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Scontro {

    private Giocatore player1;
    private Giocatore player2;
    private TamaGolem tamaP1;
    private TamaGolem tamaP2;
    private Equilibrio eq;
    private HashMap<TipoElemento, Integer> magazzino;


    public Scontro(String player1, String player2, int nElementi) {
        this.player1 = new Giocatore(player1);
        this.player2 = new Giocatore(player2);
        this.eq = new Equilibrio(nElementi);

        Config.init(nElementi);
        this.magazzino = creaMagazzino();
    }

    private HashMap<TipoElemento, Integer> creaMagazzino(){
        HashMap<TipoElemento, Integer> magazzino = new HashMap<>();
        TipoElemento[] possibili = eq.getTipiDisponibili();

        for (TipoElemento tipoElemento : possibili) {
            magazzino.put(tipoElemento, Config.getNumPietre());
        }

        return magazzino;
    }

    public int getNumeroPietre(TipoElemento elem){
        return magazzino.get(elem);
    }

    public int prelevaPietre(TipoElemento elem, int nPietre) {
        if (!magazzino.containsKey(elem))
            return -1;
        int pietreAttuali = magazzino.get(elem);
        if (pietreAttuali < nPietre)
            return -1;
        else
            magazzino.replace(elem, pietreAttuali - nPietre);
        return 0;
    }

    public void gioca(){
        //Controllo se ho tutto il necessario


        //Determino chi va primo, faccio un rand e se è true scambio i giocatori
        Random rand = new Random();
        if(rand.nextBoolean()){
            Giocatore app;
            app = new Giocatore(player1);
            player1 = new Giocatore(player2);
            player2 = app;
        }

        //Evocazione
        tamaP1 = evoca(player1);
        tamaP2 = evoca(player2);

        //Inizia lo scontro
        int round = 0;
        int vittoria = 0;

        while(vittoria == 0){
            if(tamaP1 == null)
                tamaP1 = evoca(player1);
            if(tamaP2 == null)
                tamaP2 = evoca(player2);


            //Interazione tra pietre, determino il danno e lo assegno
            TipoElemento el1 = tamaP1.getPietra(round % Config.getNumPietre());
            TipoElemento el2 = tamaP2.getPietra(round % Config.getNumPietre());
            int potenza = eq.getPotenza(el1,el2);

            //Controllo le potenze
            //Se è uguale a 0, l'interazione è nulla
            if(potenza == 0)
                System.out.println("Non ha effetto");

            //Se è maggiore di 0, allora p1 prevale su p2, p2 subisce danno, altrimenti viceversa
            if(potenza>0)
                tamaP2 = gestisciDanni(tamaP2, potenza);
            else
                tamaP1 = gestisciDanni(tamaP1, potenza);

            //check vittoria
            vittoria = checkVittoria();
            round++;
        }

        //Stampa chi ha vinto



    }

    private TamaGolem evoca(Giocatore player) {
        //Seleziono un tamagolem
        TamaGolem tama = player.selectTamagolem();
        //Se è null esco
        if(tama == null)
            return null;

        //Gli imposto la vita al massimo
        tama.setVita(Config.getMaxPotenza());

        //Input pietre (rimuovi dal magazzino)
        tama.setPietre(inputPietre());

        return tama;
    }

    private ArrayList<TipoElemento> inputPietre() {
        int qtScelte = 0;
        ArrayList<TipoElemento> scelte = new ArrayList<>();

        System.out.println("Scegli le pietre da dare al tuo tamagolem");
        TipoElemento[] possibili = eq.getTipiDisponibili();

        while(qtScelte < Config.getNumPietre()){
            System.out.print("Pietre possibili: ");
            for(int i = 0; i < possibili.length; i++){
                System.out.println("("+i+")" + possibili[i] + ": " + getNumeroPietre(possibili[i]));
            }
            int tipo = InputDati.leggiIntero("Scelta: ",0,possibili.length-1);
            int qt = InputDati.leggiIntero("Quante ne vuoi? ", 0, getNumeroPietre(possibili[tipo]));

            if(qtScelte+qt <= Config.getNumPietre()){
                prelevaPietre(possibili[tipo], qt);
                qtScelte+=qt;
                while(qt>0){
                    scelte.add(possibili[tipo]);
                    qt--;
                }
            }
            else
                System.out.println("Il numero selezionato supera il numero massimo di pietre per il tuo Tamagolem");
        }
        return scelte;
    }

    private TamaGolem gestisciDanni(TamaGolem subente, int potenza) {
        subente.setVita(subente.getVita()- potenza);

        //check morte
        if(subente.getVita() <= 0){
            //rimuovo il tamagochi e rimetto nel magazzino le pietre
            riponiPietre(subente.getPietre());
            subente = null;
        }
        //se vivo, riporto i danni e si prosegue
        else
            System.out.println(subente.getNome() + " ha subito " + potenza + " danni, ora ha " + subente.getVita() +  " HP");

        return subente;
    }

    private void riponiPietre(ArrayList<TipoElemento> pietre) {
        for (TipoElemento pietra : pietre) {
            magazzino.replace(pietra, magazzino.get(pietra)+1);
        }
    }

    private int checkVittoria() {
        //Controllo se hanno almeno un tamagolem vivo
        boolean p1 = player1.hasTamagolem();
        boolean p2 = player2.hasTamagolem();

        //Se p1 non ha tamagolem ritorno 2 (che ha vinto), se p2 non ha tamagolem ritorno 1
        //Altrimenti ritorno 0
        if(!p1)
            return 2;
        if(!p2)
            return 1;

        return 0;
    }




    public Giocatore getPlayer1() {
        return player1;
    }

    public Giocatore getPlayer2() {
        return player2;
    }

    /*
    //////////////////aggiunte per testare l input dei nomi

    private String nome1;
    private String nome2;
    private Giocatore giocatore1;
    private Giocatore giocatore2;
    //costruttore random
    public Scontro() {

    }

    //metodo per impedire che i due nomi corrispondano
    public void SceltaNome() {
        do{
            nome1 = InputDati.leggiStringa("Inserisci il nome del giocatore1: ").toUpperCase().trim();
            nome2 = InputDati.leggiStringa("Inserisci il nome del giocatore2: ").toUpperCase().trim();

            if(nome1.equals(nome2)) {
                System.out.println("\r\nI nomi dei due giocatori non possono essere uguali\r\n");
            }
        }while (nome1.equals(nome2));

        giocatore1 = new Giocatore(nome1);
        giocatore2 = new Giocatore(nome2);
    }
    String giocatore1 = InputDati.leggiStringa("Inserisci il nome del giocatore");
    String giocatore2 = InputDati.leggiStringa("Inserisci il nome del giocatore");*/
}
