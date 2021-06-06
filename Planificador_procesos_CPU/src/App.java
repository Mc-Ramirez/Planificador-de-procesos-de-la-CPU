import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Numero de procesos que realizará la CPU: ");
        int numeroProcesos = entrada.nextInt();
        Proceso proceso = new Proceso(numeroProcesos);
        // proceso.iniciaConjuntoDatos();

        int columnas = 0;
        int filas = numeroProcesos;

        for (Map.Entry<String, Map<Integer, Integer>> entry : proceso.getConjuntoDatos().entrySet()) {
            Map<Integer, Integer> tiempos = new HashMap<Integer, Integer>();
            System.out.println("Proceso " + entry.getKey() + ". Instante de llegada: ");
            int instanteLlegada = entrada.nextInt();
            System.out.println("Proceso " + entry.getKey() + ". Tiempo de ejecución: ");
            int tiempoEjecucion = entrada.nextInt();
            columnas += tiempoEjecucion;
            tiempos.put(instanteLlegada, tiempoEjecucion);
            entry.setValue(tiempos);
        }

        proceso.defineTablero(filas, columnas);

        for (int i = 0; i < proceso.getTableroTiempos().length; i++) {
            for (int j = 0; j < proceso.getTableroTiempos()[i].length; j++) {
                proceso.getTableroTiempos()[i][j] = " ";
            }
        }

        String[][] tablero = proceso.getTableroTiempos();
        int posicionFinal = 0;
        int contador = 0;

        Map<Integer, Integer> tiemposProceso = proceso.getTiempos();

        while (contador < filas) {
            for (Map.Entry<Integer, Integer> tiempos : tiemposProceso.entrySet()) {
                int posicionColumna = tiempos.getValue() - 1;
                posicionFinal += posicionColumna;
                if (contador == 0) {
                    for (int x = 0; x <= contador; x++) {
                        for (int z = tiempos.getKey(); z <= posicionFinal; z++) {
                            tablero[x][z] = "*";
                        }
                    }
                    proceso.insertaTiemposConjuntoInicioFinFIFO(tiempos.getKey(), posicionFinal);
                } else {
                    int inicio = tiempos.getKey();
                    int fin = tiempos.getValue();
                    int inicioProceso = 0;
                    for (int x = 0; x < tablero.length; x++) {
                        for (int z = 0; z < tablero[x].length - 1; z++) {
                            if ((x != 0) && (tablero[x - 1][inicio].equals("*"))) {
                                tablero[x][inicio] = "-";
                                inicio++;
                                inicioProceso = inicio;
                            } else {
                                if ((x != 0) && tablero[x - 1][inicioProceso].equals(" ")
                                        && tablero[x - 1][inicioProceso] != "-") {
                                    if (inicioProceso >= inicio) {
                                        for (int y = inicioProceso; y < (fin + inicioProceso); y++) {
                                            if (y < columnas) {
                                                tablero[x][y] = "*";

                                            }
                                        }
                                    }
                                    proceso.insertaTiemposConjuntoInicioFinFIFO(inicioProceso,
                                            (fin + inicioProceso) - 1);
                                }
                                inicio = tiempos.getKey();
                                fin = tiempos.getValue();
                                inicioProceso = 0;
                            }

                        }
                    }
                }
                contador++;
            }
        }

        proceso.imprimeMapaTiempos();

        System.out.println(proceso.toString());
        System.out.println(proceso.calculaOrdenEjecucionSJF());
        entrada.close();
    }
}
