import java.util.Scanner;

public class CuadroMagico {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el tamaño de la fila: ");
        int filas = scanner.nextInt();
        
        System.out.print("Ingrese el tamaño de la columna: ");
        int columnas = scanner.nextInt();

        System.out.println("    ");
        if (filas != columnas) {
            System.out.println("No es una matriz cuadrada.");
            System.out.println("El número de filas y columnas debe ser igual.");
        } else {
            System.out.println("Ingresa los valores de la Matriz Cuadrada: ");
            System.out.println("------------------------------------------");
            int[][] matriz = new int[filas][columnas];
            
            // Llenar la matriz y mostrar los valores ingresados
            llenarMatriz(matriz, scanner);

            // Mostrar la matriz en una tabla ordenada
            imprimirMatriz(matriz);
            
            // Verificar si es un cuadro mágico
            if (esCuadroMagico(matriz)) {
                System.out.println("    ");
                System.out.println("La matriz es un cuadro mágico con una constante de " + calcularConstante(matriz));
            } else {
                System.out.println("    ");
                System.out.println("La matriz no es un cuadro mágico.");
            }
        }
    }

    // Función para llenar la matriz con valores ingresados por el usuario
    public static void llenarMatriz(int[][] matriz, Scanner scanner) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("Coordenadas " + "[" + i  + "]" + "[" + j + "]" + ": ");
                matriz[i][j] = scanner.nextInt();
            }
        }
    }

    // Función para imprimir la matriz en una tabla ordenada
    public static void imprimirMatriz(int[][] matriz) {
        System.out.println("-----------------------");
        System.out.println("Matriz:");
        System.out.println("    ");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Función para verificar si la matriz es un cuadro mágico
    public static boolean esCuadroMagico(int[][] matriz) {
        int n = matriz.length;
        int constante = calcularConstante(matriz);
        
        // Verificar filas y columnas
        for (int i = 0; i < n; i++) {
            int sumaFila = 0;
            int sumaColumna = 0;
            for (int j = 0; j < n; j++) {
                sumaFila += matriz[i][j];
                sumaColumna += matriz[j][i];
            }
            if (sumaFila != constante || sumaColumna != constante) {
                return false;
            }
        }
        
        return true;
    }

    // Función para calcular la constante del cuadro mágico
    public static int calcularConstante(int[][] matriz) {
        int n = matriz.length;
        int constante = 0;
        for (int i = 0; i < n; i++) {
            constante += matriz[0][i];
        }
        return constante;
    }
}
