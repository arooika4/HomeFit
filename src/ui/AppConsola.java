package ui;

import java.util.Scanner;

public class AppConsola {

    Scanner scanner = new Scanner(System.in);

    // Estado de navegación
    private String rutinaSeleccionada = "";
    private String ejercicioSeleccionado = "";

    // Ejercicios por rutina (índice 0=Tren superior, 1=Tren inferior, 2=Core)
    private static final String[][] EJERCICIOS_POR_RUTINA = {
        {"Flexiones", "Dominadas", "Press de hombros"},
        {"Sentadillas", "Zancadas", "Puente de glúteos"},
        {"Plancha", "Crunch abdominal", "Mountain climber"}
    };
    private int indiceRutina = 0;

    public void iniciar() {
        pantalla1();
    }

    // ── PANTALLA 1: Inicio ───────────────────────────────────────────────────
    private void pantalla1() {
        System.out.println();
        System.out.println("¡Bienvenid@ a HomeFit!");
        System.out.println("  1- Tren superior [2]");
        System.out.println("  2- Tren inferior [2]");
        System.out.println("  3- Core          [2]");
        System.out.println("  4- Historial     [6]");
        System.out.print("> [Escribir opción]: ");

        String opcion = scanner.nextLine().trim();

        switch (opcion) {
            case "1":
                rutinaSeleccionada = "Tren superior";
                indiceRutina = 0;
                pantalla2();
                break;
            case "2":
                rutinaSeleccionada = "Tren inferior";
                indiceRutina = 1;
                pantalla2();
                break;
            case "3":
                rutinaSeleccionada = "Core";
                indiceRutina = 2;
                pantalla2();
                break;
            case "4":
                pantalla6();
                break;
            default:
                System.out.println("[Opción no reconocida]");
                pantalla1();
        }
    }

    // ── PANTALLA 2: Rutina (lista de ejercicios) ─────────────────────────────
    private void pantalla2() {
        String[] ejercicios = EJERCICIOS_POR_RUTINA[indiceRutina];
        System.out.println();
        System.out.println(rutinaSeleccionada);
        System.out.println("  1- " + ejercicios[0] + " [3]");
        System.out.println("  2- " + ejercicios[1] + " [3]");
        System.out.println("  3- " + ejercicios[2] + " [3]");
        System.out.println("  4- Atrás  [1]");
        System.out.println("  5- Inicio [1]");
        System.out.print("> [Escribir opción]: ");

        String opcion = scanner.nextLine().trim();

        switch (opcion) {
            case "1":
                ejercicioSeleccionado = ejercicios[0];
                pantalla3();
                break;
            case "2":
                ejercicioSeleccionado = ejercicios[1];
                pantalla3();
                break;
            case "3":
                ejercicioSeleccionado = ejercicios[2];
                pantalla3();
                break;
            case "4":
            case "5":
                pantalla1();
                break;
            default:
                System.out.println("[Opción no reconocida]");
                pantalla2();
        }
    }

    // ── PANTALLA 3: Detalle del ejercicio ────────────────────────────────────
    private void pantalla3() {
        System.out.println();
        System.out.println(ejercicioSeleccionado);
        System.out.println("  1- Video explicativo del ejercicio [Video]");
        System.out.println("  Con este ejercicio lo que se entrena es etc etc y ayuda a etc etc.");
        System.out.println("  Estudios demuestran que etc etc y mejora tu etc etc.");
        System.out.println();
        System.out.println("  2- Sacar foto del ejercicio [4]");
        System.out.println("  3- Atrás  [2]");
        System.out.println("  4- Inicio [1]");
        System.out.print("> [Escribir opción]: ");

        String opcion = scanner.nextLine().trim();

        switch (opcion) {
            case "1":
                System.out.println("  [Reproduciendo video de " + ejercicioSeleccionado + "...]");
                pantalla3();
                break;
            case "2":
                pantalla4();
                break;
            case "3":
                pantalla2();
                break;
            case "4":
                pantalla1();
                break;
            default:
                System.out.println("[Opción no reconocida]");
                pantalla3();
        }
    }

    // ── PANTALLA 4: Cámara ───────────────────────────────────────────────────
    private void pantalla4() {
        System.out.println();
        System.out.println("Cámara");
        System.out.println("  1- Sacar foto [5]");
        System.out.println("  2- Salir      [3]");
        System.out.print("> [Escribir opción]: ");

        String opcion = scanner.nextLine().trim();

        switch (opcion) {
            case "1":
                pantalla5();
                break;
            case "2":
                pantalla3();
                break;
            default:
                System.out.println("[Opción no reconocida]");
                pantalla4();
        }
    }

    // ── PANTALLA 5: Foto realizada ───────────────────────────────────────────
    private void pantalla5() {
        System.out.println();
        System.out.println("Foto realizada");
        System.out.println("  [Foto/Video referencia]");
        System.out.println("  [Foto realizada]");
        System.out.println();
        System.out.println("  1- Volver a sacar foto [4]");
        System.out.println("  2- Terminar ejercicio  [1]");
        System.out.print("> [Escribir opción]: ");

        String opcion = scanner.nextLine().trim();

        switch (opcion) {
            case "1":
                pantalla4();
                break;
            case "2":
                pantalla1();
                break;
            default:
                System.out.println("[Opción no reconocida]");
                pantalla5();
        }
    }

    // ── PANTALLA 6: Historial ────────────────────────────────────────────────
    private void pantalla6() {
        System.out.println();
        System.out.println("Historial");
        System.out.println("  1- 26/2/2026 [7]");
        System.out.println("  2- 25/2/2026 [7]");
        System.out.println("  3- 24/2/2026 [7]");
        System.out.println("  4- Atrás  [1]");
        System.out.println("  5- Inicio [1]");
        System.out.print("> [Escribir opción]: ");

        String opcion = scanner.nextLine().trim();

        switch (opcion) {
            case "1":
            case "2":
            case "3":
                pantalla7();
                break;
            case "4":
            case "5":
                pantalla1();
                break;
            default:
                System.out.println("[Opción no reconocida]");
                pantalla6();
        }
    }

    // ── PANTALLA 7: Historial detalle ────────────────────────────────────────
    private void pantalla7() {
        System.out.println();
        System.out.println("Historial detalle");
        System.out.println();
        System.out.println("  26/2/2026");
        System.out.println("  * Flexiones:");
        System.out.println("     * Tiempo: 00:02:34");
        System.out.println("     * Nivel: experto");
        System.out.println("     * 1- [Foto realizada] [8]");
        System.out.println("  * Sentadillas:");
        System.out.println("     * Tiempo: 00:01:40");
        System.out.println("     * Nivel: intermedio");
        System.out.println("     * 2- [Foto realizada] [8]");
        System.out.println();
        System.out.println("  25/2/2026");
        System.out.println("  * Plancha:");
        System.out.println("     * Tiempo: 00:01:30");
        System.out.println("     * Nivel: intermedio");
        System.out.println("     * 3- [Foto realizada] [8]");
        System.out.println("  * Sentadillas:");
        System.out.println("     * Tiempo: 00:01:02");
        System.out.println("     * Nivel: principiante");
        System.out.println("     * 4- [Foto realizada] [8]");
        System.out.println();
        System.out.println("  5- Atrás  [6]");
        System.out.println("  6- Inicio [1]");
        System.out.print("> [Escribir opción]: ");

        String opcion = scanner.nextLine().trim();

        switch (opcion) {
            case "1":
            case "2":
            case "3":
            case "4":
                pantalla8();
                break;
            case "5":
                pantalla6();
                break;
            case "6":
                pantalla1();
                break;
            default:
                System.out.println("[Opción no reconocida]");
                pantalla7();
        }
    }

    // ── PANTALLA 8: Foto ampliada ────────────────────────────────────────────
    private void pantalla8() {
        System.out.println();
        System.out.println("Foto ampliada");
        System.out.println("  [Foto realizada]");
        System.out.println();
        System.out.println("  1- Atrás  [7]");
        System.out.println("  2- Inicio [1]");
        System.out.print("> [Escribir opción]: ");

        String opcion = scanner.nextLine().trim();

        switch (opcion) {
            case "1":
                pantalla7();
                break;
            case "2":
                pantalla1();
                break;
            default:
                System.out.println("[Opción no reconocida]");
                pantalla8();
        }
    }
}
