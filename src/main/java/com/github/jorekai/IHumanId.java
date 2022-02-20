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

/**
 * The interface Human id. A Generic human-readable id Generator
 */
public interface IHumanId {
    /**
     * Generate the default human-readable id.
     *
     * @return the default human-readable id in the format of "PreciousDogCreator" or "Precious-Dog-Creator"
     */
    String generate();

    /**
     * Generate the human-readable id with a strategy.
     *
     * @param strategy the strategy which can be used to generate an id. Currently, supports (NUMBERED, EXHAUSTIVE)
     * @return the default human-readable id in the format of "PreciousDogCreator420" or "Precious-Dog-Creator-420" or
     * "420-Precious-Dog-Creator-420"
     */
    String generate(HumanIdStrategy strategy);

    /**
     * Generate the human-readable id with a separator.
     *
     * @param separator the separator which can be used to generate an id. Currently, supports (
     *                  EMPTY(""),
     *                  DASH("-"),
     *                  TILDE("~"),
     *                  HASH("#"),
     *                  DOT(".")
     *                  )
     * @return the default human-readable id in the format of "Precious~Dog~Creator~420" or
     * "Precious-Dog-Creator-420" or
     * "Precious*Dog*Creator*420"
     */
    String generate(HumanIdSeparator separator);

    /**
     * Generate the human-readable id with a separator and strategy.
     *
     * @param strategy  the strategy which can be used to generate an id. Currently, supports (NUMBERED, EXHAUSTIVE)
     * @param separator the separator which can be used to generate an id. Currently, supports (
     *                  EMPTY(""),
     *                  DASH("-"),
     *                  TILDE("~"),
     *                  HASH("#"),
     *                  DOT(".")
     *                  )
     * @return the default human-readable id in the format of "Precious~Dog~Creator~420" or
     * "Precious-Dog-Creator-420" or
     * "Precious*Dog*Creator*420"
     */
    String generate(HumanIdStrategy strategy, HumanIdSeparator separator);
}
