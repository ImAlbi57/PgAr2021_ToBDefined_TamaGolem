package it.unibs.arnaldo.tamagolem;

import it.unibs.fp.mylib.InputDati;

import java.util.ArrayList;

public class Giocatore {

    private String nome;
    private ArrayList<TamaGolem> tamagolems;

    //costruttore del giocatore
    public Giocatore(Giocatore g){
        this.nome = g.getNome();
        this.tamagolems = new ArrayList<>(g.getTamagolems());
    }

    public Giocatore(String nome, ArrayList<TamaGolem> tamagolems) {
        this.nome = nome;
        this.tamagolems = tamagolems;
    }

    public Giocatore(String nome) {
        this.nome = nome;
        this.tamagolems = new ArrayList<>();
    }

    public boolean hasTamagolem() {
        for(TamaGolem t : tamagolems){
            if(t.getVita()>0){
                return true;
            }
        }
        return false;
    }

    public void inputTama(){
        for (int i = 0; i < Config.getNumGolem(); i++) {
            String nome = InputDati.leggiStringaNonVuota("Inserisci il nome del Tamagolem: ");
            tamagolems.add(new TamaGolem(nome));
        }
    }

    //GETTERS
    public String getNome() {
        return nome;
    }

    public ArrayList<TamaGolem> getTamagolems() {
        return tamagolems;
    }


    public TamaGolem selectTamagolem() {
        //Controllo se sono presenti tamagolem
        if(tamagolems.size() <= 0)
            return null;

        //Prende in input dall'utente la posizione del golem (controlli)
        int posScelta = -1;
        boolean finito = false;
        //Stampa i tamagolem disponibili
        while(!finito){
            System.out.println("Scegli il tamagolem da evocare");
            stampaGolem();
            posScelta = InputDati.leggiIntero("Scelta: ", 0,tamagolems.size()-1);

            if(!tamagolems.get(posScelta).isUsato())
                finito = true;
        }

        //Imposto ad usato il tamagolem
        tamagolems.get(posScelta).setUsato(true);

        //Ritorno
        return tamagolems.get(posScelta);
    }

    private void stampaGolem(){
        for (int i = 0; i <tamagolems.size(); i++) {
            if(!tamagolems.get(i).isUsato())
                System.out.println("("+i+")" + tamagolems.get(i));
        }
    }


}