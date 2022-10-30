/*
 * This file is part of NTNU's IDATA2302 Lab 06.
 *
 * Copyright (C) NTNU 2022
 * All rights reserved.
 *
 */

package no.ntnu.idata2302.lab06;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EDWithRecursionTest extends EditDistanceTest {

    @Before
    public void setUp() {
        implementation = new EDWithRecursion();
    }
}
