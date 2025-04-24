package controllers;

import models.Persona;

public class SearchMethods {

    public boolean isSortedByAge(Persona[] personas) {
        for (int i = 0; i < personas.length - 1; i++) {
            if (personas[i].getEdad() > personas[i + 1].getEdad()) {
                return false;
            }
        }
        return true;
    }

    public boolean isSortedByName(Persona[] personas) {
        for (int i = 0; i < personas.length - 1; i++) {
            if (personas[i].getNombre().compareTo(personas[i + 1].getNombre()) > 0) {
                return false;
            }
        }
        return true;
    }

    public Persona binarySearchByAge(Persona[] personas, int edad) {
        int left = 0, right = personas.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (personas[mid].getEdad() == edad) {
                return personas[mid];
            }
            if (personas[mid].getEdad() < edad) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public Persona binarySearchByName(Persona[] personas, String nombre) {
        int left = 0, right = personas.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (personas[mid].getNombre().equals(nombre)) {
                return personas[mid];
            }
            if (personas[mid].getNombre().compareTo(nombre) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}