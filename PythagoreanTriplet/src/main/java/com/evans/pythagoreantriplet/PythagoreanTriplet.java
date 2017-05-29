package com.evans.pythagoreantriplet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 */
public class PythagoreanTriplet {

    private int sum;
    private int a;
    private int b;
    private int c;
    private int product;

    /**
     * A Pythagorean triplet is three numbers that satisfy three equations
     * 
     *  a^2 + b^2 = c^2 and a < b < c and a + b + c = sum
     * @param sum 
     */
    PythagoreanTriplet(int sum) throws IllegalArgumentException
    {
        if (sum <= 0) {
            throw new IllegalArgumentException("negative sum for Pythagorean triplets won't work.");
        }
        
        this.sum = sum;
        a = 1;
        b = 2;
        c = 3;
        
        product = a * b * c;
    }

    /**
     * Calculate values for a, b and c that satisfy the three properties of
     * Pythagorean Triplet. The values of a, b, c and product are only correct
     * if find returns success.
     * 
     * @return Whether values of a, b and c were found that satisfy the equations.
     */
    public boolean find()
    {
        return linearEvaluate();
    }

    private boolean linearEvaluate()
    {
        
        for (int i = a; i < sum - 2; ++i) {
            for (int j = b; j < sum - 1; ++j) {
                for (int k = c; k < sum; ++k) {
                    if (beyondSum(i, j, k))
                    {
                        break;
                    }
                    
                    if (equalsSum(i, j, k) && satisfiesPythagorus(i, j, k))
                    {
                        a = i;
                        b = j;
                        c = k;
                        
                        product = a * b * c;
                        
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    
    private boolean recursiveEvaluation(int i, int j, int k)
    {
        if (beyondSum(i, j, k)) {
            return false;
        }
        
        if (equalsSum(i, j, k) && satisfiesPythagorus(i, j, k))
        {
            a = i;
            b = j;
            c = k;
            
            return true;
        }

        if (recursiveEvaluation(i + 1, j + 1, k + 1))
        {
            return true;
        }
        
        if (recursiveEvaluation(i, j + 1, k + 1))
        {
            return true;
        }

        if (recursiveEvaluation(i, j, k + 1)) {
            return true;
        }

        return false;

    }

    private boolean equalsSum(int i, int j, int k)
    {
        return (i + j + k) == sum;
    }

    private static boolean satisfiesPythagorus(int i, int j, int k)
    {
        return (i * i + j * j) == (k * k);
    }

    private boolean beyondSum(int i, int j, int k)
    {
        return i + j + k > sum;
    }

    /**
     * 
     * @return a that satisfies a^2 + b^2 = c^2 and a < b < c and a + b + c = sum
     */
    public int getA()
    {
        return a;
    }

    /**
     * 
     * @return b that satisfies a^2 + b^2 = c^2 and a < b < c and a + b + c = sum
     */
    public int getB()
    {
        return b;
    }

    /**
     * 
     * @return c that satisfies a^2 + b^2 = c^2 and a < b < c and a + b + c = sum
     */
    public int getC()
    {
        return c;
    }

    /**
     * 
     * @return a * b * c
     */
    public int getProduct()
    {
        return product;
    }

    
}
