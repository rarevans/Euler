
package com.evans.collatzsequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class CollatzSequence {

    private int lookupSize;
    private final Map<Integer, Integer> sequences;
    
    public CollatzSequence(int lookupSize)
    {
        this.lookupSize = lookupSize;
        sequences = new HashMap<>();
        for (int candidate = 1; candidate <= lookupSize; ++candidate) {
            int length = lengthFor(candidate);
            sequences.put(candidate, length);
        }
    }
    
    public CollatzSequence()
    {
        this(10000);
    }
    
    public int lengthOf(int i)
    {
        long n = i;
        int length = 0;
        while (n > lookupSize) {            
            n = nextNumber(n);
            ++length;
        }

        length += sequences.get((int) n);

        return length;
    }
    
    static ArrayList<Long> of(long i)
    {
        ArrayList<Long> answer = new ArrayList<>();

        answer.add(i);
        
        while (i != 1) {
            i = nextNumber(i);
            answer.add(i);
        }
        return answer;
    }
    
    private static long nextNumber(long n)
    {
        if (n % 2L == 0) {
            return n >> 1;
        }
        else {
            return 3L * n + 1;
        }
    }
    
    static int lengthFor(int i)
    {
        long n = i;
        int length = 1;
        while (n != 1) {
            n = nextNumber(n);
            ++length;
        }
        
        return length;
    }

    Answer longestBelow(int limit)
    {
        int longestSequence = 1;
        int bestNumber = 1;
        for (int candidate = 2; candidate < limit; ++candidate) {
            int length = lengthOf(candidate);
            if (length > longestSequence) {
                longestSequence = length;
                bestNumber = candidate;
            }
        }
        
        return new Answer(bestNumber, longestSequence);
    }

    class Answer
    {
        private final int length;
        private final int number;

        public Answer(int number, int length)
        {
            this.number = number;
            this.length = length;
        }

        public int getLength()
        {
            return length;
        }

        public int getNumber()
        {
            return number;
        }
    }

}
