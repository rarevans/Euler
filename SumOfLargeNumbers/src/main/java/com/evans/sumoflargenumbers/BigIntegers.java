
package com.evans.sumoflargenumbers;

import java.math.*;
import java.util.ArrayList;


/**
 *
 */
public class BigIntegers {

    public static ArrayList<BigInteger> array(String[] strings)
    {
        ArrayList<BigInteger> numbers = new ArrayList<>();
        
        for (String string : strings) {
            numbers.add(new BigInteger(string));
        }
        
        return numbers;
    }
    
}
