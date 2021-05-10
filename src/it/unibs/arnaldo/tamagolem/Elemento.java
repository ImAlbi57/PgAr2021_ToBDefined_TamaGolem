package it.unibs.arnaldo.tamagolem;

public class Elemento {
    private String name;
    private int sumMax;
    private int sumEnt;
    private int sumUsc;

    public Elemento(String name){
        this.name = name;
        sumEnt = 0;
        sumUsc = 0;
    }

    public void setSumEnt(int sumEnt) {
        this.sumEnt = sumEnt;
    }
    public void setSumUsc(int sumUsc) {
        this.sumUsc = sumUsc;
    }
    public void setSumMax(int sumMax) {
        this.sumMax = sumMax;
    }

    public String getName() {
        return name;
    }
    public int getSumAct() {
        return sumEnt+sumUsc;
    }
    public int getSumEnt() {
        return sumEnt;
    }
    public int getSumUsc() {
        return sumUsc;
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
