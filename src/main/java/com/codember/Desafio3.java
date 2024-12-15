package com.codember;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Desafio3 {

    private static ArrayList<int[]> integerList = new ArrayList<>();

    public static void main(String[] args) {

        BufferedReader readFile;
        try {
            readFile = new BufferedReader(new FileReader("./Desafio3.txt"));
            String[] row = readFile.lines().toArray(String[]::new);

            for (String s : row) {
                integerList.add(Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray());
            }

            int total = 0;
            int lastLine = 0;

            for (int i = 0; i < integerList.size(); i++) {
                int valueLine = getPasos(integerList.get(i));
                total += valueLine;

                if (i == integerList.size() - 1) {
                    lastLine = valueLine;
                }
            }

            System.out.println("TOTAL -> " + total);
            System.out.println("ÚLTIMA LÍNEA -> " + lastLine);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static int getPasos(int[] listaNumeros) {
        int count = 0;
        int index = 0;
        while (index < listaNumeros.length && index >= 0) {
            int oldIndex = index;
            index += listaNumeros[index];
            count++;
            listaNumeros[oldIndex] += 1;
        }

        return count;
    }

}
