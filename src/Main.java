import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        char[][] matriz = new char[10][10];

        for (int filas = 0; filas < 10; filas++) {
            for (int columnas = 0; columnas < 10; columnas++) {
                matriz[filas][columnas] = '*';
            }
        }

        char ROBOT = 'R';
        matriz[0][0] = ROBOT;
        char META = 'M';
        matriz[9][9] = META;


        Random random = new Random();
        int filaAleatoria;
        int columnaAleatoria;
        int filaAleatoria2;
        int columnaAleatoria2;
        do {
            filaAleatoria = random.nextInt(10);
            columnaAleatoria = random.nextInt(10);
        } while (matriz[filaAleatoria][columnaAleatoria] != '*');
        matriz[filaAleatoria][columnaAleatoria] = 'B';
        for (int i = 0; i < 5; i++) {
            do {
                filaAleatoria2 = random.nextInt(10);
                columnaAleatoria2 = random.nextInt(10);
            } while (matriz[filaAleatoria2][columnaAleatoria2] != '*');
            matriz[filaAleatoria2][columnaAleatoria2] = 'X';


        }
        for (int filas = 0; filas < 10; filas++) {
            for (int columnas = 0; columnas < 10; columnas++) {
                System.out.print(matriz[filas][columnas] + " ");
            }
            System.out.println();
        }




        int vidas = 10;
        int filaY = 0;
        int columnaY = 0;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Dime una letra para moverte por el tableroS");
            char desplazamiento = sc.next().charAt(0);

            if (desplazamiento == 'D') {
                matriz[filaY][columnaY] = '*';
                columnaY++;



                if (matriz[filaY][columnaY] == 'X') {
                    System.out.println("Movimiento bloqueado");
                    columnaY--;
                }
                if (matriz[filaY][columnaY] == 'B') {
                    vidas = vidas + 2;
                    System.out.println("Ahora tienes " + vidas + " vidas");
                }
                if (matriz[filaY][columnaY] == 'M') {
                    System.out.println("Rescate completado!!!");
                }
                if (desplazamiento != 'D') {
                    System.out.println("Letra equivocada");
                }
                matriz[filaY][columnaY] = ROBOT;


            }

            if (desplazamiento == 'A') {
                matriz[filaY][columnaY] = '*';
                columnaY--;
                if ((columnaY - 1) < 0) {
                    System.out.println("Estas fuera de los límites");
                    columnaY = 0;
                }
                if (matriz[filaY][columnaY] == 'X') {
                    System.out.println("Movimiento bloqueado");
                    columnaY--;
                }
                if (matriz[filaY][columnaY] == 'B') {
                    vidas = vidas + 2;
                    System.out.println("Ahora tienes " + vidas + " vidas");
                }
                if (matriz[filaY][columnaY] == 'M') {
                    System.out.println("Rescate completado!!!");
                }
                matriz[filaY][columnaY] = ROBOT;
            }

            if (desplazamiento == 'W') {
                matriz[filaY][columnaY] = '*';
                filaY--;

                if (matriz[filaY][columnaY] == 'X') {
                    System.out.println("Movimiento bloqueado");
                    filaY--;
                }
                if (matriz[filaY][columnaY] == 'B') {
                    vidas = vidas + 2;
                    System.out.println("Ahora tienes " + vidas + " vidas");
                }
                if (matriz[filaY][columnaY] == 'M') {
                    System.out.println("Rescate completado!!!");
                }
                matriz[filaY][columnaY] = ROBOT;
            }

            if (desplazamiento == 'S') {
                matriz[filaY][columnaY] = '*';
                filaY++;

                if (matriz[filaY][columnaY] == 'X') {
                    System.out.println("Movimiento bloqueado");
                    filaY--;
                }
                if (matriz[filaY][columnaY] == 'B') {
                    vidas = vidas + 2;
                    System.out.println("Ahora tienes " + vidas + " vidas");
                }
                if (matriz[filaY][columnaY] == 'M') {
                    System.out.println("Rescate completado!!!");
                }
                matriz[filaY][columnaY] = ROBOT;
            }

            if ((columnaY+1)>9) {
                System.out.println("FUERA DE LIMITES!!!!");
            }
            if ((filaY+1)>9) {
                System.out.println("FUERA DE LIMITES!!!!");
            }
            if (desplazamiento != 'D' && desplazamiento != 'S' && desplazamiento != 'W' && desplazamiento != 'A') {
                System.out.println("Letra equivocada");
            }



            for (int filas = 0; filas < 10; filas++) {
                for (int columnas = 0; columnas < 10; columnas++) {
                    System.out.print(matriz[filas][columnas] + " ");
                }
                System.out.println();
            }

        } while (vidas != 0) ;
    }
}