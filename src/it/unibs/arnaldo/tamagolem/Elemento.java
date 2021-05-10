package it.unibs.arnaldo.tamagolem;

public class Elemento {
    private String name;
    private int sumMax;
    private int sumAct;
    private int nArchiRim;

    public Elemento(String name, int nArchiTot){
        this.name = name;
        this.sumAct = 0;
        this.nArchiRim = nArchiTot;
    }

    public void addValEnt(int val) {
        this.sumAct += val;
        nArchiRim--;
    }
    public void addValUsc(int val) {
        this.sumAct -= val;
        nArchiRim--;
    }
    public void setSumMax(int sumMax) {
        this.sumMax = sumMax;
    }

    public String getName() {
        return name;
    }
    public int getSumAct() {
        return sumAct;
    }
    public int getSumMax() {
        return sumMax;
    }

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
        return name.equals(elemento.getName());
    }
}
