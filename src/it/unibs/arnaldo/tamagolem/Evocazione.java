package it.unibs.arnaldo.tamagolem;

public class Evocazione {

    private int tamaPlay1;
    private int tamaPlay2;
    private int vitaTamagolem;

    public Evocazione(int tamaPlay1, int tamaPlay2, int vitaTamagolem) {
        this.tamaPlay1 = tamaPlay1;
        this.tamaPlay2 = tamaPlay2;
        this.vitaTamagolem = vitaTamagolem;
    }

    public int getTamaPlay1() {
        return tamaPlay1;
    }

    public int getTamaPlay2() {
        return tamaPlay2;
    }

    public int getVitaTamagolem() {
        return vitaTamagolem;
    }

    public void evocaTama() {

        int maxPower;
        if (tamaPlay1 > 0) {
            System.out.println("Il giocatore 1 puo' evocare il suo TamaGolem");



        } else{
            System.out.println("Il giocatore non possiede Tamagolem, non puo' partecipare allo scontro");
        }

        if (tamaPlay2 > 0) {
            System.out.println("Il giocatore 1 puo' evocare il suo TamaGolem");
        } else{
            System.out.println("Il giocatore non possiede Tamagolem, non puo' partecipare allo scontro");
        }

    }

}

