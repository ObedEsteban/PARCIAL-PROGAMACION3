package Serie2;

import java.util.ArrayList;
import java.util.List;

public class PosicionesAdyacentes {

    public static void main(String[] args) {
        int[][] matriz = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int fila = 1;
        int columna = 1;

        List<int[]> adyacentes = obtenerPosicionesAdyacentes(matriz, fila, columna);

        System.out.println("Posiciones adyacentes a (" + fila + ", " + columna + "):");
        for (int[] posicion : adyacentes) {
            System.out.println("(" + posicion[0] + ", " + posicion[1] + ")");
        }
    }

    public static List<int[]> obtenerPosicionesAdyacentes(int[][] matriz, int fila, int columna) {
        List<int[]> adyacentes = new ArrayList<>();

        // Coordenadas de las posiciones adyacentes: arriba, abajo, izquierda, derecha
        int[][] direcciones = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] direccion : direcciones) {
            int nuevaFila = fila + direccion[0];
            int nuevaColumna = columna + direccion[1];

            // Verificar si la nueva posición es válida
            if (nuevaFila >= 0 && nuevaFila < matriz.length && nuevaColumna >= 0 && nuevaColumna < matriz[0].length) {
                adyacentes.add(new int[]{nuevaFila, nuevaColumna});
            }
        }

        return adyacentes;
    }
}
