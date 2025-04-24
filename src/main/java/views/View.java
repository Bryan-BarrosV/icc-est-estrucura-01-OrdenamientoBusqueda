package views;

import models.Persona;
import java.util.Scanner;

public class View {
    private Scanner scanner = new Scanner(System.in);

    public int showMenu() {
        System.out.println("Menú:");
        System.out.println("1. Añadir Persona");
        System.out.println("2. Ordenar Personas");
        System.out.println("3. Buscar Persona");
        System.out.println("4. Mostrar Personas");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public Persona inputPersona() {
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.next();
        System.out.print("Ingrese la edad: ");
        int edad = scanner.nextInt();
        return new Persona(nombre, edad);
    }

    public int selectSortingMethod() {
        System.out.println("Seleccione el método de ordenamiento:");
        System.out.println("1. Ordenar por nombre (Burbuja)");
        System.out.println("2. Ordenar por nombre (Selección Descendente)");
        System.out.println("3. Ordenar por edad (Inserción)");
        System.out.println("4. Ordenar por nombre (Inserción)");
        System.out.print("Opción: ");
        return scanner.nextInt();
    }

    public int selectSearchCriterion() {
        System.out.println("Seleccione el criterio de búsqueda:");
        System.out.println("1. Buscar por edad");
        System.out.println("2. Buscar por nombre");
        System.out.print("Opción: ");
        return scanner.nextInt();
    }

    public void displayPersonas(Persona[] personas) {
        for (Persona persona : personas) {
            System.out.println("Nombre: " + persona.getNombre() + ", Edad: " + persona.getEdad());
        }
    }

    public void displaySearchResult(Persona persona) {
        if (persona != null) {
            System.out.println("Persona encontrada: Nombre: " + persona.getNombre() + ", Edad: " + persona.getEdad());
        } else {
            System.out.println("Persona no encontrada.");
        }
    }

    public int inputEdad() {
        System.out.print("Ingrese la edad a buscar: ");
        return scanner.nextInt();
    }

    public String inputNombre() {
        System.out.print("Ingrese el nombre a buscar: ");
        return scanner.next();
    }
}