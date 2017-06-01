
package com.evans.largestgridproduct;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 */
public class LargestNumberProduct {

    private final int maxAdjNumbers;
    private long largestProduct;

    LargestNumberProduct(int maxAdjNumbers)
    {
        if (maxAdjNumbers < 1) {
            throw new IllegalArgumentException("can only look for 1 or more adjacent numbers for the product");
        }
        this.maxAdjNumbers = maxAdjNumbers;
        largestProduct = 0;
    }

    void check(ArrayList<Integer> numberSequence) throws IllegalArgumentException
    {
        if (numberSequence.isEmpty()) {
            throw new IllegalArgumentException("expect numberSequence to contain numbers");
        }
        
        long product = calculateInitialProduct(numberSequence);
        
        calculateRemainingProducts(numberSequence, product);
    }

    private long calculateInitialProduct(ArrayList<Integer> numberSequence)
    {
        long product = 1;
        for (int index = 0; index < numberSequence.size() && index < maxAdjNumbers; ++index) {
            int number = numberSequence.get(index);
            product *= number;
        }
        updateBestProductWhenLarger(product);
        return product;
    }

    private void calculateRemainingProducts(ArrayList<Integer> numberSequence, long product)
    {
        for (int oldestIndex = 0, newestIndex = maxAdjNumbers;
                newestIndex < numberSequence.size();
                ++oldestIndex, ++newestIndex) {
            int oldest = numberSequence.get(oldestIndex);
            
            if (oldest != 0) {
                product /= oldest;
            }
            else {
                product = 1;
            }
            
            int newest = numberSequence.get(newestIndex);
            product *= newest;
            
            updateBestProductWhenLarger(product);
        }
    }
    
    private void updateBestProductWhenLarger(long product)
    {
        if (product > largestProduct) {
            largestProduct = product;
        }
    }
    
    public long answer()
    {
        return largestProduct;
    }
}
