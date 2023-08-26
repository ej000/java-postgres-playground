package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FiboTest {
    @Test
    void FiboZero() {
        assertEquals(0, Fibo.fiboN(0));
    }
    @Test
    void FiboUm() {
        assertEquals(0, Fibo.fiboN(0));
    }
}
