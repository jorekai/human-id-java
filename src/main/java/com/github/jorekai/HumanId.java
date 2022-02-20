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
 * The type Human id.
 */
public class HumanId extends HumanIdGenerator {

    public HumanId(HumanIdBuilder humanIdBuilder) {
        super();
        this.limit = humanIdBuilder.limit;
        this.separator = humanIdBuilder.separator;
    }

    @Override
    public String generate() {
        final String sep = this.separator.getSeparator();
        return camelize(nextAdjective()) + sep + camelize(nextAnimal()) + sep + camelize(nextVerb());
    }

    @Override
    public String generate(final HumanIdStrategy strategy) {
        final String sep = separator.getSeparator();
        switch (strategy) {
            case NUMBERED:
                return camelize(nextAdjective()) + sep + camelize(nextAnimal()) + sep + camelize(nextVerb()) + sep + nextNumber();
            case EXHAUSTIVE:
                return nextNumber() + sep + camelize(nextAdjective()) + sep + camelize(nextAnimal()) + sep + camelize(nextVerb()) + sep + nextNumber();
            default:
                return generate();
        }
    }

    @Override
    public String generate(HumanIdSeparator separator) {
        setSeparator(separator);
        return generate();
    }

    @Override
    public String generate(HumanIdStrategy strategy, HumanIdSeparator separator) {
        setSeparator(separator);
        return generate(strategy);
    }
}
