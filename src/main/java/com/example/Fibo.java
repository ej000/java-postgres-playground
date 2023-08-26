package com.example;
import java.util.*;

public class Fibo {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nº de termos desejado:");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println(fiboN(i) + " ");            
        }
    }
        
    public static int fiboN(int n){
        if (n <=1 )
            return n;
        else 
            return fiboN(n-1) + fiboN(n-2);
            
    }  
        
    
}

    

