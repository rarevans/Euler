
package com.evans.triangularnumberfactors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author revans
 */
public class GcdTest {

    @Test
    public void testgcd()
    {
        assertThat(Gcd.gcd(1L, 1L), is(equalTo(1L)));
        assertThat(Gcd.gcd(2L, 1L), is(equalTo(1L)));
        assertThat(Gcd.gcd(1L, 2L), is(equalTo(1L)));
        assertThat(Gcd.gcd(4L, 2L), is(equalTo(2L)));
        assertThat(Gcd.gcd(5L, 13L), is(equalTo(1L)));
        assertThat(Gcd.gcd(20L, 15L), is(equalTo(5L)));
        assertThat(Gcd.gcd(462L, 1071L), is(equalTo(21L)));
        assertThat(Gcd.gcd(489L, 84923L), is(equalTo(163L)));
    }
}
