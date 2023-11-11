Principal.java

import java.util.ArrayList;

abstract class LAN {
    ArrayList<Nodo> nodos;

    public LAN() {
        nodos = new ArrayList<>();
    }

    public void listarNodos() {
        for (Nodo nodo : nodos) {
            System.out.println(nodo);
        }
    }

    public void agregarNodo(Nodo nodo) {
        nodos.add(nodo);
    }

    public void quitarNodo(Nodo nodo) {
        nodos.remove(nodo);
    }

    public abstract void configurarRed(String topologia);
    public abstract void establecerTamanioPaquete(int tamanio);
    public abstract void enviarPaquete(Nodo emisor, Nodo receptor, String paquete);
    public abstract void difundirPaquete(Nodo emisor, String paquete);
    public abstract void calcularEstadisticas();
}

class RedEstrella extends LAN {
    private String topologia;
    private int tamanioPaquete;

    public RedEstrella() {
        topologia = "Estrella";
    }

    public void configurarRed(String topologia) {
        this.topologia = topologia;
        System.out.println("Configurando red en topología de estrella.");
    }

    public void establecerTamanioPaquete(int tamanio) {
        tamanioPaquete = tamanio;
    }

    public void enviarPaquete(Nodo emisor, Nodo receptor, String paquete) {
        System.out.println("Enviando paquete de " + emisor + " a " + receptor + ": " + paquete);
    }

    public void difundirPaquete(Nodo emisor, String paquete) {
        System.out.println("Difundiendo paquete desde " + emisor + " a todos los nodos: " + paquete);
    }

    public void calcularEstadisticas() {
    }
}

class RedBus extends LAN {
    private String topologia;
    private int tamanioPaquete;

    public RedBus() {
        topologia = "Bus";
    }

    public void configurarRed(String topologia) {
        this.topologia = topologia;
        System.out.println("Configurando red en topología de bus.");
    }

    public void establecerTamanioPaquete(int tamanio) {
        tamanioPaquete = tamanio;
    }

    public void enviarPaquete(Nodo emisor, Nodo receptor, String paquete) {
        System.out.println("Enviando paquete de " + emisor + " a " + receptor + ": " + paquete);
    }

    public void difundirPaquete(Nodo emisor, String paquete) {
        System.out.println("Difundiendo paquete desde " + emisor + " a todos los nodos: " + paquete);
    }

    public void calcularEstadisticas() {
    }
}

class Nodo {
    private String nombre;

    public Nodo(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return "Nodo: " + nombre;
    }
}

public class Principal {
    public static void main(String[] args) {
        RedEstrella redEstrella = new RedEstrella();
        redEstrella.configurarRed("Estrella");

        Nodo nodo1 = new Nodo("PC");
        Nodo nodo2 = new Nodo("Impresora");

        redEstrella.agregarNodo(nodo1);
        redEstrella.agregarNodo(nodo2);

        redEstrella.listarNodos();

        redEstrella.establecerTamanioPaquete(1024);

        redEstrella.enviarPaquete(nodo1, nodo2, "Mensaje de ejemplo");

        redEstrella.difundirPaquete(nodo1, "Mensaje de difusión");
    }
}
