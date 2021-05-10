package it.unibs.arnaldo.tamagolem;

public class Main {
    public static void main(String[] args) {
        System.out.println("Forse ho creato il progetto");
        Equilibrio eq = new Equilibrio(5);

        eq.printAll();

        //eq.bilancia();

        System.out.println("BILANCIATO");

        //System.out.println(eq.getMultiplier(new Elemento("ACQUA"), new Elemento("ACQUA")));
        //System.out.println(eq.getMultiplier(new Elemento("ACQUA"), new Elemento("FUOCO")));

    }
}
