Main.java

public class Main {
    public static void main(String[] args) {
        Empleado[] empleados = new Empleado[50];

        for (int i = 0; i < 50; i++) {
            String nombre = "Empleado" + i;
            String apellido = "Apellido" + i;
            double salario = 1000 + (i * 100);

            empleados[i] = new Empleado(nombre, apellido, salario);
        }

        for (Empleado empleado : empleados) {
            System.out.println("Nombre: " + empleado.getNombre() + ", Apellido: " + empleado.getApellido() + ", Salario: " + empleado.getSalario());
        }
    }
}

Empleado.java

public class Empleado {
    private String nombre;
    private String apellido;
    private double salario;

    public Empleado(String nombre, String apellido, double salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getSalario() {
        return salario;
    }
}
