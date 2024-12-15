package com.codember;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Desafio2 {

    public static int ciertas = 0;
    public static int noCiertas = 0;

    public static void main(String[] args) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./desafio2.txt"));
            String[] lines = bufferedReader.lines().toArray(String[]::new);
            bufferedReader.close();

            for (String s : lines) {
                if (checkRegex(s)) {
                    ciertas++;
                } else {
                    noCiertas++;
                }
            }

            System.out.println("VERDADERAS -->"+ciertas);
            System.out.println("NO VERDADERAS -->"+noCiertas);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static boolean checkRegex(String linea) {
        Pattern pattern = null;
        Matcher matcher = null;
        String patron = "^(\\d)*[a-z]*";

        if (!Pattern.matches(patron, linea)) {
            return false;
        }

        patron = "\\d+";

        pattern = Pattern.compile(patron);
        matcher = pattern.matcher(linea);

        String numeros = "";

        while (matcher.find()) {
            numeros = matcher.group(0);
        }

        int[] listaNumeros = new String(numeros).chars().map(Character::getNumericValue).toArray();

        for (int i = 0; i < listaNumeros.length - 1; i++) {
            if (listaNumeros[i] > listaNumeros[i + 1]) {
                return false;
            }
        }

        patron = "[a-z]";

        pattern = Pattern.compile(patron);
        matcher = pattern.matcher(linea);

        List<String> listaLetras = new ArrayList<>();

        while (matcher.find()) {
            listaLetras.add(matcher.group());
        }

        for (int i = 0; i < listaLetras.size() - 1; i++) {
            int resultado = listaLetras.get(i).compareTo(listaLetras.get(i + 1));
            if (resultado > 0) {
                return false;
            }
        }

        return true;
    }

}
