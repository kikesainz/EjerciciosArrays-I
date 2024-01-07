package com.kike.arrays.utils;

import java.util.Scanner;

public class ArrayUtils {

	public static void mostrarValores(int[] array) {
	    for (int valor : array) {
	        System.out.println(valor);
	    }
	}

	public static int sumarElementos(int[] array) {
	    int suma = 0;
	    for (int valor : array) {
	        suma += valor;
	    }
	    return suma;
	}
	
    public static int encontrarMaximo(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("El array no puede estar vacío.");
        }

        int maximo = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maximo) {
                maximo = array[i];
            }
        }
        return maximo;
    }
    
    public static double calcularMedia(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("El array no puede estar vacío.");
        }

        int suma = 0;
        for (int valor : array) {
            suma += valor;
        }
        return (double) suma / array.length;
    }
    public  static void buscarElemento(int[] array, Scanner scanner) {
        System.out.print("Ingresa el número que quieres buscar: ");
        int numeroBuscado = scanner.nextInt();

        boolean encontrado = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == numeroBuscado) {
                System.out.println("Número encontrado en el índice: " + i);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Número no encontrado en el array.");
        }
    }
    
    public static void contarOcurrencias(int[] array, Scanner scanner) {
        System.out.print("Ingresa el número cuyas ocurrencias quieres contar: ");
        int numeroBuscado = scanner.nextInt();

        int contador = 0;
        for (int valor : array) {
            if (valor == numeroBuscado) {
                contador++;
            }
        }

        System.out.println("El número " + numeroBuscado + " aparece " + contador + " veces en el array.");
    }

    public static void invertirArray(int[] array) {
        int inicio = 0;
        int fin = array.length - 1;
        while (inicio < fin) {
            int temp = array[inicio];
            array[inicio] = array[fin];
            array[fin] = temp;
            inicio++;
            fin--;
        }
        mostrarValores(array);
    }
    
    public static int[] crearSegundoArray(int[] primerArray, Scanner scanner) {
        int[] segundoArray = new int[primerArray.length];
        System.out.println("Introduce " + primerArray.length + " números para el segundo array:");

        for (int i = 0; i < segundoArray.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            segundoArray[i] = scanner.nextInt();
        }
        return segundoArray;
    }

    public static boolean compararArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void ordenarArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (array[j] > array[j+1]) {
                    // Intercambiar array[j+1] y array[j]
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static int[] unirArrays(int[] array1, int[] array2) {
        int[] arrayUnido = new int[array1.length + array2.length];
        int posicion = 0;

        for (int valor : array1) {
            arrayUnido[posicion] = valor;
            posicion++;
        }

        for (int valor : array2) {
            arrayUnido[posicion] = valor;
            posicion++;
        }

        return arrayUnido;
    }



}
