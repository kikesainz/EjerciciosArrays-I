package com.kike.arrays.principal;



import java.util.Random;
import java.util.Scanner;

import com.kike.arrays.utils.ArrayUtils;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Cuántos números deseas introducir? ");
        int cantidad = scanner.nextInt();

        int[] numeros = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
        	Random rand = new Random();
        	int x = rand.nextInt(100);
            System.out.println("Introduciendo número  " + x + " en la posición: " + (i + 1));
            numeros[i] = x;
        }

        while (true) {
            System.out.println("\nElige una opción:");
            System.out.println("1. Recorrer el array y mostrar sus valores en la consola\r\n"
            		+ "2. Sumar los elementos del array\r\n"
            		+ "3. Encontrar el máximo.\r\n"
            		+ "4. Calcular la media.\r\n"
            		+ "5. Buscar un elemento.\r\n"
            		+ "6. Contar ocurrencias de un elemento.\r\n"
            		+ "7. Invertir el array (y luego imprimirlo).\r\n"
            		+ "8. Pedir el mismo número de elementos que el anterior elegido para crear otro array y luego compararlos.\r\n"
            		+ "9. Ordenar el array.\r\n"
            		+ "10. Unir dos arrays (para ello el programa tiene que pedir números para crear otro array)");
            //... aquí van las demás opciones
            System.out.println("11. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    ArrayUtils.mostrarValores(numeros);
                    ArrayUtils.mostrarElementosRecursivo(numeros, numeros.length-1);
                    ArrayUtils.mostrarElementosRecursivo2(numeros, 0);
                    break;
                case 2:
                    System.out.println("Suma: " + ArrayUtils.sumarElementos(numeros));
                    System.out.println("Suma: " + ArrayUtils.sumaRecursiva(numeros, numeros.length-1));
                    break;
                case 3:
                    System.out.println("El máximo es: " + ArrayUtils.encontrarMaximo(numeros));
                    System.out.println("El máximo es: " + ArrayUtils.encontrarMaximo(numeros, numeros.length-1));
                    break;
                case 4:
                    System.out.println("La media es: " + ArrayUtils.calcularMedia(numeros));
                    break;
                case 5:
                     ArrayUtils.buscarElemento(numeros, scanner);
                     System.out.println("Dígame número a buscar");
                     Integer numeroABuscar = scanner.nextInt();
                     scanner.nextLine();
                     System.out.println(ArrayUtils.buscarElementoRecursivo(numeros, numeroABuscar, 0));
                    break;
                case 6:
                	
                    ArrayUtils.contarOcurrencias(numeros, scanner);
                    System.out.println("Dígame número a buscar");
                    Integer numeroAContarOcurrencias = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(ArrayUtils.contarOcurrenciasRecursivo(numeros, numeroAContarOcurrencias, 0));
       
                    
                    break;
                case 7:
//                	ArrayUtils.invertirArray(numeros);
                	ArrayUtils.invertirRecursivamente(numeros, 0, numeros.length-1);
                	ArrayUtils.mostrarValores(numeros);
                    break;
                case 8:
                    int [] segundoArray = ArrayUtils.crearSegundoArray(numeros, scanner);
                   
                    if (ArrayUtils.compararArrays(numeros, segundoArray)) {
                        System.out.println("Los arrays son iguales.");
                    } else {
                        System.out.println("Los arrays no son iguales.");
                    }
                    break;
               
                case 9:
                	ArrayUtils.ordenarArray(numeros);
                	ArrayUtils.mostrarValores(numeros);
                    break;
                case 10:
                	 int [] tercerArray = ArrayUtils.crearSegundoArray(numeros, scanner);
                	 int [] arrayUnido = ArrayUtils.unirArrays(numeros, tercerArray);
                	 ArrayUtils.mostrarValores(arrayUnido);
                    break;
                case 11:
                    System.out.println("Saliendo del programa.");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
    

  
}
