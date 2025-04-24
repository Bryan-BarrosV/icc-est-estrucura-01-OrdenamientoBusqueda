package controllers;

import models.Persona;
import views.View;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private View view;
    private SortingMethods sortingMethods;
    private SearchMethods searchMethods;
    private List<Persona> personas;


    public Controller(View view, SortingMethods sortingMethods, SearchMethods searchMethods) {
        this.view = view;
        this.sortingMethods = sortingMethods;
        this.searchMethods = searchMethods;
        this.personas = new ArrayList<>();
    }

    public void start() {
        int option;
        do {
            option = view.showMenu();
            switch (option) {
                case 1 -> addPersona();
                case 2 -> sortPersonas();
                case 3 -> searchPersona();
                case 4 -> showPersonas();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (option != 5);
    }

    private void addPersona() {
        Persona nuevaPersona = view.inputPersona();
        personas.add(nuevaPersona);
        System.out.println("Persona añadida correctamente.");
    }

    private void sortPersonas() {
        if (personas.isEmpty()) {
            System.out.println("No hay personas para ordenar.");
            return;
        }

        int method = view.selectSortingMethod();
        Persona[] personasArray = personas.toArray(new Persona[0]);


        switch (method) {
            case 1 -> sortingMethods.sortByNameWithBubble(personasArray);
            case 2 -> sortingMethods.sortByNameWithSelectionDes(personasArray);
            case 3 -> sortingMethods.sortByAgeWithInsertion(personasArray);
            case 4 -> sortingMethods.sortByNameWithInsertion(personasArray);
            default -> {
                System.out.println("Método de ordenamiento inválido.");
                return;
            }
        }


        personas = new ArrayList<>(List.of(personasArray));
        System.out.println("Personas ordenadas correctamente.");
    }

    private void searchPersona() {
        if (personas.isEmpty()) {
            System.out.println("No hay personas para buscar.");
            return;
        }

        int criterion = view.selectSearchCriterion();
        Persona[] personasArray = personas.toArray(new Persona[0]);
        Persona result = null;


        switch (criterion) {
            case 1 -> {
                if (!searchMethods.isSortedByAge(personasArray)) {
                    sortingMethods.sortByAgeWithInsertion(personasArray);
                }
                int edad = view.inputEdad();
                result = searchMethods.binarySearchByAge(personasArray, edad);
            }
            case 2 -> {
                if (!searchMethods.isSortedByName(personasArray)) {
                    sortingMethods.sortByNameWithInsertion(personasArray);
                }
                String nombre = view.inputNombre();
                result = searchMethods.binarySearchByName(personasArray, nombre);
            }
            default -> {
                System.out.println("Criterio de búsqueda inválido.");
                return;
            }
        }


        view.displaySearchResult(result);
    }

    private void showPersonas() {
        if (personas.isEmpty()) {
            System.out.println("No hay personas para mostrar.");
            return;
        }

        view.displayPersonas(personas.toArray(new Persona[0]));
    }
}