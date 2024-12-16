package com.codember;

public class Desafio1 {

    // private static final String INFORMACION = "000 URURD"; //test
    // private static final String INFORMACION = "1111 UUURUUU"; //test
    // private static final String INFORMACION = "9999 LULULULD"; //test
    // private static final String INFORMACION = "528934712834 URDURUDRUDLLLLUUDDUDUDUDLLRRRR";
    private static final String INFORMACION = "528934712834 URDURUDRUDLLLLUUDDUDUDUDLLRRRR";

    private static int[] combinacion;
    private static char[] pasosDesbloqueo;
    private static int indeceActualCombinacion = 0;

    public static void main(String[] args) {

        String[] opciones = INFORMACION.split(" ");

        combinacion = new String(opciones[0]).chars().map(Character::getNumericValue).toArray();
        pasosDesbloqueo = opciones[1].toCharArray();

        for (int i = 0; i < pasosDesbloqueo.length; i++) {
            desbloqueando(pasosDesbloqueo[i], i);
        }

        System.out.print("COMBINACIÓN --> ");
        for (int i : combinacion) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static void desbloqueando(char c, int indice) {
        switch (c) {
            case 'U':
                if (combinacion[indeceActualCombinacion] == 9) {
                    combinacion[indeceActualCombinacion] = 0;
                    return;
                }

                combinacion[indeceActualCombinacion] += 1;
                break;
            case 'D':
                if (combinacion[indeceActualCombinacion] == 0) {
                    combinacion[indeceActualCombinacion] = 9;
                    return;
                }
                combinacion[indeceActualCombinacion] -= 1;
                break;
            case 'L':
                if (indeceActualCombinacion == 0) {
                    indeceActualCombinacion = combinacion.length - 1;
                    return;
                }
                indeceActualCombinacion--;
                break;
            case 'R':
                if (indeceActualCombinacion == combinacion.length - 1) {
                    indeceActualCombinacion = 0;
                    return;
                }

                indeceActualCombinacion++;
                break;

            default:
                break;
        }

    }

}
