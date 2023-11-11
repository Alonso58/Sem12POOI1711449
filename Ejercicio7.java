Main.java

class Empleado {
    protected String nombre;
    protected int edad;
    protected double salarioBase;
    protected double productividad;

    public Empleado(String nombre, int edad, double salarioBase, double productividad) {
        this.nombre = nombre;
        this.edad = edad;
        this.salarioBase = salarioBase;
        this.productividad = productividad;
    }

    public double calcularSalario() {
        return salarioBase * (1 + productividad);
    }

    public void darDeAlta() {
        System.out.println("Empleado " + nombre + " dado de alta en la empresa.");
    }

    public void jubilacion() {
        System.out.println("Empleado " + nombre + " se ha jubilado.");
    }

    public void recibirAumento(double aumento) {
        salarioBase += aumento;
        System.out.println("¡Felicidades, " + nombre + "! Ha recibido un aumento. Nuevo salario: " + salarioBase);
    }

    public void promocionar(double nuevaProductividad) {
        if (nuevaProductividad > productividad) {
            productividad = nuevaProductividad;
            System.out.println("¡Enhorabuena, " + nombre + "! Ha sido promocionado. Nueva productividad: " + productividad);
        } else {
            System.out.println("Lo siento, " + nombre + ". No cumples los requisitos para la promoción.");
        }
    }

    public void despedir() {
        System.out.println("Empleado " + nombre + " ha sido despedido.");
    }

    public String accesoPublico() {
        return "Nombre: " + nombre + ", Edad: " + edad;
    }

    public String accesoSupervisor() {
        return accesoPublico() + ", Salario: " + calcularSalario();
    }

    public String accesoRecursosHumanos() {
        return accesoSupervisor();
    }

    public String accesoSUNAT() {
        return "Información fiscal de " + nombre;
    }
}

class Supervisor extends Empleado {
    protected double bono; 

    public Supervisor(String nombre, int edad, double salarioBase, double productividad, double bono) {
        super(nombre, edad, salarioBase, productividad);
        this.bono = bono;
    }

    @Override
    public double calcularSalario() {
        return (salarioBase + bono) * (1 + productividad);
    }

    @Override
    public String accesoSupervisor() {
        return super.accesoSupervisor() + ", Bono: " + bono;
    }
}

class Director extends Supervisor {
    private double prima;

    public Director(String nombre, int edad, double salarioBase, double productividad, double bono, double prima) {
        super(nombre, edad, salarioBase, productividad, bono);
        this.prima = prima;
    }

    @Override
    public double calcularSalario() {
        return (salarioBase + bono + prima) * (1 + productividad);
    }

    @Override
    public String accesoRecursosHumanos() {
        return super.accesoSupervisor() + ", Prima: " + prima;
    }

    @Override
    public String accesoSUNAT() {
        return super.accesoSUNAT() + ", Prima: " + prima;
    }
}

public class Main {
    public static void main(String[] args) {
        Empleado empleado = new Empleado("Juan", 30, 2000, 0.1);
        Supervisor supervisor = new Supervisor("Pedro", 35, 2500, 0.15, 500);
        Director director = new Director("Maria", 40, 3500, 0.2, 1000, 1500);

        System.out.println(empleado.accesoPublico());
        System.out.println(supervisor.accesoSupervisor());
        System.out.println(director.accesoRecursosHumanos());
        System.out.println(director.accesoSUNAT());
    }
}
