Hora.java

public class Hora {
    private int horas;
    private int minutos;
    private int segundos;

    public Hora() {
        this.horas = 0;
        this.minutos = 0;
        this.segundos = 0;
    }

    public Hora(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public void mostrarHora() {
        System.out.printf("Hora: %02d:%02d:%02d\n", this.horas, this.minutos, this.segundos);
    }

    public Hora sumarHoras(Hora otraHora) {
        Hora resultado = new Hora();

        resultado.segundos = this.segundos + otraHora.segundos;
        resultado.minutos = this.minutos + otraHora.minutos;
        resultado.horas = this.horas + otraHora.horas;

        if (resultado.segundos >= 60) {
            resultado.segundos -= 60;
            resultado.minutos++;
        }
        if (resultado.minutos >= 60) {
            resultado.minutos -= 60;
            resultado.horas++;
        }

        return resultado;
    }
}

Main.java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Hora hora1 = new Hora();

        System.out.println("Ingrese las horas, los minutos y los segundos para la segunda hora:");
        int horas = scanner.nextInt();
        int minutos = scanner.nextInt();
        int segundos = scanner.nextInt();

        Hora hora2 = new Hora(horas, minutos, segundos);

        Hora horaNoInicializada = new Hora();

        horaNoInicializada = hora1.sumarHoras(hora2);

        System.out.println("Hora 1:");
        hora1.mostrarHora();

        System.out.println("\nHora 2:");
        hora2.mostrarHora();

        System.out.println("\nResultado de la suma:");
        horaNoInicializada.mostrarHora();

        scanner.close();
    }
}

