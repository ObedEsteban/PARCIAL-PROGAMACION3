package Serie2;

import java.util.Random;

public class EscalerasYSerpientes {

    private static final int SIZE = 64;
    private static final int[] origenCasillasEspeciales = {7, 11, 31, 30, 40, 43, 50, 59};
    private static final int[] destinoCasillasEspeciales = {38, 37, 46, 2, 21, 60, 5, 42};

    public static void main(String[] args) {
        jugar();
    }

    public static void jugar() {
        Random dado = new Random();
        int[] jugadores = new int[2]; // Se supone que hay dos jugadores
        int jugadorActual = 0; // Índice del jugador actual
        int consecutivosSeis = 0; // Contador de seis consecutivos

        while (true) {
            int lanzamiento = dado.nextInt(6) + 1; // Lanzamiento del dado

            // Verificar si se ha obtenido un 6
            if (lanzamiento == 6) {
                consecutivosSeis++;
                if (consecutivosSeis == 3) {
                    jugadores[jugadorActual] = 0; // Regresar a la casilla inicial
                    consecutivosSeis = 0; // Reiniciar contador
                }
            } else {
                consecutivosSeis = 0; // Reiniciar contador si no se obtuvo un 6
            }

            // Mover ficha del jugador actual
            jugadores[jugadorActual] += lanzamiento;

            // Verificar si la ficha del jugador actual está en una casilla especial
            for (int i = 0; i < origenCasillasEspeciales.length; i++) {
                if (jugadores[jugadorActual] == origenCasillasEspeciales[i]) {
                    jugadores[jugadorActual] = destinoCasillasEspeciales[i];
                    break;
                }
            }

            // Verificar si el jugador ha ganado
            if (jugadores[jugadorActual] >= SIZE) {
                System.out.println("Jugador " + (jugadorActual + 1) + " ha ganado!");
                break;
            }

            // Cambiar al siguiente jugador
            jugadorActual = (jugadorActual + 1) % 2;
        }
    }
}
