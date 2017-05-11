using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;

namespace SmallestMultipleDivision
{
    class SmallestMultiple_Test
    {
        [Test]
        public void Ctr_LowSmallerThanHigh_Succeeds()
        {
            Assert.That(new SmallestMultiple(1, 2), Is.Not.Null);
        }

        [Test]
        public void Ctr_LowEqualsHigh_Fails()
        {
            Assert.Throws<Exception>(delegate { new SmallestMultiple(3, 3); });
        }

        [Test]
        public void Ctr_LowGreaterThanHigh_Fails()
        {
            Assert.Throws<Exception>(delegate { new SmallestMultiple(2, 1); });
        }
        
        [Test]
        public void Result_1and2()
        {
            SmallestMultiple sm = new SmallestMultiple(1, 2);

            var result = sm.Result();

            Assert.That(result, Is.EqualTo(2));
        }

        [Test]
        public void Result_1and3()
        {
            SmallestMultiple sm = new SmallestMultiple(1, 3);

            var result = sm.Result();

            Assert.That(result, Is.EqualTo(6));
        }

        [Test, Sequential]
        public void Result_mAndn_Correct(
            [Values(2, 3, 4, 5, 7, 9, 10, 11, 20)] int high,
            [Values(2, 6, 12, 60, 420, 2520, 2520, 27720, 232792560)] int expectedResult
            )
        {
            SmallestMultiple sm = new SmallestMultiple(1, high);

            var result = sm.Result();

            Assert.That(result, Is.EqualTo(expectedResult));
        }
    }
}
