package com.evans.pythagoreantriplet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import org.junit.Rule;
import org.hamcrest.core.IsNull;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.rules.*;

/**
 *
 * @author revans
 */
public class PythagoreanTripletTest
{
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    public PythagoreanTripletTest()
    {
    }

    @Test
    public void Ctr_negativeSum_Throws()
    {
        thrown.expect(IllegalArgumentException.class);
        
        PythagoreanTriplet triplet = new PythagoreanTriplet(-12);
    }
    
    @Test
    public void Ctr_positiveSum_Succeeds()
    {
        PythagoreanTriplet triplet = new PythagoreanTriplet(12);

        assertThat(triplet, is(IsNull.notNullValue()));
    }
    
    
    @Test
    public void Find_For12_Succeeds()
    {
        PythagoreanTriplet triplet = new PythagoreanTriplet(12);
        
        boolean result = triplet.find();
        
        assertThat(result, is(true));
        assertThat(triplet.getA(), is(equalTo(3)));
        assertThat(triplet.getB(), is(equalTo(4)));
        assertThat(triplet.getC(), is(equalTo(5)));
        assertThat(triplet.getProduct(), is(equalTo(60)));
    }
    
    @Test
    public void Find_For13_Fails()
    {
        PythagoreanTriplet triplet = new PythagoreanTriplet(13);
        
        boolean result = triplet.find();
        
        assertThat(result, is(false));
        assertThat(triplet.getA(), is(equalTo(1)));
        assertThat(triplet.getB(), is(equalTo(2)));
        assertThat(triplet.getC(), is(equalTo(3)));
        assertThat(triplet.getProduct(), is(equalTo(6)));
    }
    
    @Test
    public void Find_For1000_Succeeds()
    {
        PythagoreanTriplet triplet = new PythagoreanTriplet(1000);
        
        boolean result = triplet.find();
        
        assertThat(result, is(true));
        assertThat(triplet.getA(), is(equalTo(200)));
        assertThat(triplet.getB(), is(equalTo(375)));
        assertThat(triplet.getC(), is(equalTo(425)));
        assertThat(triplet.getProduct(), is(equalTo(31875000)));
    }
}
