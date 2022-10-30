/*
 * This file is part of NTNU's IDATA2302 Lab 06.
 *
 * Copyright (C) NTNU 2022
 * All rights reserved.
 *
 */

package no.ntnu.idata2302.lab06;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Before;
import org.junit.Test;

public class EDWithDPTest extends EditDistanceTest {

    @Before
    public void setUp() {
        implementation = new EDWithDP();
    }

}
