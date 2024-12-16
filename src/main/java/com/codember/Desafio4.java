package com.codember;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Desafio4 {

    private ArrayList<int[]> listaNodos = new ArrayList<>();
    private ArrayList<int[]> nodosSalvador = new ArrayList<>();

    public static void main(String[] args) {

    }

    public void inicia() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./desafio4.txt"));
            String[] filas = bufferedReader.lines().toArray(String[]::new);
            Pattern pattern = Pattern.compile("(\\d+)");
            Matcher matcher = null;

            for (String fila : filas) {
                int valor1 = 0, valor2 = 0;
                int count = 0;
                for (String s : fila.split(",")) {

                    matcher = pattern.matcher(s);

                    while (matcher.find()) {
                        if (count == 0) {
                            valor1 = Integer.parseInt(matcher.group());
                        }

                        if (count == 1) {
                            valor2 = Integer.parseInt(matcher.group());
                            int[] parejaValoresLinea = { valor1, valor2 };
                            listaNodos.add(parejaValoresLinea);
                        }

                        count++;
                    }
                    if (count == 2) {
                        count = 0;
                    }
                }
            }

            for (int[] a : listaNodos) {
                boolean match = true;
                for (int[] b : listaNodos) {
                    if ((a[0] == b[0] | a[1] == b[0] | a[0] == b[1] | a[1] == b[1]) && a != b) {
                        match = false;
                    }
                }

                if (match) {
                    nodosSalvador.add(a);
                }
            }

            // System.out.println("NODOS TOTALES -> " + listaNodos.size() * 2);
            // System.out.println("NODOS LIBRES -> " + nodosSalvador.size() * 2);
            // System.out.println("LISTA DE NODOS LIBRES:");
            // for (int[] i : nodosSalvador) {
            //     for (int e : i)
            //         System.out.print(e + ",");
            // }

        } catch (

        FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public ArrayList<int[]> getNodosSalvador() {
        return nodosSalvador;
    }

}
