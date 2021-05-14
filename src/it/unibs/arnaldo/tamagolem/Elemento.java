package it.unibs.arnaldo.tamagolem;

/***
 * Classe per gestire gli elementi dell'equilibrio
 * @author ToBdefined
 */
public class Elemento {

    //attributi
    private TipoElemento tipo;
    private int sumAct;

    /***
     *Costruttore di elemento
     * @param tipo
     */
    public Elemento(TipoElemento tipo){
        this.tipo = tipo;
        this.sumAct = 0;
    }


    //GETTERS
    /***
     *Getter del tipo di elemento
     * @return tipo elemento
     */
    public TipoElemento getTipo() {
        return tipo;
    }

    /***
     *Getter della somma attuale dei valori
     * @return somma dei valori
     */
    public int getSumAct() {
        return sumAct;
    }


    /***
     *Metodo per aggiungere un valore entrante
     * @param val
     */
    public void addValEnt(int val) {
        this.sumAct += val;
    }


    /***
     *Metodo per aggiungere un valore uscente
     * @param val
     */
    public void addValUsc(int val) {
        this.sumAct -= val;
    }

//DA RIVEDERE
    /***
     *Metodo per visualizzare se un oggetto e' stato gia inserito oppure no
     * @param obj
     * @return true se un oggetto e' uguale ad un oggetto gia' presente oppure false
     */
    @Override
    public boolean equals(Object obj) {
        // self check
        if (this == obj)
            return true;
        // null check
        if (obj == null)
            return false;
        // type check and cast
        if (getClass() != obj.getClass())
            return false;
        Elemento elemento = (Elemento) obj;
        // field comparison
        return tipo.equals(elemento.getTipo());
    }
}
