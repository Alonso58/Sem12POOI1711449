Main.java

public class Main {
    public static void main(String[] args) {
        Cadena miCadena = new Cadena("Hola, mundo!");

        miCadena.visualizarCadena();
        System.out.println("La longitud de la cadena es: " + miCadena.obtenerLongitud());

        int indice = 4;
        char caracterEnIndice = miCadena.caracter(indice);
        if (caracterEnIndice != '\0') {
            System.out.println("El carácter en el índice " + indice + " es: " + caracterEnIndice);
        } else {
            System.out.println("El índice está fuera de rango.");
        }
    }
}

Cadena.java

public class Cadena {
    private int longitud;
    private String cadena;

    public Cadena(String cadena) {
        this.cadena = cadena;
        this.longitud = cadena.length();
    }

    public int obtenerLongitud() {
        return longitud;
    }

    public String obtenerCadena() {
        return cadena;
    }

    public char caracter(int i) {
        if (i >= 0 && i < longitud) {
            return cadena.charAt(i);
        } else {
            return '\0'; 
        }
    }

    public void visualizarCadena() {
        System.out.println("La cadena es: " + cadena);
    }
}
