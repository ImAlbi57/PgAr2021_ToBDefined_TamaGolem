package it.unibs.arnaldo.tamagolem;

public class Main {
    public static void main(String[] args) {
        System.out.println("Forse ho creato il progetto");
        Equilibrio eq = new Equilibrio(5);

        //System.out.println(eq.getMultiplier(new Elemento("ACQUA"), new Elemento("ACQUA")));
        //System.out.println(eq.getMultiplier(new Elemento("ACQUA"), new Elemento("FUOCO")));
        eq.printCarino();

        //eq.bilancia();
        //System.out.println("BILANCIATO");
        System.out.println(eq.checkEquilibrio());
        System.out.println(eq.sommatoriaMatrice());
        //eq.printPesiAttuali();
        eq.printPesiElem();

        /*
        Equilibrio eq2 = new Equilibrio(10);
        eq2.printCarino();
        System.out.println(eq2.checkEquilibrio());
        System.out.println(eq2.sommatoriaMatrice());
        eq2.printPesiElem();
        */

    }
}
