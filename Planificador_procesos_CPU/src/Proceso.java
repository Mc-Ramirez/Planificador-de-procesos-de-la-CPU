
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class Proceso {
    private double promedio;
    private int numeroProcesos;
    private String[][] tableroTiempos;
    private Map<Integer, Integer> tiempos;
    private Map<String, Map<Integer, Integer>> conjuntoDatos;
    private Map<String, Map<Integer, Integer>> conjuntoInicioFinFIFO;
    private Map<String, Map<Integer, Integer>> conjuntoInicioFinSJF;

    public Proceso(int numeroProcesos) {
        this.numeroProcesos = numeroProcesos;
        this.conjuntoDatos = new HashMap<String, Map<Integer, Integer>>();
        this.conjuntoInicioFinFIFO = new HashMap<String, Map<Integer, Integer>>();
        this.conjuntoInicioFinSJF = new HashMap<String, Map<Integer, Integer>>();
        this.iniciaConjuntoDatos(numeroProcesos);
        this.iniciaConjuntoAlfabeticamente(this.conjuntoInicioFinFIFO);
        this.iniciaConjuntoAlfabeticamente(this.conjuntoInicioFinSJF);
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

    public Map<String, Map<Integer, Integer>> getConjuntoInicioFinFIFO() {
        return conjuntoInicioFinFIFO;
    }

    public void setConjuntoInicioFinFIFO(Map<String, Map<Integer, Integer>> conjuntoInicioFinFIFO) {
        this.conjuntoInicioFinFIFO = conjuntoInicioFinFIFO;
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

    public Map<String, Map<Integer, Integer>> getConjuntoInicioFinSJF() {
        return conjuntoInicioFinSJF;
    }

    public void setConjuntoInicioFinSJF(Map<String, Map<Integer, Integer>> conjuntoInicioFinSJF) {
        this.conjuntoInicioFinSJF = conjuntoInicioFinSJF;
    }

    @Override
    public String toString() {
        return "Proceso FIFO[tiempos de llegada y ejecución=" + conjuntoDatos + ", tiempos de inicio y fin="
                + conjuntoInicioFinFIFO + ", promedio=" + this.getPromedio() + "]";
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

    private void iniciaConjuntoAlfabeticamente(Map<String, Map<Integer, Integer>> conjunto) {
        for (Map.Entry<String, Map<Integer, Integer>> datos : getConjuntoDatos().entrySet()) {
            conjunto.put(datos.getKey(), null);
        }
    }

    public void insertaTiemposConjuntoInicioFinFIFO(int inicio, int fin) {
        Map<Integer, Integer> tiempos = new HashMap<Integer, Integer>();
        for (Map.Entry<String, Map<Integer, Integer>> dato : getConjuntoInicioFinFIFO().entrySet()) {
            if (dato.getValue() == null) {
                tiempos.put(inicio, fin);
                dato.setValue(tiempos);
                break;
            }
        }
    }

    /**
     * Mapa de tiempos de SJF
     */
    public void insertaTiemposConjuntoInicioFinSJF() {
        Map<Integer, Integer> tiempos = new HashMap<Integer, Integer>();
        for (Map.Entry<String, Map<Integer, Integer>> datos : getConjuntoDatos().entrySet()) {
            for (Map.Entry<Integer, Integer> dato : datos.getValue().entrySet()) {

            }
        }
    }

    /**
     * Método que ordena de menor a mayor según tiempo de ejecución.
     * 
     * @return lista ordenada
     */
    public Stream<Entry<Integer, Integer>> calculaOrdenEjecucionSJF() {
        Stream<Map.Entry<Integer, Integer>> sorted = null;

        for (Map.Entry<String, Map<Integer, Integer>> dato : getConjuntoDatos().entrySet()) {
            // for (Map.Entry<Integer, Integer> tiempos : dato.getValue().entrySet()) {
            sorted = dato.getValue().entrySet().stream().sorted(Map.Entry.comparingByValue());
            System.out.println(sorted);
            // }
        }
        sorted.forEach(sor -> {
            System.out.println("Ordenado " + sor);
        });
        return sorted;
    }
}
