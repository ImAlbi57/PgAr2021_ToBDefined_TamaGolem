package it.unibs.arnaldo.tamagolem;

import it.unibs.fp.mylib.InputDati;

import java.util.ArrayList;

public class Scontro {

    private Giocatore player1;
    private Giocatore player2;
    private Equilibrio eq;
    private ArrayList<TipoElemento> magazzino;


    public Scontro(String player1, String player2, int nElementi) {
        this.player1 = new Giocatore(player1);
        this.player2 = new Giocatore(player2);
        this.eq = new Equilibrio(nElementi);
        this.magazzino = new ArrayList<>();
        Config.init(nElementi);
    }

    public Giocatore getPlayer1() {
        return player1;
    }

    public Giocatore getPlayer2() {
        return player2;
    }


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
    /*String giocatore1 = InputDati.leggiStringa("Inserisci il nome del giocatore");
    String giocatore2 = InputDati.leggiStringa("Inserisci il nome del giocatore");*/





}
