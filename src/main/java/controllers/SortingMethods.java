package controllers;

import models.Persona;

public class SortingMethods {

    public void sortByNameWithBubble(Persona[] personas) {
        int n = personas.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (personas[j].getNombre().compareTo(personas[j + 1].getNombre()) > 0) {
                    Persona temp = personas[j];
                    personas[j] = personas[j + 1];
                    personas[j + 1] = temp;
                }
            }
        }
    }

    public void sortByNameWithSelectionDes(Persona[] personas) {
        int n = personas.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (personas[j].getNombre().compareTo(personas[maxIdx].getNombre()) > 0) {
                    maxIdx = j;
                }
            }
            Persona temp = personas[maxIdx];
            personas[maxIdx] = personas[i];
            personas[i] = temp;
        }
    }

    public void sortByAgeWithInsertion(Persona[] personas) {
        int n = personas.length;
        for (int i = 1; i < n; i++) {
            Persona key = personas[i];
            int j = i - 1;
            while (j >= 0 && personas[j].getEdad() > key.getEdad()) {
                personas[j + 1] = personas[j];
                j--;
            }
            personas[j + 1] = key;
        }
    }

    public void sortByNameWithInsertion(Persona[] personas) {
        int n = personas.length;
        for (int i = 1; i < n; i++) {
            Persona key = personas[i];
            int j = i - 1;
            while (j >= 0 && personas[j].getNombre().compareTo(key.getNombre()) > 0) {
                personas[j + 1] = personas[j];
                j--;
            }
            personas[j + 1] = key;
        }
    }
}