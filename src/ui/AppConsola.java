package ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AppConsola {

    Scanner scanner = new Scanner(System.in);

    private String rutinaSeleccionada  = "";
    private String ejercicioSeleccionado = "";
    private String notasFotoActual = "";

    private long tiempoInicioMs = 0;
    private long tiempoTranscurridoMs = 0;

    private static class RegistroSesion {
        String ejercicio;
        String tiempo;
        String fecha;
        RegistroSesion(String ejercicio, String tiempo, String fecha) {
            this.ejercicio = ejercicio;
            this.tiempo    = tiempo;
            this.fecha     = fecha;
        }
    }
    private final List<RegistroSesion> historial = new ArrayList<>();
    private int indiceSesionDetalle = 0;

    private static final String[][] EJERCICIOS_POR_RUTINA = {
        {"Push up tradicional", "Vuelo lateral", "Fondos de tríceps"},
        {"Sentadilla con peso corporal", "Estocada búlgara", "Puente de glúteo"},
        {"Bicicleta abdominal", "Crunch abdominal", "Plancha"}
    };
    private int indiceRutina = 0;

    public void iniciar() {
        pantalla1();
    }

    private void iniciarCronometro() {
        tiempoInicioMs = System.currentTimeMillis();
    }

    private void detenerCronometro() {
        tiempoTranscurridoMs = System.currentTimeMillis() - tiempoInicioMs;
    }

    private String formatearTiempo(long ms) {
        long totalSeg = ms / 1000;
        long horas    = totalSeg / 3600;
        long minutos  = (totalSeg % 3600) / 60;
        long segundos = totalSeg % 60;
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }

    private Map<String, List<RegistroSesion>> historialPorFecha() {
        Map<String, List<RegistroSesion>> mapa = new LinkedHashMap<>();
        for (RegistroSesion r : historial) {
            mapa.computeIfAbsent(r.fecha, k -> new ArrayList<>()).add(r);
        }
        return mapa;
    }

    private void mostrarDescripcionEjercicio() {
        switch (ejercicioSeleccionado) {

            case "Push up tradicional":
                System.out.println("  CONSEJOS:");
                System.out.println("  • Intenta que tus codos queden ligeramente por debajo de la línea de tus hombros.");
                System.out.println("  • Baja en un solo bloque, manteniendo el abdomen contraído y evitando");
                System.out.println("    que tu columna se deforme.");
                System.out.println();
                System.out.println("  Las flexiones son un ejercicio multiarticular que involucra principalmente");
                System.out.println("  pecho, hombros y tríceps, al tiempo que requiere activación constante del");
                System.out.println("  core para mantener la alineación corporal. Según el American Council on");
                System.out.println("  Exercise, también generan una importante activación abdominal y estabilizadora,");
                System.out.println("  mejorando la estabilidad corporal y el control postural.");
                System.out.println();
                System.out.println("  Dificultad (3 series):");
                System.out.println("  • Novato: 8 repeticiones");
                System.out.println("  • Intermedio: 15 repeticiones");
                System.out.println("  • Avanzado: 25+ repeticiones");
                break;

            case "Vuelo lateral":
                System.out.println("  CONSEJOS:");
                System.out.println("  • Puedes usar cualquier objeto con peso: botellas, paquetes de arroz, etc.");
                System.out.println("  • Mantén los hombros hacia abajo y los codos ligeramente extendidos.");
                System.out.println();
                System.out.println("  El vuelo lateral fortalece el deltoides medio, responsable de la elevación");
                System.out.println("  lateral del brazo. Contribuye a la fuerza y resistencia del hombro,");
                System.out.println("  mejora la estabilidad escapular y previene desequilibrios musculares");
                System.out.println("  en la cintura escapular.");
                System.out.println();
                System.out.println("  Dificultad (3 series):");
                System.out.println("  • Novato: 10 repeticiones");
                System.out.println("  • Intermedio: 15 repeticiones");
                System.out.println("  • Avanzado: 20+ repeticiones");
                break;

            case "Fondos de tríceps":
                System.out.println("  CONSEJOS:");
                System.out.println("  • Concéntrate en que el movimiento provenga desde los codos.");
                System.out.println("  • Junta tus escápulas durante el ejercicio y mantén la postura.");
                System.out.println("  • Con las piernas flexionadas el movimiento es más sencillo.");
                System.out.println();
                System.out.println("  Los fondos de tríceps fortalecen el tríceps braquial, principal músculo");
                System.out.println("  responsable de la extensión del codo. También participan músculos");
                System.out.println("  estabilizadores del hombro y del tronco, mejorando la fuerza del");
                System.out.println("  miembro superior y el control corporal en movimientos de empuje.");
                System.out.println();
                System.out.println("  Dificultad (3 series):");
                System.out.println("  • Novato: 8 repeticiones");
                System.out.println("  • Intermedio: 15 repeticiones");
                System.out.println("  • Avanzado: 20+ repeticiones");
                break;

            case "Sentadilla con peso corporal":
                System.out.println("  CONSEJOS:");
                System.out.println("  • Si te resulta difícil alcanzar profundidad, puedes realizarla hacia un cajón.");
                System.out.println("  • Desciende de forma controlada, evitando que tus rodillas se junten.");
                System.out.println("  • Intenta mantener alineadas tus rodillas con la punta de tus pies.");
                System.out.println();
                System.out.println("  La sentadilla activa simultáneamente cuádriceps, glúteos e isquiotibiales,");
                System.out.println("  reproduciendo un patrón funcional presente en la vida diaria. Según");
                System.out.println("  Scientific Reports, mejora la fuerza, la capacidad funcional y la");
                System.out.println("  composición corporal incluso solo con el peso corporal.");
                System.out.println();
                System.out.println("  Dificultad (3 series):");
                System.out.println("  • Novato: 10 repeticiones");
                System.out.println("  • Intermedio: 20 repeticiones");
                System.out.println("  • Avanzado: 30+ repeticiones");
                break;

            case "Estocada búlgara":
                System.out.println("  CONSEJOS:");
                System.out.println("  • Pie delantero más adelantado: más dominante de cadera.");
                System.out.println("  • Pie delantero más atrás: más dominante de rodilla.");
                System.out.println("  • Alcanza la mayor profundidad posible manteniendo el tronco estable.");
                System.out.println("  • Al bajar, procura que tu rodilla no sobrepase excesivamente la punta del pie.");
                System.out.println();
                System.out.println("  Ejercicio unilateral que trabaja intensamente cuádriceps y glúteos,");
                System.out.println("  exigiendo alto control del equilibrio. Ha demostrado ser especialmente");
                System.out.println("  eficaz para mejorar la estabilidad de cadera y rodilla, corregir");
                System.out.println("  asimetrías de fuerza y desarrollar fuerza funcional.");
                System.out.println();
                System.out.println("  Dificultad (3 series):");
                System.out.println("  • Novato: 8 repeticiones por pierna");
                System.out.println("  • Intermedio: 12 repeticiones por pierna");
                System.out.println("  • Avanzado: 16+ repeticiones por pierna");
                break;

            case "Puente de glúteo":
                System.out.println("  CONSEJOS:");
                System.out.println("  • Pies adelantados: mayor tensión en isquiotibiales.");
                System.out.println("  • Pies cerca del cuerpo: mayor tensión en glúteos.");
                System.out.println("  • Empuja con los talones y contrae fuertemente los glúteos al extender la cadera.");
                System.out.println();
                System.out.println("  Fortalece el glúteo mayor y los isquiotibiales, centrándose en la");
                System.out.println("  extensión de cadera. Estudios de activación muscular demuestran altos");
                System.out.println("  niveles de activación del glúteo mayor, mejorando la estabilidad lumbar,");
                System.out.println("  la postura y reduciendo el riesgo de sobrecarga en la zona lumbar.");
                System.out.println();
                System.out.println("  Dificultad (3 series):");
                System.out.println("  • Novato: 12 repeticiones");
                System.out.println("  • Intermedio: 20 repeticiones");
                System.out.println("  • Avanzado: 30+ repeticiones");
                break;

            case "Bicicleta abdominal":
                System.out.println("  CONSEJOS:");
                System.out.println("  • Mantén la zona lumbar pegada al suelo durante todo el movimiento.");
                System.out.println("  • Alterna llevando el codo hacia la rodilla contraria mientras extiendes la otra.");
                System.out.println("  • Realiza el movimiento de forma controlada, sin tirar del cuello con las manos.");
                System.out.println();
                System.out.println("  Combina flexión de tronco con rotación, activando recto abdominal");
                System.out.println("  y oblicuos. Investigaciones muestran altos niveles de actividad");
                System.out.println("  en la musculatura abdominal, especialmente oblicuos, gracias al");
                System.out.println("  componente rotacional, desarrollando la fuerza y estabilidad del core.");
                System.out.println();
                System.out.println("  Dificultad (3 series):");
                System.out.println("  • Novato: 20 repeticiones");
                System.out.println("  • Intermedio: 40 repeticiones");
                System.out.println("  • Avanzado: 60+ repeticiones");
                break;

            case "Crunch abdominal":
                System.out.println("  CONSEJOS:");
                System.out.println("  • Eleva ligeramente los hombros del suelo contrayendo el abdomen.");
                System.out.println("  • Mantén la zona lumbar apoyada y evita impulsarte con el cuello.");
                System.out.println("  • Realiza repeticiones rápidas pero controladas, manteniendo tensión en el abdomen.");
                System.out.println();
                System.out.println("  Ejercicio clásico para fortalecer el recto abdominal, responsable de");
                System.out.println("  la flexión del tronco. Según el American Council on Exercise, genera");
                System.out.println("  una activación significativa del recto abdominal, siendo eficaz para");
                System.out.println("  desarrollar fuerza y resistencia del core.");
                System.out.println();
                System.out.println("  Dificultad (3 series):");
                System.out.println("  • Novato: 15 repeticiones");
                System.out.println("  • Intermedio: 30 repeticiones");
                System.out.println("  • Avanzado: 50+ repeticiones");
                break;

            case "Plancha":
                System.out.println("  CONSEJOS:");
                System.out.println("  • Coloca los antebrazos debajo de los hombros y mantén el cuerpo en línea recta.");
                System.out.println("  • Activa el abdomen y los glúteos para evitar que la cadera se hunda.");
                System.out.println("  • Mantén el cuello alineado con la columna mirando hacia el suelo.");
                System.out.println();
                System.out.println("  Activa simultáneamente transverso abdominal, oblicuos y musculatura");
                System.out.println("  lumbar mediante contracción isométrica. Investigaciones demuestran que");
                System.out.println("  mejora la resistencia del core, el control postural y la estabilidad");
                System.out.println("  de la columna, reduciendo el riesgo de molestias lumbares.");
                System.out.println();
                System.out.println("  Dificultad (3 series):");
                System.out.println("  • Novato: 20 segundos");
                System.out.println("  • Intermedio: 1 minuto");
                System.out.println("  • Avanzado: 2+ minutos");
                break;

            default:
                System.out.println("  (Descripción no disponible)");
        }
    }

    // PANTALLA 1: INICIO
    private void pantalla1() {
        System.out.println();
        System.out.println("-----------------------------------------------");
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

    // PANTALLA 2: RUTINA
    private void pantalla2() {
        String[] ejercicios = EJERCICIOS_POR_RUTINA[indiceRutina];
        System.out.println();
        System.out.println("-----------------------------------------------");
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
                iniciarCronometro();
                pantalla3();
                break;
            case "2":
                ejercicioSeleccionado = ejercicios[1];
                iniciarCronometro();
                pantalla3();
                break;
            case "3":
                ejercicioSeleccionado = ejercicios[2];
                iniciarCronometro();
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

    // PANTALLA 3: EJERCICIO
    private void pantalla3() {
        System.out.println();
        System.out.println("-----------------------------------------------");
        System.out.println(ejercicioSeleccionado);
        System.out.println("  1- Video explicativo del ejercicio [Video]");
        System.out.println();
        mostrarDescripcionEjercicio();
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

    // PANTALLA 4: CAMARA
    private void pantalla4() {
        System.out.println();
        System.out.println("-----------------------------------------------");
        System.out.println("Cámara");
        System.out.println("  1- Sacar foto [5]");
        System.out.println("  2- Salir      [3]");
        System.out.print("> [Escribir opción]: ");

        String opcion = scanner.nextLine().trim();

        switch (opcion) {
            case "1":
                detenerCronometro();
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

    // PANTALLA 5: FOTO REALIZADA
    private void pantalla5() {
        String tiempoFormateado = formatearTiempo(tiempoTranscurridoMs);
        String fechaHoy = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println();
        System.out.println("-----------------------------------------------");
        System.out.println("Foto realizada");
        System.out.println("  [Foto/Video referencia]");
        System.out.println("  [Foto realizada]");
        System.out.println();
        System.out.println("  Tiempo del ejercicio: " + tiempoFormateado);
        System.out.println();
        System.out.println("  1- Volver a sacar foto [4]");
        System.out.println("  2- Terminar ejercicio  [1]");
        System.out.print("> [Escribir opción]: ");

        String opcion = scanner.nextLine().trim();

        switch (opcion) {
            case "1":
                iniciarCronometro();
                pantalla4();
                break;
            case "2":
                historial.add(new RegistroSesion(ejercicioSeleccionado, tiempoFormateado, fechaHoy));
                pantalla1();
                break;
            default:
                System.out.println("[Opción no reconocida]");
                pantalla5();
        }
    }

    // PANTALLA 6: HISTORIAL
    private void pantalla6() {
        Map<String, List<RegistroSesion>> porFecha = historialPorFecha();
        List<String> fechas = new ArrayList<>(porFecha.keySet());

        System.out.println();
        System.out.println("-----------------------------------------------");
        System.out.println("Historial");

        if (fechas.isEmpty()) {
            System.out.println("  (Sin registros todavía)");
        } else {
            for (int i = 0; i < fechas.size(); i++) {
                System.out.println("  " + (i + 1) + "- " + fechas.get(i) + " [7]");
            }
        }

        int opcionAtras  = fechas.size() + 1;
        int opcionInicio = fechas.size() + 2;
        System.out.println("  " + opcionAtras  + "- Atrás  [1]");
        System.out.println("  " + opcionInicio + "- Inicio [1]");
        System.out.print("> [Escribir opción]: ");

        String opcion = scanner.nextLine().trim();
        int num = -1;
        try { num = Integer.parseInt(opcion); } catch (NumberFormatException ignored) {}

        if (num >= 1 && num <= fechas.size()) {
            indiceSesionDetalle = num - 1;
            pantalla7(porFecha, fechas);
        } else if (num == opcionAtras || num == opcionInicio) {
            pantalla1();
        } else {
            System.out.println("[Opción no reconocida]");
            pantalla6();
        }
    }

    // PANTALLA 7: HISTORIAL DETALLE
    private void pantalla7(Map<String, List<RegistroSesion>> porFecha, List<String> fechas) {
        System.out.println();
        System.out.println("-----------------------------------------------");
        System.out.println("Historial detalle");

        int contadorFoto = 1;
        for (int f = indiceSesionDetalle; f < Math.min(indiceSesionDetalle + 2, fechas.size()); f++) {
            String fecha = fechas.get(f);
            System.out.println();
            System.out.println("  " + fecha);
            for (RegistroSesion r : porFecha.get(fecha)) {
                System.out.println("  * " + r.ejercicio + ":");
                System.out.println("     * Tiempo: " + r.tiempo);
                System.out.println("     * " + contadorFoto + "- [Foto realizada] [8]");
                contadorFoto++;
            }
        }

        System.out.println();
        System.out.println("  " + contadorFoto     + "- Atrás  [6]");
        System.out.println("  " + (contadorFoto+1) + "- Inicio [1]");
        System.out.print("> [Escribir opción]: ");

        String opcion = scanner.nextLine().trim();
        int num = -1;
        try { num = Integer.parseInt(opcion); } catch (NumberFormatException ignored) {}

        if (num >= 1 && num < contadorFoto) {
            pantalla8();
        } else if (num == contadorFoto) {
            pantalla6();
        } else if (num == contadorFoto + 1) {
            pantalla1();
        } else {
            System.out.println("[Opción no reconocida]");
            pantalla7(porFecha, fechas);
        }
    }

    // PANTALLA 8: FOTO AMPLIADA
    private void pantalla8() {
        System.out.println();
        System.out.println("-----------------------------------------------");
        System.out.println("Foto ampliada");
        System.out.println("  [Foto referencia]");
        System.out.println("  [Foto realizada]");
        System.out.println("  1- Notas: " + notasFotoActual);

        System.out.println();
        System.out.println("  2- Atrás  [7]");
        System.out.println("  3- Inicio [1]");
        System.out.print("> [Escribir opción]: ");

        String opcion = scanner.nextLine().trim();

        switch (opcion) {
            case "1":
                System.out.print("  Escribe la nota: ");
                notasFotoActual = scanner.nextLine().trim();
                pantalla8();
                break;
            case "2":
                notasFotoActual = "";
                Map<String, List<RegistroSesion>> porFecha = historialPorFecha();
                List<String> fechas = new ArrayList<>(porFecha.keySet());
                pantalla7(porFecha, fechas);
                break;
            case "3":
                notasFotoActual = "";
                pantalla1();
                break;
            default:
                System.out.println("[Opción no reconocida]");
                pantalla8();
        }
    }
}
