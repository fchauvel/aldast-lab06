/*
 * This file is part of NTNU's IDATA2302 Lab 06.
 *
 * Copyright (C) NTNU 2022
 * All rights reserved.
 *
 */
package no.ntnu.idata2302.lab06;

public interface EditDistance {

    /**
     * Compute the Levenshtein distance between the two given
     * texts. The Levenshtein distance consider three types of
     * edition: Addition, deletion and substitution of characters.
     *
     * @param source the first piece of text to compare
     * @param target the second piece of text to compare
     * @return the minimum number of editions needed to transform the
     * left string to the right string.
     */
    int distance(String source, String target);

}
