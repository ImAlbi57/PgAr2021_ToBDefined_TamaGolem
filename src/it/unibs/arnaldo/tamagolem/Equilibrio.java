package it.unibs.arnaldo.tamagolem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Equilibrio {
    private ArrayList<Elemento> elementi;
    private int [][] adiacenza;
    private int nElementi;

    public Equilibrio(int nElementi){
        this.nElementi = nElementi;
        this.elementi = new ArrayList<>();
        this.adiacenza = new int[nElementi][nElementi];
        initElementi(nElementi);
        initValues();
    }

    //aggiunge n elementi !!! verifica il valore di setsummax
    private void initElementi(int num){
        TipoElemento[] possibili = TipoElemento.values();
        for(int i=0; i<num; i++){
            Elemento e = new Elemento(possibili[i]);
            elementi.add(e);
        }
    }

    public void initValues(){
        for(int i = 0; i < nElementi-1; i++) {
            for (int j = 0; j < nElementi-1; j++) {
                //Se siamo su un elemento della diagonale (fuoco-fuoco, acqua-acqua) mettiamo a 0
                if (i == j)
                    adiacenza[i][j] = 0;
                    //Altrimenti (algoritmo)
                else {
                    //Controllo se il valore è già stato impostato
                    if (adiacenza[i][j] == 0 && adiacenza[j][i] == 0) {
                        //Se la somma attuale è maggiore di 0, allora è forte
                        //boolean forte = elementi.get(i).getSumAct() > 0;
                        boolean forte = elementi.get(i).getSumAct() > elementi.get(j).getSumAct();

                        if (forte) {
                            creaArcoPesato(i, j);
                        } else {
                            creaArcoPesato(j, i);
                        }
                    }
                }
            }
        }
        for (int j = 0; j < nElementi; j++) {
            int gap = elementi.get(j).getSumAct();
            adiacenza[nElementi-1][j] = -gap;
            adiacenza[j][nElementi-1] = gap;
            if(gap > 0){
                elementi.get(nElementi-1).addValUsc(gap);
                elementi.get(j).addValUsc(gap);
            }
            else{
                elementi.get(j).addValUsc(gap);
                elementi.get(nElementi-1).addValUsc(gap);
            }
        }
    }

    private void creaArcoPesato(int posForte, int posDebole) {
        //Imposto il forte a un valore random tra 1 e il massimo disponibile
        int peso = genPeso(posForte, posDebole);

        adiacenza[posForte][posDebole] = peso;
        elementi.get(posForte).addValUsc(peso);
        //Imposto il debole al negativo del peso
        adiacenza[posDebole][posForte] = -peso;
        elementi.get(posDebole).addValEnt(peso);
    }

    private int genPeso(int posForte, int posDebole) {
        Random rand = new Random();
        int maxRand = Config.getMaxPotenza();
        while(Math.abs(elementi.get(posForte).getSumAct() - maxRand) > Config.getMaxPotenza() ||
                Math.abs(elementi.get(posDebole).getSumAct() + maxRand) > Config.getMaxPotenza()){
            maxRand--;
        }
        int peso;
        do {
            peso = rand.nextInt(maxRand) + 1;
        }while (elementi.get(posForte).getSumAct() - peso == 0 ||
                elementi.get(posDebole).getSumAct() + peso == 0
        );
        return peso;
    }

    public boolean checkEquilibrio(){
        //Scorro tutti gli elementi, se trovo qualcosa non bilanciato ritorno falso, altrimenti in fondo ritorno true
        for(int i=0; i<nElementi; i++)
            if(elementi.get(i).getSumAct() != 0)
                    return false;
        return true;
    }

    public int sommatoriaMatrice(){
        int sum = 0;
        for (int i = 0; i < nElementi; i++) {
            for (int j = 0; j < nElementi; j++) {
                if(adiacenza[i][j] > 0)
                    sum += adiacenza[i][j];
            }
        }
        return sum;
    }

    public int getPotenza(TipoElemento attaccante, TipoElemento subente){
        int posAtk = getElementValue(attaccante);
        int posDef = getElementValue(subente);

        return adiacenza[posAtk][posDef];
    }

    public int getElementValue(TipoElemento e){
        return elementi.indexOf(new Elemento(e));
    }

    public TipoElemento[] getTipiDisponibili(){
        return Arrays.copyOf(TipoElemento.values(), Config.getNumElementi());
    }

    public void printCarino(){
        //Stampa lo slash
        System.out.print("/  ");
        //Stampa la riga con le iniziali e va a capo
        for(int i=0; i<nElementi; i++)
            System.out.print(elementi.get(i).getTipo().toString().charAt(0) + "  ");
        System.out.println();

        for(int i=0; i<nElementi; i++) {
            System.out.print("" + elementi.get(i).getTipo().toString().charAt(0));
            for(int j=0; j<nElementi; j++){
                System.out.printf("%3d", adiacenza[i][j]);
            }
            System.out.println();
        }
    }

    public void printPesiAttuali(){
        for (int i = 0; i < nElementi; i++) {
            System.out.println(elementi.get(i).getTipo() + " -> " + elementi.get(i).getSumAct());
        }
    }

    public void printPesiElem(){
        for (int i = 0; i < nElementi; i++) {
            System.out.print(elementi.get(i).getTipo() + " -> ");
            for (int j = 0; j < nElementi; j++) {
                if(i != j){
                    System.out.print(elementi.get(j).getTipo() + ": " + adiacenza[i][j] + ";  ");
                }
            }
            System.out.println();
        }
    }

    public void printAll(){
        for(int i = 0; i < nElementi; i++) {
            for(int j = 0; j < nElementi; j++){
                System.out.print(adiacenza[i][j] + " ");
            }
            System.out.println();
        }
    }

}