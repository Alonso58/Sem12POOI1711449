Main.java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Hora hora = new Hora(10, 30, 45);
        hora.visualizar();

        System.out.println("Desea avanzar la hora? (Si/No):");
        String avanzar = scanner.next();
        if (avanzar.equalsIgnoreCase("Si")) {
            System.out.println("Ingrese las horas a avanzar:");
            int horasAvanzar = scanner.nextInt();

            System.out.println("Ingrese los minutos a avanzar:");
            int minutosAvanzar = scanner.nextInt();

            System.out.println("Ingrese los segundos a avanzar:");
            int segundosAvanzar = scanner.nextInt();

            System.out.println("Avanzando la hora...");
            hora.avanzar(horasAvanzar, minutosAvanzar, segundosAvanzar);
            hora.visualizar();
        }

        System.out.println("Desea poner la hora a cero? (Si/No):");
        String ponerACero = scanner.next();
        if (ponerACero.equalsIgnoreCase("Si")) {
            System.out.println("Restableciendo la hora a 0...");
            hora.ponerACero();
            hora.visualizar();
        }

        scanner.close();
    }
}

Hora.java

public class Hora {
    private int horas;
    private int minutos;
    private int segundos;

    public Hora(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void avanzar(int horas, int minutos, int segundos) {
        this.segundos += segundos;
        this.minutos += minutos;
        this.horas += horas;

        if (this.segundos >= 60) {
            this.minutos += this.segundos / 60;
            this.segundos = this.segundos % 60;
        }

        if (this.minutos >= 60) {
            this.horas += this.minutos / 60;
            this.minutos = this.minutos % 60;
        }

        if (this.horas >= 24) {
            this.horas = this.horas % 24;
        }
    }

    public void ponerACero() {
        this.horas = 0;
        this.minutos = 0;
        this.segundos = 0;
    }

    public void visualizar() {
        System.out.printf("%02d:%02d:%02d\n", horas, minutos, segundos);
    }
}
