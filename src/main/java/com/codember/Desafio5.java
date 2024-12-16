package com.codember;

import java.util.ArrayList;
import java.util.Comparator;

public class Desafio5 {

    private static ArrayList<int[]> nodosSalvados;
    private static ArrayList<Integer> listaCumplen = new ArrayList<>();

    public static void main(String[] args) {

        Desafio4 desafio4 = new Desafio4();
        desafio4.inicia();
        nodosSalvados = desafio4.getNodosSalvador();

        System.out.println(nodosSalvados.size());

        for (int[] i : nodosSalvados) {
            for (int num : i) {
                if (isPrime(num)) {
                    String[] stringValue = String.valueOf(num).split("");
                    int total = 0;
                    for (String s : stringValue) {
                        total += Integer.parseInt(s);
                    }

                    if (isPrime(total)) {
                        // System.out.println(num + " ES PRIMO");
                        listaCumplen.add(num);
                    }
                }
            }
        }

        listaCumplen.sort(Comparator.naturalOrder());

        for (int i : listaCumplen)
            System.out.println(i);


            System.out.println("TOTAL QUE CUMPLEN -> "+listaCumplen.size());
            System.out.println("TERCER NUMERO -> "+listaCumplen.get(2));

    }

    public static boolean isPrime(int num) {

        if (num < 1)
            return false;

        if (num % 1 != 0)
            return false;

        if (num % num != 0)
            return false;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }

        }

        return true;

    }

}
