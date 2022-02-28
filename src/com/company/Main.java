package com.company;

import java.util.Scanner;

public class Main {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Not sut = new Opn();
        String strIn = in.nextLine();
       System.out.println( sut.treatmentResult(strIn));


    }
}