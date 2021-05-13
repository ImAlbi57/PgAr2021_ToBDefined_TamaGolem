package it.unibs.arnaldo.tamagolem;

import it.unibs.fp.mylib.InputDati;

import java.util.ArrayList;

public class Giocatore {

    //inizializzo le variabili
    private String nome;
    private ArrayList<TamaGolem> tamagolems;

    //costruttore della squadra
    public Giocatore(String nome, ArrayList<TamaGolem> tamagolems) {
        this.nome = nome;
        this.tamagolems = tamagolems;
    }

    public Giocatore(String nome) {
        this.nome = nome;
        this.tamagolems = new ArrayList<>();
    }

    //GETTERS
    public String getNome() {
        return nome;
    }

    public ArrayList<TamaGolem> getTamagolems() {
        return tamagolems;
    }

    ////////////////////////////////////////////////////////////////////////
    //////DA AGGIUSTARE: SEMBRA CHE NON MANTENGA IL VALORE INSERITO.////////
    /*
    ArrayList<String> nomi = new ArrayList<>();
    public String ValidateName(){
        //inizializzo l'indice come se fosse corretto
        int index = 0;

        //ciclo while per ripetere l'azione finchè non si inserisce un nome mai utilizzato
        while(index != -1) {
            //inserimento del nome
            String nome = InputDati.leggiStringaNonVuota(TamaMessage.getMessNome()).toUpperCase();
            nomi.add(nome);

            //se è il primo nome inserito, allora è valido
            if(nomi.size()==1) return nome;

            //ricerca del nome nell'arraylist
            index = search(nome);

            //output se il nome è già stato scelto
            if(index != -1) {
                System.out.println("\r\nIl nome inserito è gia stato utilizzato per un altro tamagotchi."
                        + "\r\nSceglierne un altro.");
            }
            //output se il nome è nuovo
            else if(index == -1) return nome;
        }
        //ritorno vuoto per non far andare in errore il metodo
        return "";
    }


    public int search(String nome){
        //inizializzo la variabile indice come se fosse già in errore (non ci sono indici inferiori a 0 in un array)
        int index = -1;

        if(nomi.size() <= 1) return index;

        //ciclo for per passare in rassegna uno ad uno tutti gli oggetti tamagotchi contenuti nell'arraylist, si interrompe quando lo trova
        for(int i=0; i < nomi.size(); i++) {
            if(nome.equals(getNome(i))) {
                index = nomi.indexOf(nome);
                break;
            }
        }
        return index;
    }*/
}