using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PalindromeNumbers
{
    class Factors_Test
    {

        [Test]
        public void Factor_3()
        {
            Factors f = new Factors(1);
            int[] expectedResult = { 1, 3 };

            var result = f.Factor(3);

            Assert.That(result, Is.EqualTo(expectedResult));
        }

        [Test]
        public void Factor_12()
        {
            Factors f = new Factors(1);
            int[] expectedResult = { 3, 4 };

            var result = f.Factor(12);

            Assert.That(result, Is.EqualTo(expectedResult));
        }

        [Test]
        public void Factor_12_twoDigits()
        {
            Factors f = new Factors(2);
            int[] expectedResult = {};

            var result = f.Factor(12);

            Assert.That(result, Is.EqualTo(expectedResult));
        }

        [Test]
        public void Factor_120_threeDigits()
        {
            Factors f = new Factors(3);
            int[] expectedResult = { };

            var result = f.Factor(120);

            Assert.That(result, Is.EqualTo(expectedResult));
        }

        [Test]
        public void Factor_9779_twoDigits()
        {
            Factors f = new Factors(2);
            int[] expectedResult = { };

            var result = f.Factor(9779);

            Assert.That(result, Is.EqualTo(expectedResult));
        }
    }
}
