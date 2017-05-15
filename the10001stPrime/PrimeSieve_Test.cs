using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;

namespace the10001stPrime
{
    class PrimeSieve_Test
    {

        [Test]
        public void Constructor_Default()
        {
            PrimeSieve sieve = new PrimeSieve();

            Assert.That(sieve.Primes, Is.EqualTo(startingPrimes));
        }

        Int64[] startingPrimes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997 };

        [Test]
        public void Constructor_Size10Sieve()
        {
            PrimeSieve sieve = new PrimeSieve(10);

            var foundPrimes = sieve.Primes;

            Assert.That(foundPrimes, Is.EqualTo(new Int64[] { 2, 3, 5, 7 }));
        }


        [Test]
        public void FindMore_Size10Sieve_Correct()
        {
            PrimeSieve sieve = new PrimeSieve(10);
            sieve.FindMore();

            var foundPrimes = sieve.Primes;

            Assert.That(foundPrimes, Is.EqualTo(new Int64[] { 2, 3, 5, 7, 11, 13, 17, 19 }));
        }

        [Test]
        public void FindMore_10001stPrime()
        {
            PrimeSieve sieve = new PrimeSieve();

            while (sieve.Primes.Count <= 10000)
            {
                sieve.FindMore();
            }

            Assert.That(sieve.Primes.Count, Is.GreaterThan(10000));
            Assert.That(sieve.Primes[10000], Is.EqualTo(104743));
        }

        [Test]
        public void FindMore_10001stPrime_OddFieldSize()
        {
            PrimeSieve sieve = new PrimeSieve(7);

            while (sieve.Primes.Count <= 10000)
            {
                sieve.FindMore();
            }

            Assert.That(sieve.Primes.Count, Is.GreaterThan(10000));
            Assert.That(sieve.Primes[10000], Is.EqualTo(104743));
        }
    }
}
