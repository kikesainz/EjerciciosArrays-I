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
    // Método para mostrar los elementos del array de forma recursiva
	// 
    public static void mostrarElementosRecursivo(int[] array, int index) {
        // Caso base: si index es menor que cero devuelve
        if (index < 0) {
            return;
        }
        // Muestra el elemento actual
        
        // Llama recursivamente al método incrementando el índice
        mostrarElementosRecursivo(array, index  - 1);
        System.out.println(array[index]);
    }
    
    public static void mostrarElementosRecursivo2(int[] array, int index) {
        // Caso base: si index es igual a la longitud del array, termina la recursión
        if (index == array.length) {
            return;
        }
        // Muestra el elemento actual
        System.out.println(array[index]);
        // Llama recursivamente al método incrementando el índice
        mostrarElementosRecursivo2(array, index + 1);
    }
	//llamarlo con el array.length-1
    public static int sumaRecursiva(int[] array, int n) {
        // Caso base: si n es 0, retorna 0
        if (n < 0) {
            return 0;
        }
        // Paso recursivo: suma el último elemento y llama a la función con n-1
        return sumaRecursiva(array, n - 1) + array[n];
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
    
    // Método para encontrar el máximo de forma recursiva
    //hay que llamarlo con array.length - 1
    public static int encontrarMaximo(int[] array, int n) {
        // Caso base: si el array tiene solo un elemento, retorna ese elemento
        if (n == 0) {
            return array[0];
        }
        // Encuentra el máximo en la parte restante del array
        int max = encontrarMaximo(array, n -1 );
        // Compara el máximo encontrado con el elemento actual y retorna el mayor
        return Math.max(max, array[n]);
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
    


    // Método para calcular la media aritmética
    public static double calcularMediaRecursiva(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("El array no puede estar vacío");
        }
        int suma = sumaRecursiva(array, array.length);
        return (double) suma / array.length;
    }
    
//    En este código, el método buscarElementoRecursivo busca el elementoABuscar en el array, 
//    comenzando desde el indice proporcionado. Si encuentra el elemento, 
//    retorna true; si llega al final del array sin encontrarlo,
//    retorna false. La función se llama a sí misma con el índice incrementado en 1 en cada paso, l
//    o que le permite recorrer el array de manera recursiva. (la llamada se hace con el índice a cero.
    
    public static boolean buscarElementoRecursivo(int[] array, int elementoABuscar, int indice) {
        // Caso base: si se llega al final del array sin encontrar el elemento
        if (indice >= array.length) {
            return false;
        }
        // Si el elemento actual es el que se busca, retorna true
        if (array[indice] == elementoABuscar) {
            return true;
        }
        // Llamada recursiva con el siguiente índice
        return buscarElementoRecursivo(array, elementoABuscar, indice + 1);
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
    
    // Método para contar ocurrencias de un elemento de forma recursiva
    public static int contarOcurrenciasRecursivo(int[] array, int elementoABuscar, int indice) {
        // Caso base: si se llega al final del array
        if (indice >= array.length) {
            return 0;
        }
        // Comprobar si el elemento actual es el que se busca
        int conteoEnEsteIndice = (array[indice] == elementoABuscar) ? 1 : 0;
        // Llamada recursiva para el resto del array
        return conteoEnEsteIndice + contarOcurrenciasRecursivo(array, elementoABuscar, indice + 1);
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
    
//    En este código, el método invertirRecursivamente toma tres parámetros: 
//    	el array a invertir, un índice inicial (0 para empezar) y un índice final 
//    	(longitud del array menos 1). La función se llama a sí misma, 
//    	intercambiando los elementos en los índices inicio y fin en cada llamada, 
//    	y luego actualizando estos índices para acercarse al centro del array. 
//    	La recursión se detiene cuando los índices se cruzan o son iguales, 
//    	lo que significa que se ha alcanzado o pasado el centro del array.    
    
    public static void invertirRecursivamente(int[] array, int inicio, int fin) {
        // Caso base: si los índices se cruzan o son iguales, termina la recursión
        if (inicio >= fin) {
            return;
        }
        // Intercambiar los elementos
        int temp = array[inicio];
        array[inicio] = array[fin];
        array[fin] = temp;

        // Llamada recursiva con índices actualizados
        invertirRecursivamente(array, inicio + 1, fin - 1);
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
