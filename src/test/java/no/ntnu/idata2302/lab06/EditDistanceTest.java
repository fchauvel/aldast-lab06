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
import org.junit.Ignore;
import org.junit.Test;

public abstract class EditDistanceTest {

    protected EditDistance implementation;

    @Test(timeout=100)
    public void dogToCatShouldBe3() {
        assertEquals(3, implementation.distance("dog", "cat"));
    }

    @Test(timeout=100)
    public void painToGainShouldBe1() {
        assertEquals(1, implementation.distance("pain", "gain"));
    }

    @Test(timeout=100)
    public void sundayToMondayShouldBe2() {
        assertEquals(2, implementation.distance("sunday", "monday"));
    }

    @Test(timeout=100)
    public void anythingToEmptyShouldAnythingsLength() {
        assertEquals(6, implementation.distance("sunday", ""));
        assertEquals(6, implementation.distance("", "sunday"));
    }

    @Test(timeout=100)
    public void anythingToItselfShouldBe0() {
        assertEquals(0, implementation.distance("sunday", "sunday"));
    }

    @Test(timeout=100)
    public void anywithWithPrefixShouldBeAnyThingMinusPrefixLength() {
        assertEquals(2, implementation.distance("sunday", "sund"));
    }

    @Test(timeout=100)
    public void anywithWithSuffixShouldBeAnyThingMinusSuffixLength() {
        assertEquals(2, implementation.distance("sunday", "nday"));
    }


    @Test(timeout=100)
    public void repeatingPatterns() {
        assertEquals(3, implementation.distance("sunsun", "sun"));
    }

    @Test(timeout=100)
    public void repeatingPatternsWithCommonPart() {
        assertEquals(6, implementation.distance("sundsun", "d"));
    }


    @Test(timeout=100)
    public void oneMoreTest() {
        assertEquals(2, implementation.distance("sunday", "suay"));
    }

    @Test(timeout=100)
    public void sameCharacterAtTheEnd() {
        assertEquals(1, implementation.distance("dot", "dog"));
    }

    @Test(timeout=100)
    public void oneSingleCommonCharacter() {
        assertEquals(3, implementation.distance("dir", "ode"));
    }



 }
