/*
 * This file is part of NTNU's IDATA2302 Lab 06.
 *
 * Copyright (C) NTNU 2022
 * All rights reserved.
 *
 */
package no.ntnu.idata2302.lab06;

public class Sandbox {

    public static void main(String args[]) {
        switch (args[0]) {
        case "rec":
            System.out.println("Using recursion...");
            System.out.println(new EDWithRecursion().distance(args[1], args[2]));
            break;
        case "mem":
            System.out.println("Using memoization...");
            System.out.println(new EDWithMemoization().distance(args[1], args[2]));
            break;
        case "dpg":
            System.out.println("Using dynamic programming...");
            System.out.println(new EDWithDP().distance(args[1], args[2]));
            break;
        default:
            System.out.println("Using recursion...");
            System.out.println(new EDWithRecursion().distance(args[1], args[2]));
            break;
        }
    }

}
