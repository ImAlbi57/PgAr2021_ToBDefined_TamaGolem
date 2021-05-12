package it.unibs.arnaldo.tamagolem;

import it.unibs.fp.mylib.InputDati;

public class Scontro {

    private String player1;
    private String player2;


    public Scontro(String player1, String player2, int tamaPlay1, int tamaPlay2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }


    //////////////////aggiunte per testare l input dei nomi

    private String nome1;
    private String nome2;
    private Squadra squadra1;
    private Squadra squadra2;
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

        squadra1 = new Squadra(nome1);
        squadra2 = new Squadra(nome2);
    }
    /*String giocatore1 = InputDati.leggiStringa("Inserisci il nome del giocatore");
    String giocatore2 = InputDati.leggiStringa("Inserisci il nome del giocatore");*/





}
