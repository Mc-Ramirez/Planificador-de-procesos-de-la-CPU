import java.util.HashMap;
import java.util.Map;

public class Proceso {
    private String nombreProceso;
    private int llegada;
    private int tiempoEjecucion;
    private Map<String, Map<Integer, Integer>> conjuntoDatos;

    public Proceso() {
        this.conjuntoDatos = new HashMap<String, Map<Integer, Integer>>();
    }

    public Proceso(String nombreProceso, int llegada, int tiempoEjecucion) {
        this.nombreProceso = nombreProceso;
        this.llegada = llegada;
        this.tiempoEjecucion = tiempoEjecucion;
        this.conjuntoDatos = new HashMap<String, Map<Integer, Integer>>();
    }

    public void iniciaDatos() {
        Map<Integer, Integer> tiempos = new HashMap<Integer, Integer>();
        tiempos.put(this.llegada, this.tiempoEjecucion);
        conjuntoDatos.put(this.nombreProceso, tiempos);
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

    public String getNombreProceso() {
        return nombreProceso;
    }

    public void setNombreProceso(String nombreProceso) {
        this.nombreProceso = nombreProceso;
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

    @Override
    public String toString() {
        return "Proceso [conjuntoDatos=" + conjuntoDatos + ", llegada=" + llegada + ", nombreProceso=" + nombreProceso
                + ", tiempoEjecucion=" + tiempoEjecucion + "]";
    }

}
