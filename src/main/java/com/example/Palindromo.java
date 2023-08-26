package com.example;

public class Palindromo {
    public static void main(String[] args) {
        String palavra = "Arara";

        if (verificarPalindromo(palavra)){
            System.out.println("É palíndromo");
        }else{
            System.out.println("Não é palindromo");
        }
    }

    public static boolean verificarPalindromo(String palavra){
        palavra = palavra.toLowerCase();

        int inicio = 0;
        int fim = palavra.length() - 1;

        while (inicio < fim){
            if (palavra.charAt(inicio) != palavra.charAt(fim)){
                return false;
            }
            inicio++;
            fim--;
        }

        return true;
    }

}
