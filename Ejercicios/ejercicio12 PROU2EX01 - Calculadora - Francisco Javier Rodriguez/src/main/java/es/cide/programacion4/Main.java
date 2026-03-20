package es.cide.programacion4;

import java.util.Scanner;

//41663903R
//Francisco Javier Rodriguez
//Fecha 07/10/2025

public class Main {
    public static void main(String[] args) {
        // Declaro las variables que necesito
        double numero1 = 0;
        double numero2 = 0;
        double resultado = 0;
        int i = 0;
        Scanner sc = new Scanner(System.in); // Creamos el Scanner para luego preguntarle al usuario
        while (i < 1) { // Creo el while para que la calculadora no se pare hasta que el usuario lo pare
            // Creamos el menu
            System.out.println("----- Menú -----");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Salir\n");
            System.out.println("Selecciona una de las opciones");
            int operador = sc.nextInt(); // Le pedimos al usuario que elija una operacion
            if (operador >= 1 && operador <= 4) { // Creo un if con una condicion que hace que solo pase el 1 hasta el 4
                // Preguntamos los valores
                System.out.println("Introduce el primer numero");
                numero1 = sc.nextInt();
                System.out.println("Introduce el segundo numero");
                numero2 = sc.nextInt();
            } else { // Si no se da la condicion se cierra la calculadora siempre
                System.out.println("Has salido de la calculadora");
                i++; // Hace que la variable que inica el while llege a la condicion del while y lo
                     // pare
            }
            switch (operador) { // Creamos este switch para cada caso que haya elegido el usuario
                case 1: // sumar
                    resultado = numero1 + numero2; // Hace la operacion indicada entre los numeros
                    // Imprimimos el resultado
                    System.out.println("El Resultado es: " + resultado);
                    break;
                case 2: // restar
                    resultado = numero1 - numero2;
                    System.out.println("El Resultado es: " + resultado);
                    break;
                case 3: // multiplicar
                    resultado = numero1 * numero2;
                    System.out.println("El Resultado es: " + resultado);
                    break;
                case 4: // dividir
                    if (numero2 == 0) { // Marco un if por si el numero es 0 para que le vuelva a preguntar al usuario
                                        // por otro numero
                        while (numero2 == 0) { // Hago el while para forzar al usuario a que escoja otro numero que no
                                               // sea el 0
                            System.out.println("Introduce un numero que no sea 0");
                            numero2 = sc.nextInt();
                        }
                        // Para cuando salga del while haga la operacion con el numero nuevo
                        resultado = numero1 / numero2;
                        System.out.println("El Resultado es: " + resultado);
                        break;
                    } else { // Utilizo el Else por si el numero2 es otro numero haga la operacion
                             // directamente
                        resultado = numero1 / numero2;
                        System.out.println("El Resultado es: " + resultado);
                        break;
                    }
            }
        }sc.close();
    }
}