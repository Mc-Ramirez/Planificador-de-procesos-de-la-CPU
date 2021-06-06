import java.util.HashMap;
import java.util.Map;

public class Proceso {
    private int llegada;
    private int tiempoEjecucion;
    private Map<String, Map<Integer, Integer>> conjuntoDatos;
    private String[][] tableroTiempos;

    public Proceso() {
        this.conjuntoDatos = new HashMap<String, Map<Integer, Integer>>();
    }

    public int getLlegada() {
        return llegada;
    }

    public void setLlegada(int llegada) {
        this.llegada = llegada;
    }

    public int getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public void setTiempoEjecucion(int tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public Map<String, Map<Integer, Integer>> getConjuntoDatos() {
        return conjuntoDatos;
    }

    public void setConjuntoDatos(Map<String, Map<Integer, Integer>> conjuntoDatos) {
        this.conjuntoDatos = conjuntoDatos;
    }

    public String[][] getTableroTiempos() {
        return tableroTiempos;
    }

    public void setTableroTiempos(String[][] tableroTiempos) {
        this.tableroTiempos = tableroTiempos;
    }

    @Override
    public String toString() {
        return "Proceso [conjuntoDatos=" + conjuntoDatos + "]";
    }

    public Map<Integer, Integer> obtenerTiemposMap() {
        Map<Integer, Integer> tiempos = new HashMap<Integer, Integer>();
        for (Map.Entry<String, Map<Integer, Integer>> datos : getConjuntoDatos().entrySet()) {
            for (Map.Entry<Integer, Integer> tiempo : datos.getValue().entrySet())
                tiempos.put(tiempo.getKey(), tiempo.getValue());
        }
        return tiempos;
    }

    public void iniciaConjuntoDatos(int numeroProcesos) {
        int i = 0;
        while (i <= numeroProcesos - 1) {
            for (char letra = 'A'; letra <= 'Z'; letra++) {
                if (i <= numeroProcesos - 1) {
                    this.conjuntoDatos.put(String.valueOf(letra), null);
                    i++;
                }
            }
        }
    }

    public void defineTablero(int filas, int columnas) {
        this.tableroTiempos = new String[filas][columnas];
    }

    public void imprimeMapaTiempos() {
        for (int i = 0; i < tableroTiempos.length; i++) {
            for (int j = 0; j < tableroTiempos[i].length; j++) {
                System.out.print(" [ " + tableroTiempos[i][j] + " ] ");
            }
            System.out.println("\n");
        }
    }

}
