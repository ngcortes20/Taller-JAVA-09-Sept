package Escuela;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Instancia escuela
        Escuela nuevaEscuela = new Escuela();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        //Agregando estudiantes
        nuevaEscuela.agregarEstudiante(new Estudiante("Alejandra Urrea", 123456, 9.5));
        nuevaEscuela.agregarEstudiante(new Estudiante("Nicole Cortes", 234567, 9.2));
        nuevaEscuela.agregarEstudiante(new Estudiante("Eduard Idrobo", 345678, 8.5));

        //Menu de interaccion
        // Menú de interacción con el usuario
        while (continuar) {
            System.out.println("\n--- Menú de la Escuela ---");
            System.out.println("1. Agregar un nuevo estudiante");
            System.out.println("2. Buscar un estudiante por número de identificación");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    agregarNuevoEstudiante(nuevaEscuela, scanner);
                    break;
                case 2:
                    buscarEstudiantePorID(nuevaEscuela, scanner);
                    break;
                case 3:
                    continuar = false;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }

        scanner.close();
    }

    //Metodo agregar estudiante
    public static void agregarNuevoEstudiante(Escuela escuela, Scanner scanner) {
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine();

        int numeroID = 0;
        boolean idValido = false;
        while (!idValido) {
            System.out.print("Ingrese el número de identificación (único): ");
            numeroID = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea
            if (escuela.buscarEstudiante(numeroID) == null) {
                idValido = true;  // ID es único
            } else {
                System.out.println("Error: El número de identificación ya existe. Intente nuevamente.");
            }
        }

        double calificacion = -1;
        while (calificacion < 0 || calificacion > 10) {
            System.out.print("Ingrese la calificación del estudiante (0-10): ");
            calificacion = scanner.nextDouble();
            scanner.nextLine(); // Consumir la nueva línea
            if (calificacion < 0 || calificacion > 10) {
                System.out.println("Error: La calificación debe estar entre 0 y 10.");
            }
        }

        // Crear estudiante y agregarlo a la escuela
        Estudiante nuevoEstudiante = new Estudiante(nombre, numeroID, calificacion);
        escuela.agregarEstudiante(nuevoEstudiante);
    }

    // Metodo buscar estudiante
    public static void buscarEstudiantePorID(Escuela escuela, Scanner scanner) {
        System.out.print("Ingrese el número de identificación del estudiante: ");
        int numeroID = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        Estudiante estudiante = escuela.buscarEstudiante(numeroID);
        if (estudiante != null) {
            System.out.println("Estudiante encontrado: ");
            System.out.println("Nombre: " + estudiante.getNombre());
            System.out.println("Número de Identificación: " + estudiante.getIdentificacion());
            System.out.println("Calificación: " + estudiante.getCalificacion());
        } else {
            System.out.println("No se encontró un estudiante con el número de identificación proporcionado.");
        }

    }
}