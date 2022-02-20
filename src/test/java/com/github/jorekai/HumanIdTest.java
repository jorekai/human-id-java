/*
 * Copyright (c) 2022 Nils Jorek
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE
 * OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.github.jorekai;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class HumanIdTest {
    private static final String REGEX_CONTAINS_ONLY_LETTERS = "[a-zA-Z]+";
    private static final String REGEX_DEFAULT_ID_MATCHES_FORMAT = "([A-Z]\\D+[A-Z]\\D+[A-Z]\\D+){1}\\Z";
    private static final String REGEX_ID_NUMBERED = "([A-Z]\\D+[A-Z]\\D+[A-Z]\\D+){1}\\d+\\Z";
    private static final String REGEX_ID_EXHAUSTIVE = "\\d+([A-Z]\\D+[A-Z]\\D+[A-Z]\\D+){1}\\d+\\Z";
    private static final String REGEX_CONTAINS_NUMBER_AT_END = "[a-zA-Z]*\\d+.*";
    private static final String REGEX_ID_WITH_SEPARATOR = "([A-Z][a-z]+[-.~#][A-Z][a-z]+[-.~#][A-Z][a-z]+){1}\\z";
    private static final String REGEX_ID_WITH_SEPARATOR_NUMBERED = "([A-Z][a-z]+[-.~#][A-Z][a-z]+[-.~#][A-Z][a-z]+[-.~#])" +
            "{1}\\d+\\z";
    private final HumanId defaultHumanId = HumanId.builder().build();

    @Test
    public void defaultGenerator_shouldWorkAsExpected() {
        String generatedId = defaultHumanId.generate();
        assertNotNull(generatedId);
        assertTrue(generatedId.matches(REGEX_CONTAINS_ONLY_LETTERS));
        assertTrue(generatedId.matches(REGEX_DEFAULT_ID_MATCHES_FORMAT));
        assertFalse(generatedId.contains(" "));
        assertFalse(generatedId.matches(REGEX_CONTAINS_NUMBER_AT_END));
    }

    @Test
    public void strategyGeneratorWithNumber_shouldWorkAsExpected() {
        String generatedId = defaultHumanId.generate(HumanIdStrategy.NUMBERED);
        assertNotNull(generatedId);
        assertTrue(generatedId.matches(REGEX_ID_NUMBERED));
        assertFalse(generatedId.contains(" "));
    }

    @Test
    public void strategyGeneratorWithExhaustive_shouldWorkAsExpected() {
        String generatedId = defaultHumanId.generate(HumanIdStrategy.EXHAUSTIVE);
        assertNotNull(generatedId);
        assertTrue(generatedId.matches(REGEX_ID_EXHAUSTIVE));
        assertFalse(generatedId.contains(" "));
    }

    @Test
    public void strategyGeneratorWithSeparator_shouldWorkAsExpected() {
        String generatedId = defaultHumanId.generate(HumanIdSeparator.DASH);
        assertNotNull(generatedId);
        assertTrue(generatedId.matches(REGEX_ID_WITH_SEPARATOR));
        assertTrue(generatedId.contains("-"));
    }

    @Test
    public void strategyGeneratorWithSeparatorAndStrategy_shouldWorkAsExpected() {
        String generatedId = defaultHumanId.generate(HumanIdStrategy.NUMBERED, HumanIdSeparator.DASH);
        assertNotNull(generatedId);
        assertTrue(generatedId.matches(REGEX_ID_WITH_SEPARATOR_NUMBERED));
        assertTrue(generatedId.contains("-"));
    }

    @Test
    public void humanIdGenerator_ShouldBeInitializedAsExpected() {
        assertNotNull(defaultHumanId.getLimit());
        assertNotNull(defaultHumanId.getSeparator());
        assertEquals(1000, (int) defaultHumanId.getLimit());
        assertEquals("", defaultHumanId.getSeparator().getSeparator());
    }

}