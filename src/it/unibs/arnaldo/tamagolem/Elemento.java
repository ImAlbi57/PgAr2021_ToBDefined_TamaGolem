package it.unibs.arnaldo.tamagolem;

/***
 * Classe per fare qualcosa
 * @author ToBdefined
 */
public class Elemento {

    //variabili
    private TipoElemento tipo;
    private int sumMax;
    private int sumAct;
    private int nArchiRim;


    //GETTERS
    /***
     *
     * @return
     */
    public TipoElemento getTipo() {
        return tipo;
    }

    /***
     *
     * @return
     */
    public int getSumAct() {
        return sumAct;
    }

    /***
     *
     * @return
     */
    public int getSumMax() {
        return sumMax;
    }


    //SETTERS
    /***
     *
     * @param sumMax
     */
    public void setSumMax(int sumMax) {
        this.sumMax = sumMax;
    }


    /***
     *
     * @param tipo
     * @param nArchiTot
     */
    public Elemento(TipoElemento tipo, int nArchiTot){
        this.tipo = tipo;
        this.sumAct = 0;
        this.nArchiRim = nArchiTot;
    }


    /***
     *
     * @param val
     */
    public void addValEnt(int val) {
        this.sumAct += val;
        nArchiRim--;
    }


    /***
     *
     * @param val
     */
    public void addValUsc(int val) {
        this.sumAct -= val;
        nArchiRim--;
    }


    /***
     *
     * @param obj
     * @return
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
