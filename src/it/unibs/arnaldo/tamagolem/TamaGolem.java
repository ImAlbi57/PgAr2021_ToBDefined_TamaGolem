package it.unibs.arnaldo.tamagolem;

import java.util.ArrayList;

public class TamaGolem {
    private String nome;
    private ArrayList<TipoElemento> pietre;
    private boolean usato;
    private int vita;

    public TamaGolem(String nome) {
        this.usato = false;
        this.nome = nome;
        pietre = new ArrayList<>();
    }

    public boolean isUsato(){
        return this.usato;
    }

    public String getNome() {
        return nome;
    }

    public int getVita() {
        return vita;
    }

    public void setUsato(boolean usato) {
        this.usato = usato;
    }

    public void setVita(int vita) {
        this.vita = vita;
    }

    public void setPietre(ArrayList<TipoElemento> pietre){
        pietre = new ArrayList<>(pietre);
    }

    public ArrayList<TipoElemento> getPietre() {
        return pietre;
    }

    public TipoElemento getPietra(int index){
        return pietre.get(index);
    }

    public String toString(){
        return this.nome;
    }
}
