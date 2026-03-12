package ui;

import java.util.Scanner;

public class AppConsola {

    Scanner scanner = new Scanner(System.in);

    public void iniciar() {

        int opcion;

        do {

            mostrarMenu();
            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("Crear rutina");
                    break;

                case 2:
                    System.out.println("Ver rutinas");
                    break;

                case 3:
                    System.out.println("Crear sesión");
                    break;

                case 4:
                    System.out.println("Registrar ejercicio");
                    break;

                case 0:
                    System.out.println("Salir");
                    break;
            }

        } while (opcion != 0);
    }

    private void mostrarMenu() {

        System.out.println("----- APP FITNESS -----");
        System.out.println("1. Crear rutina");
        System.out.println("2. Ver rutinas");
        System.out.println("3. Crear sesión");
        System.out.println("4. Registrar ejercicio");
        System.out.println("0. Salir");
    }
}
