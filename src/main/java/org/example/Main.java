package org.example;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[20];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100); // Números aleatorios entre 0 y 99
        }
        System.out.println("Arreglo generado: " + Arrays.toString(arr));

        // Elegir un número que sí esté y uno que no esté
        int valorPresente = arr[10]; // Tomamos un valor seguro del arreglo
        int valorAusente = -1;
        for (int v : arr) {
            if (v == valorAusente) {
                valorAusente = 200; // Aseguramos que no esté
                break;
            }
        }

        // Primero prueba busqueda lineal
        int resLinealPresente = busquedaLineal(arr, valorPresente);
        int resLinealAusente = busquedaLineal(arr, valorAusente);
        System.out.println("\nBúsqueda lineal (valor presente: " + valorPresente + ") -> Índice: " + resLinealPresente);
        System.out.println("Búsqueda lineal (valor ausente: " + valorAusente + ") -> Índice: " + resLinealAusente);

        // Segundo prueba búsqueda binaria
        int[] arrOrdenado = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arrOrdenado);
        int resBinariaPresente = busquedaBinaria(arrOrdenado, valorPresente);
        int resBinariaAusente = busquedaBinaria(arrOrdenado, valorAusente);
        System.out.println("\nArreglo ordenado: " + Arrays.toString(arrOrdenado));
        System.out.println("Búsqueda binaria (valor presente: " + valorPresente + ") -> Índice: " + resBinariaPresente);
        System.out.println("Búsqueda binaria (valor ausente: " + valorAusente + ") -> Índice: " + resBinariaAusente);

        // Tercero prueba búsqueda lineal con conteo de comparaciones
        int[] compLineal = {0};
        int resLinealPresenteC = busquedaLineal(arr, valorPresente, compLineal);
        System.out.println("\nBúsqueda lineal (valor presente: " + valorPresente + ") -> Índice: " + resLinealPresenteC + ", Comparaciones: " + compLineal[0]);
        compLineal[0] = 0;
        int resLinealAusenteC = busquedaLineal(arr, valorAusente, compLineal);
        System.out.println("Búsqueda lineal (valor ausente: " + valorAusente + ") -> Índice: " + resLinealAusenteC + ", Comparaciones: " + compLineal[0]);

        // Cuarto prueba búsqueda binaria con conteo de comparaciones
        int[] compBinaria = {0};
        int resBinariaPresenteC = busquedaBinaria(arrOrdenado, valorPresente, compBinaria);
        System.out.println("\nBúsqueda binaria (valor presente: " + valorPresente + ") -> Índice: " + resBinariaPresenteC + ", Comparaciones: " + compBinaria[0]);
        compBinaria[0] = 0;
        int resBinariaAusenteC = busquedaBinaria(arrOrdenado, valorAusente, compBinaria);
        System.out.println("Búsqueda binaria (valor ausente: " + valorAusente + ") -> Índice: " + resBinariaAusenteC + ", Comparaciones: " + compBinaria[0]);
    }

    // Quinto úsqueda lineal
    public static int busquedaLineal(int[] arr, int valor) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == valor) {
                return i;
            }
        }
        return -1;
    }

    // Sexto búsqueda binaria (el arreglo debe estar ordenado)
    public static int busquedaBinaria(int[] arr, int valor) {
        int inicio = 0, fin = arr.length - 1;
        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            if (arr[medio] == valor) {
                return medio;
            } else if (arr[medio] < valor) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return -1;
    }

    // Septimo búsqueda lineal con conteo de comparaciones
    public static int busquedaLineal(int[] arr, int valor, int[] comparaciones) {
        for (int i = 0; i < arr.length; i++) {
            comparaciones[0]++;
            if (arr[i] == valor) {
                return i;
            }
        }
        return -1;
    }

    // Octavo b21úsqueda binaria con conteo de comparaciones
    public static int busquedaBinaria(int[] arr, int valor, int[] comparaciones) {
        int inicio = 0, fin = arr.length - 1;
        while (inicio <= fin) {
            comparaciones[0]++;
            int medio = inicio + (fin - inicio) / 2;
            if (arr[medio] == valor) {
                return medio;
            } else if (arr[medio] < valor) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return -1;
    }
}
