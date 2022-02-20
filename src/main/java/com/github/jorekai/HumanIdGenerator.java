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


import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class HumanIdGenerator implements IHumanId {
    protected static List<String> animals = new ArrayList<>(Arrays.asList("ape", "baboon", "badger", "bat", "bear",
            "bird", "bobcat", "bulldog", "bullfrog", "cat", "catfish", "cheetah", "chicken", "chipmunk", "cobra", "cougar", "cow", "crab", "deer", "dingo", "dodo", "dog", "dolphin", "donkey", "dragon", "dragonfly", "duck", "eagle", "earwig", "eel", "elephant", "emu", "falcon", "fireant", "firefox", "fish", "fly", "fox", "frog", "gecko", "goat", "goose", "grasshopper", "horse", "hound", "husky", "impala", "insect", "jellyfish", "kangaroo", "ladybug", "liger", "lion", "lionfish", "lizard", "mayfly", "mole", "monkey", "moose", "moth", "mouse", "mule", "newt", "octopus", "otter", "owl", "panda", "panther", "parrot", "penguin", "pig", "puma", "pug", "quail", "rabbit", "rat", "rattlesnake", "robin", "seahorse", "sheep", "shrimp", "skunk", "sloth", "snail", "snake", "squid", "starfish", "stingray", "swan", "termite", "tiger", "treefrog", "turkey", "turtle", "vampirebat", "walrus", "warthog", "wasp", "wolverine", "wombat", "yak", "zebra"));
    protected static List<String> adjectives = new ArrayList<>(Arrays.asList("afraid", "ancient", "angry", "average",
            "bad", "big", "bitter", "black", "blue", "brave", "breezy", "bright", "brown", "calm", "chatty", "chilly", "clever", "cold", "cowardly", "cuddly", "curly", "curvy", "dangerous", "dry", "dull", "empty", "evil", "fast", "fat", "fluffy", "foolish", "fresh", "friendly", "funny", "fuzzy", "gentle", "giant", "good", "great", "green", "grumpy", "happy", "hard", "heavy", "helpless", "honest", "horrible", "hot", "hungry", "itchy", "jolly", "kind", "lazy", "light", "little", "loud", "lovely", "lucky", "massive", "mean", "mighty", "modern", "moody", "nasty", "neat", "nervous", "new", "nice", "odd", "old", "orange", "ordinary", "perfect", "pink", "plastic", "polite", "popular", "pretty", "proud", "purple", "quick", "quiet", "rare", "red", "rotten", "rude", "selfish", "serious", "shaggy", "sharp", "short", "shy", "silent", "silly", "slimy", "slippery", "smart", "smooth", "soft", "sour", "spicy", "splendid", "spotty", "stale", "strange", "strong", "stupid", "sweet", "swift", "tall", "tame", "tasty", "tender", "terrible", "thin", "tidy", "tiny", "tough", "tricky", "ugly", "unlucky", "warm", "weak", "wet", "white", "wicked", "wise", "witty", "wonderful", "yellow", "young"));
    protected static List<String> verbs = new ArrayList<>(Arrays.asList("be", "have", "do", "say", "go", "can", "get"
            , "would", "make", "know", "will", "think", "take", "see", "come", "could", "want", "look", "use", "find", "give", "tell", "work", "may", "should", "call", "try", "ask", "need", "feel", "become", "leave", "put", "mean", "keep", "let", "begin", "seem", "help", "talk", "turn", "start", "might", "show", "hear", "play", "run", "move", "like", "live", "believe", "hold", "bring", "happen", "must", "write", "provide", "sit", "stand", "lose", "pay", "meet", "include", "continue", "set", "learn", "change", "lead", "understand", "watch", "follow", "stop", "create", "speak", "read", "allow", "add", "spend", "grow", "open", "walk", "win", "offer", "remember", "love", "consider", "appear", "buy", "wait", "serve", "die", "send", "expect", "build", "stay", "fall", "cut", "reach", "kill", "remain"));
    protected static final Random random = new Random(new SecureRandom().nextInt());
    protected static final Integer SIZE_ANIMALS = animals.size();
    protected static final Integer SIZE_ADJECTIVES = adjectives.size();
    protected static final Integer SIZE_VERBS = verbs.size();

    protected Integer limit = 1000;
    protected HumanIdSeparator separator = HumanIdSeparator.EMPTY;

    protected String nextAdjective() {
        return adjectives.get(random.nextInt(SIZE_ADJECTIVES));
    }

    protected String nextAnimal() {
        return animals.get(random.nextInt(SIZE_ANIMALS));
    }

    protected String nextVerb() {
        return verbs.get(random.nextInt(SIZE_VERBS));
    }

    protected Integer nextNumber() {
        return random.nextInt(limit);
    }

    protected String camelize(final String word) {
        final String firstLetter = word.substring(0, 1);
        return word.replaceFirst(firstLetter, firstLetter.toUpperCase());
    }

    protected void setSeparator(HumanIdSeparator separator) {
        this.separator = separator;
    }

    protected void setLimit(Integer limit) {
        this.limit = limit;
    }

    protected Integer getLimit() {
        return limit;
    }

    protected HumanIdSeparator getSeparator() {
        return separator;
    }

    protected static HumanIdBuilder builder() {
        return new HumanIdBuilder();
    }

    public static class HumanIdBuilder {
        protected Integer limit = 1000;
        protected HumanIdSeparator separator = HumanIdSeparator.EMPTY;

        public HumanIdBuilder() {
        }

        public HumanIdBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        public HumanIdBuilder separator(HumanIdSeparator separator) {
            this.separator = separator;
            return this;
        }

        public HumanId build() {
            return new HumanId(this);
        }
    }
}
