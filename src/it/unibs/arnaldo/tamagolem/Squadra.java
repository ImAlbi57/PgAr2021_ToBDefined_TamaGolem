package it.unibs.arnaldo.tamagolem;

import it.unibs.fp.mylib.InputDati;
import java.util.ArrayList;

public class Squadra {

    //inizializzo le variabili
    private String nome;
    private ArrayList<TamaGolem> tamagolems;
    private final double NUM_ELEMENTI = 5;
    private final double NUM_PIETRE = NumPietre(NUM_ELEMENTI);
    private final double NUM_GOLEM = NumGolem(NUM_ELEMENTI, NUM_PIETRE);

    //VOLEVO CREARE HASHMAP CON NOME GIOCATORE E ARRAYLIST DI TAMAGOLEM....

    //costruttore della squadra
    public Squadra(String nome, ArrayList<TamaGolem> tamagolems) {
        this.nome = nome = ValidateName();
        this.tamagolems = tamagolems;
    }

    public Squadra() {
        this.nome = ValidateName();
//		this.tamagolems = tamagolems;
    }


    //GETTERS
    public String getNome() {
        return nome;
    }

    public ArrayList<TamaGolem> getTamagolems() {
        return tamagolems;
    }

    public double getNUM_ELEMENTI() {
        return NUM_ELEMENTI;
    }

    public double getNUM_PIETRE() {
        return NUM_PIETRE;
    }

    public double getNUM_GOLEM() {
        return NUM_GOLEM;
    }


    //metodo per calcolare il numero di pietre che può tenere ogni tamagolem
    public double NumPietre(double num_elementi){
        double num_pietre;

        //calcolo ilnumero di pietre
        num_pietre = Math.ceil((num_elementi + 1) / 3) + 1;

        return num_pietre;
    }


    //metodo per calcolare il numero di tamagolem nell'arraylist
    public double NumGolem(double num_elementi, double num_pietre){
        double numGolem;
        num_pietre = NumPietre(num_elementi);

        //calcolo il numero di golem
        numGolem = Math.ceil((num_elementi-1)*(num_elementi-2)/(2*num_pietre));

        return numGolem;
    }


    ////////////////////////////////////////////////////////////////////////
    //////DA AGGIUSTARE: SEMBRA CHE NON MANTENGA IL VALORE INSERITO.////////
    ArrayList<String> nomi = new ArrayList<>();
    public String ValidateName(){
        //inizializzo l'indice come se fosse corretto
        int index = 0;

        //ciclo while per ripetere l'azione finchè non si inserisce un nome mai utilizzato
        while(index != -1) {
            //inserimento del nome
            String nome = InputDati.leggiStringaNonVuota(TamaMessage.getMessNome()).toUpperCase();
            nomi.add(nome);

            //ricerca del nome nell'arraylist
            if(nomi.size()==1) return nome;

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
    }


    //Getter, ritorna un tamagotchi dato l'indice
    public String getNome(int index) {
        return nomi.get(index);
    }

    public void PrintProva() {
        for(String str : nomi) {
            System.out.println(str);
        }
    }

}