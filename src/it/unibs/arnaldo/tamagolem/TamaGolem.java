package it.unibs.arnaldo.tamagolem;

import java.util.ArrayList;

/***
 * Classe per inizializzare il costruttore tamagolem
 */
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

    //GETTERS
    /***
     * Getter di pietre
     * @return pietre
     */
    public ArrayList<TipoElemento> getPietre() {
        return pietre;
    }

    /***
     * Metodo per ottenere una pietra tramite l'indice
     * @param index, cioe l'indice della pietra
     * @return pietre.get(index), cioe la pietra presente in quella posizione
     */
    public TipoElemento getPietra(int index){
        return pietre.get(index);
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
        this.pietre = new ArrayList<>(pietre);
    }

    public boolean isUsato(){
        return this.usato;
    }

    public String toString(){
        return this.nome;
    }
}
