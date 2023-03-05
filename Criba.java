import java.util.Arrays;
import java.util.Scanner;

public class Criba {

    /**
     * Inicializa un array para hacer la criba de Erastótenes para calcular primos
     * Pone a true todo el array salvo las dos primeras posiciones.
     * @param esPrimo Array que indica si su índice es primo o no
     */
    public static void inicializacion(boolean [] esPrimo) {
        Arrays.fill(esPrimo, true);
        esPrimo[0] = esPrimo[1] = false;
    }

    /**
     * Función que cuenta los números primos en un array (cada true es un primo)
     * @param esPrimo Array que indica si su índice es primo o no
     * @return devuelve el número de primos
     */
    public static int cuentaPrimos(boolean [] esPrimo) {
        int cuenta = 0;
        for (boolean b : esPrimo) {
            if (b)
                cuenta++;
        }
        return cuenta;
    }

    /**
     * Partiendo de un array de booleanos crea un array de primos
     * @param primos Array con los números primos
     * @param esPrimo Array que indica si su índice es primo o no
     */
    public static void rellenaPrimos(int []primos, boolean[] esPrimo) {
        for (int i = 0, j = 0; i < esPrimo.length; i++) {
            if (esPrimo[i])
                primos[j++] = i;
        }
    }

    /**
     * Implementación de la criba de Erastótenes
     * @param esPrimo Array que indica si su índice es primo o no
     */
    public static void criba(boolean []esPrimo) {
        for (int i = 2; i < Math.sqrt(esPrimo.length) + 1; i++) {
            if (esPrimo[i]) {
                for (int j = 2 * i; j < esPrimo.length; j += i)
                    esPrimo[j] = false;
            }
        }

    }

    /**
     * Genera primos hasta el valor max
     * @param max Valor máximo de los números primos a buscar
     * @return devuelve un array con los números primos
     */
    public static int[] generarPrimos(int max) {
        int[] primos;
        if (max >= 2) {
            boolean[] esPrimo = new boolean[max + 1];
            inicializacion(esPrimo);
            criba(esPrimo);
            int cuenta = cuentaPrimos(esPrimo);
            primos = new int[cuenta];
            rellenaPrimos(primos, esPrimo);

        } else {
            primos = new int[0];
        }
        return primos;
    }

    /**
     * Imprime por consola un vector
     * @param vector    Vector a imprimir de enteros
     * @param inicial   Indica si es el vector inicial o el vector de primos (se imprimen diferente)
     */
    public static void imprimirVector(int []vector, boolean inicial) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            if (inicial)
                System.out.print(i + 1 + "\t");
            else {
                System.out.print(vector[i] + "\t");
            }
        }

    }

    /**
     * Programa principal para el cálculo de primos usando la criba de Erastótenes
     * @param args  Argumentos por defecto en aplicación de consola
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato = teclado.nextInt();
        int[] vector = new int[dato];
        System.out.println("\nVector inicial hasta :" + dato);
        imprimirVector(vector, true);
        vector = generarPrimos(dato);
        System.out.println("\nVector de primos hasta:" + dato);
        imprimirVector(vector, false);
    }
}