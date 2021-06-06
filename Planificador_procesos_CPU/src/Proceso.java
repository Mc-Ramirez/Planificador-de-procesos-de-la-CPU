import java.util.HashMap;
import java.util.Map;

public class Proceso {
    private double promedio;
    private int numeroProcesos;
    private String[][] tableroTiempos;
    private Map<Integer, Integer> tiempos;
    private Map<String, Map<Integer, Integer>> conjuntoDatos;
    private Map<String, Map<Integer, Integer>> conjuntoInicioFin;

    public Proceso(int numeroProcesos) {
        this.numeroProcesos = numeroProcesos;
        this.conjuntoDatos = new HashMap<String, Map<Integer, Integer>>();
        this.iniciaConjuntoDatos(numeroProcesos);
        this.iniciaConjuntoInicioFin();
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

    public double getPromedio() {
        double sumatorio = 0;
        for (Map.Entry<Integer, Integer> tiempo : this.tiempos.entrySet()) {
            sumatorio += tiempo.getValue();
        }
        return sumatorio / this.numeroProcesos;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public Map<String, Map<Integer, Integer>> getConjuntoInicioFin() {
        return conjuntoInicioFin;
    }

    public void setConjuntoInicioFin(Map<String, Map<Integer, Integer>> conjuntoInicioFin) {
        this.conjuntoInicioFin = conjuntoInicioFin;
    }

    public Map<Integer, Integer> getTiempos() {
        this.tiempos = new HashMap<Integer, Integer>();
        for (Map.Entry<String, Map<Integer, Integer>> datos : getConjuntoDatos().entrySet()) {
            for (Map.Entry<Integer, Integer> tiempo : datos.getValue().entrySet())
                tiempos.put(tiempo.getKey(), tiempo.getValue());
        }
        return this.tiempos;
    }

    public void setTiempos(Map<Integer, Integer> tiempos) {
        this.tiempos = tiempos;
    }

    public int getNumeroProcesos() {
        return numeroProcesos;
    }

    public void setNumeroProcesos(int numeroProcesos) {
        this.numeroProcesos = numeroProcesos;
    }

    @Override
    public String toString() {
        return "Proceso [tiempos de llegada y ejecución=" + conjuntoDatos + ", tiempos de inicio y fin="
                + conjuntoInicioFin + ", promedio=" + this.getPromedio() + "]";
    }

    private void iniciaConjuntoDatos(int numeroProcesos) {
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

    private void iniciaConjuntoInicioFin() {
        this.conjuntoInicioFin = new HashMap<String, Map<Integer, Integer>>();
        for (Map.Entry<String, Map<Integer, Integer>> datos : getConjuntoDatos().entrySet()) {
            this.conjuntoInicioFin.put(datos.getKey(), null);
        }
    }

    public void insertaTiemposConjuntoInicioFin(int inicio, int fin) {
        Map<Integer, Integer> tiempos = new HashMap<Integer, Integer>();
        for (Map.Entry<String, Map<Integer, Integer>> dato : getConjuntoInicioFin().entrySet()) {
            if (dato.getValue() == null) {
                tiempos.put(inicio, fin);
                dato.setValue(tiempos);
                break;
            }
        }
    }

}
