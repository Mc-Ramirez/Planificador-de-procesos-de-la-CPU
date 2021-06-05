import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Numero de procesos que realizará la CPU: ");
        int numeroProcesos = entrada.nextInt();
        Proceso proceso = new Proceso();
        proceso.iniciaConjuntoDatos(numeroProcesos);

        int columnas = 0;
        int filas = numeroProcesos;

        for (Map.Entry<String, Map<Integer, Integer>> entry : proceso.getConjuntoDatos().entrySet()) {
            Map<Integer, Integer> tiempos = new HashMap<Integer, Integer>();
            System.out.println("Proceso " + entry.getKey() + ". Instante de llegada: ");
            Integer instanteLlegada = entrada.nextInt();
            System.out.println("Proceso " + entry.getKey() + ". Tiempo de ejecución: ");
            Integer tiempoEjecucion = entrada.nextInt();
            columnas += tiempoEjecucion;
            tiempos.put(instanteLlegada, tiempoEjecucion);
            entry.setValue(tiempos);
        }

        Integer[][] tablero = new Integer[filas][columnas];

        System.out.println(proceso.toString());
        entrada.close();
    }
}
