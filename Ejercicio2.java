import java.util.Scanner;

class Empleado {
    private String nombre;
    private String numeroEmpleado;

    public void leerDatos() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del empleado: ");
        this.nombre = scanner.nextLine();
        System.out.print("Ingrese el número de empleado: ");
        this.numeroEmpleado = scanner.nextLine();
    }

    public void verDatos() {
        System.out.println("Nombre del empleado: " + this.nombre);
        System.out.println("Número de empleado: " + this.numeroEmpleado);
    }
}

public class Main {
    public static void main(String[] args) {
        Empleado empleado = new Empleado();
        empleado.leerDatos();
        empleado.verDatos();
    }
}
