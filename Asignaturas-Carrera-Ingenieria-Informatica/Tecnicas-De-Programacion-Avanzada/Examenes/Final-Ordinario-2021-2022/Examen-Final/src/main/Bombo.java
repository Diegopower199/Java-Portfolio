package main;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Bombo extends Thread {
    BomboNumeros numerosBombo;
    BomboPremios premiosBombo;
    public static AtributoEnum situacion;
    ArrayList<Integer> premios = new ArrayList<Integer>();
    ArrayList<Integer> numerosGanadores = new ArrayList<Integer>();
    private boolean continuar = true;

    public Bombo() {
        situacion = AtributoEnum.MEZCLANDO;

        try {
            Thread.sleep(1000);
            numerosBombo = new BomboNumeros();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        situacion = AtributoEnum.EROGANDO;

        try {
            Thread.sleep(1000);
            premiosBombo = new BomboPremios();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        numerosGanadores.add(numerosBombo.numeroIdentificador);
        premios.add(premiosBombo.numeroIdentificador);

    }

    @Override
    public void run() {
        int numeroAleatorio = 0;
        int numeroAleatorioPremio = 0;
        while (continuar) {
            situacion = AtributoEnum.MEZCLANDO;
            try {
                Thread.sleep(1000);
                numeroAleatorio = numerosBombo.numeroAleatorio();
                while (!numerosGanadores.contains(numeroAleatorio)) {
                    numeroAleatorio = numerosBombo.numeroAleatorio();
                    if (!numerosGanadores.contains(numeroAleatorio)) {
                        numerosGanadores.add(numeroAleatorio);
                        break;
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            situacion = AtributoEnum.EROGANDO;

            try {
                Thread.sleep(10000);
                numeroAleatorioPremio = premiosBombo.numeroAleatorio();
                while (!premios.contains(numeroAleatorio)) {
                    numeroAleatorioPremio = premiosBombo.numeroAleatorio();
                    if (!premios.contains(numeroAleatorio)) {
                        premios.add(numeroAleatorio);
                        break;
                    }
                }
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
            detenElHilo();
            System.out.println("La pareja premio/numero: " + numeroAleatorioPremio + "/" + numeroAleatorio);
        }

        mostrarPremios();

    }

    public void detenElHilo() {
        if (numerosGanadores.size() == 1200) {
            continuar = false;
        }

    }

    public void mostrarPremios() {

        for (int pos = 0; pos < numerosGanadores.size() - 1; pos++) {
            System.out.println("Salio la bola " + numerosGanadores.get(pos) + " con un premio de " + premios.get(pos));
            if (pos == 1199) {
                pos = 2000;
            }
        }

        escribirArchivo();
    }

    public void escribirArchivo() {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("resources/resultados.txt");
            pw = new PrintWriter(fichero);
            for (int i = 0; i < premios.size(); i++) {
                pw.print(premios.get(i) + " € - ");
                pw.println(numerosGanadores.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

}
