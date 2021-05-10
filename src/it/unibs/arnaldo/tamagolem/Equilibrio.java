package it.unibs.arnaldo.tamagolem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Equilibrio {
    private ArrayList<Elemento> elementi;
    private int [][] adiacenza;
    private int nElementi;

    public Equilibrio(int nElementi){
        this.nElementi = nElementi;
        elementi = new ArrayList<>();
        adiacenza = new int[nElementi][nElementi];
        initElementi(nElementi);
        initValues();
    }

    //aggiunge n elementi !!! cambia il valore di setsummax
    private void initElementi(int num){
        String possibili[] = {"ARIA", "FUOCO", "TERRA", "ETERE", "ACQUA", "PIETRA", "BUIO"};
        for(int i=0; i<num; i++){
            Elemento e = new Elemento(possibili[i]);
            e.setSumMax(2*(nElementi+1));
            elementi.add(e);
        }
    }

    public void initValues(){
        Random rand = new Random();
        for(int i = 0; i < nElementi; i++){
            for (int j = 0; j < nElementi; j++) {
                //Se siamo su un elemento della diagonale (fuoco-fuoco, acqua-acqua) mettiamo a 0
                if(i==j)
                    adiacenza[i][j] = 0;
                //Altrimenti (algoritmo)
                else{
                    //Controllo se il valore è già stato impostato
                    if(adiacenza[i][j] == 0 && adiacenza[j][i] == 0){
                        //Scegliamo il forte/debole
                        boolean forte;
                        //Se la somma attuale è minore della somma massima del nodo estraiamo
                        if(elementi.get(i).getSumAct() < elementi.get(i).getSumMax())
                            forte = rand.nextBoolean();
                        //Altrimenti deve essere l'elemento forte
                        else
                            forte = true;

                        if(forte){
                            //Imposto il forte a un valore random tra 1 e il massimo disponibile
                            int maxRand;
                            int pesoMancante = elementi.get(i).getSumMax()-elementi.get(i).getSumAct();
                            if(pesoMancante > 0 && pesoMancante < 4)
                                maxRand = pesoMancante;
                            else maxRand = 4;
                            int peso = rand.nextInt(maxRand) + 1;
                            adiacenza[i][j] = peso;
                            elementi.get(i).setSumUsc(elementi.get(i).getSumUsc() + peso);
                            //Imposto il debole a 0
                            adiacenza[j][i] = 0;
                            elementi.get(j).setSumEnt(elementi.get(j).getSumEnt() + peso);
                        }
                        else{
                            //Imposto il forte a un valore random tra 1 e il massimo disponibile
                            int maxRand;
                            int pesoMancante = elementi.get(j).getSumMax()-elementi.get(j).getSumAct();
                            if(pesoMancante > 0 && pesoMancante < 4)
                                maxRand = pesoMancante;
                            else maxRand = 4;
                            int peso = rand.nextInt(maxRand) + 1;
                            adiacenza[j][i] = peso;
                            elementi.get(j).setSumUsc(elementi.get(j).getSumUsc() + peso);
                            //Imposto il debole a 0
                            adiacenza[i][j] = 0;
                            elementi.get(i).setSumEnt(elementi.get(i).getSumEnt() + peso);
                        }
                    }
                }
            }
        }
    }
    /*
    public void bilancia(){
        //Continuo finché non è bilanciato
        while(!checkEquilibrio()){
            //Scorro gli elementi
            for(int i=0; i<nElementi; i++){
                //Se l'elemento non è bilanciato
                if(elementi.get(i).getSumEnt() != elementi.get(i).getSumUsc()){
                    //Se i pesi entranti superano gli uscenti allora cerco un entrante non bilanciato e lo abbasso
                    if(elementi.get(i).getSumEnt() > elementi.get(i).getSumUsc()){
                        int pos = -1;
                        for (int j = 0; j < nElementi; j++) {
                            if(elementi.get(j).getSumEnt() != elementi.get(j).getSumUsc()){
                                pos = j;
                                break;
                            }
                        }
                        //Se lo trovo, abbasso il peso
                        if(pos != -1 && adiacenza[i][pos]>1){
                            adiacenza[i][pos]--;
                        }
                    }
                }
            }
        }
    }*/

    public boolean checkEquilibrio(){
        //Scorro tutti gli elementi, se trovo qualcosa non bilanciato ritorno falso, altrimenti in fondo ritorno true
        for(int i=0; i<nElementi; i++)
            if(elementi.get(i).getSumEnt() != elementi.get(i).getSumUsc())
                    return false;
        return true;
    }

    public int getMultiplier(Elemento attaccante, Elemento subente){
        int posAtk = getElementValue(attaccante);
        int posDef = getElementValue(subente);

        return adiacenza[posAtk][posDef];
    }

    public int getElementValue(Elemento e){
        return elementi.indexOf(e);
    }

    public void printCarino(){
        System.out.println("/ A F T E A");
        for(int i=0; i<nElementi; i++) {
            System.out.print("" + elementi.get(i).getName().charAt(0) + " ");
            for(int j=0; j<nElementi; j++){
                System.out.print(adiacenza[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printAll(){
        for(int i=0; i<nElementi; i++) {
            for(int j=0; j<nElementi; j++){
                System.out.print(adiacenza[i][j] + " ");
            }
            System.out.println();
        }
    }

}