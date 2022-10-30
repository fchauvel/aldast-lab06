/*
 * This file is part of NTNU's IDATA2302 Lab 06.
 *
 * Copyright (C) NTNU 2022
 * All rights reserved.
 *
 */

package no.ntnu.idata2302.lab06;

import java.nio.charset.Charset;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Benchmark {

    static int LENGTHS[] = new int[] { 5, 10, 50, 100, 500, 1000 };

    public static void main(String args[]) {
        System.out.printf("%6s %15s %15s %15s\n", "Length", "Recursion", "Memoization", "Dyn. Prog");
        System.out.printf("%6s %10s %4s %10s %4s %10s %4s\n", "", "time", "ED", "time", "ED", "time", "ED");
        for (int i = 0; i < LENGTHS.length; i++) {
            String left = randomString(LENGTHS[i]);
            String right = randomString(LENGTHS[i]);

            System.out.printf("%6d ", LENGTHS[i]);
            var withRecursion = runOne(new Run(new EDWithRecursion(), left, right));
            System.out.printf("%s ", withRecursion);
            var withMemoization = runOne(new Run(new EDWithMemoization(), left, right));
            System.out.printf("%s ", withMemoization);
            var withDP = runOne( new Run(new EDWithDP(), left, right));
            System.out.printf("%s\n", withDP);
        }
    }

    static String randomString(int length) {
        byte[] array = new byte[length];
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }

    static String runOne(Run run) {
        ExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        long start = System.currentTimeMillis();
        Future<Integer> future = executor.submit(run);
        try {
            Integer distance = future.get(20, TimeUnit.SECONDS);
            long end = System.currentTimeMillis();
            return String.format("%10d %4d", end - start, distance);

        } catch (TimeoutException ex) {
            return String.format("%10s %4s", "timeout", "n/a");

        } catch (InterruptedException e) {
            return String.format("%10s %4s", "interrupt", "n/a");

        } catch (Exception e) {
            return String.format("%10s %4s", "error", "n/a");

        } finally {
            executor.shutdown();

        }
    }

}



class Run implements Callable<Integer> {

    private final EditDistance strategy;
    private final String left;
    private final String right;

    Run(EditDistance strategy, String left, String right) {
        this.strategy = strategy;
        this.left = left;
        this.right = right;
    }

    @Override
    public Integer call()  throws InterruptedException {
        return strategy.distance(left, right);
    }

}
