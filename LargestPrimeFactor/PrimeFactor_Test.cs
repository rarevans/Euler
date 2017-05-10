using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;

namespace LargestPrimeFactor
{
    public class PrimeFactor_Test
    {
        [Test]
        public void Ctr_Succeeds()
        {
            Assert.That(delegate { new PrimeFactor(0); }, Is.Not.Null);
        }

        [Test]
        public void Ctr_Negative_Fails()
        {
            Assert.Throws<Exception>(delegate { new PrimeFactor(-1); });
        }

        [Test]
        public void Factor_OfOne_IsEmpty()
        {
            PrimeFactor prime = new PrimeFactor(1);

            var factors = prime.Factor();

            Assert.That(factors, Is.Empty);
        }

        [Test]
        public void Factor_OfThree()
        {
            PrimeFactor prime = new PrimeFactor(3);
            int[] expectedFactors = { 3 };

            var factors = prime.Factor();

            Assert.That(factors, Is.EqualTo(expectedFactors));
        }

        [Test]
        public void Factor_13195()
        {
            PrimeFactor prime = new PrimeFactor(13195);
            int[] expectedFactors = { 5, 7, 13, 29 };

            var factors = prime.Factor();

            Assert.That(factors, Is.EqualTo(expectedFactors));
        }

        [Test]
        public void Factor_1024()
        {
            PrimeFactor prime = new PrimeFactor(1024);
            int[] expectedFactors = { 2 };

            var factors = prime.Factor();

            Assert.That(factors, Is.EqualTo(expectedFactors));
        }

        [Test]
        public void Factor_2147483647()
        {
            PrimeFactor prime = new PrimeFactor(2147483647);

            var factors = prime.Factor();

            Assert.That(factors, Is.Empty);
        }


        [Test, Explicit]
        public void Factor_600851475143()
        {
            PrimeFactor prime = new PrimeFactor(600851475143);
            int[] expectedFactors = { 71, 839, 1471, 6857 };

            var factors = prime.Factor();

            Assert.That(factors, Is.EqualTo(expectedFactors));
        }

    }
}
