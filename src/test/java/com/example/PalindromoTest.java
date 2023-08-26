package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PalindromoTest {
    @Test
    void VerificarPalindromoMaiscMinusc() {
        String palavra = "Arara";
        boolean esperado = true;
        boolean obtido = Palindromo.verificarPalindromo(palavra);

        assertEquals(esperado, obtido);
    }
}
