using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;

namespace PalindromeNumbers
{
    class PalindromicProducts_Test
    {
        [Test]
        public void TestMethod()
        {
            var smallest = Math.Floor(Math.Log10(100 * 100));
            var largest = Math.Floor(Math.Log10(999 * 999));

            Assert.That(smallest < largest, Is.True);
        }
        [Test]
        public void Ctr_1digit_Succeeds()
        {
            Assert.That(new PalindromicProducts(1), Is.Not.Null);
        }

        [Test]
        public void Find_1digit_Succeeds()
        {
            PalindromicProducts pProds = new PalindromicProducts(1);
            int[] expectedResult = { 3, 3, 9 };

            var results = pProds.Find();

            Assert.That(results, Is.EqualTo(expectedResult));
        }

        [Test]
        public void Find_2digit_Succeeds()
        {
            PalindromicProducts pProds = new PalindromicProducts(2);
            int[] expectedResult = { 91, 99, 9009 };

            var results = pProds.Find();

            Assert.That(results, Is.EqualTo(expectedResult));
        }

        [Test]
        public void Find_3digit_Succeeds()
        {
            PalindromicProducts pProds = new PalindromicProducts(3);
            int[] expectedResult = { 913, 993, 906609 };

            var results = pProds.Find();

            Assert.That(results, Is.EqualTo(expectedResult));
        }

        [Test]
        public void Find_4digit_Succeeds()
        {
            PalindromicProducts pProds = new PalindromicProducts(4);
            int[] expectedResult = { 9901, 9999, 99000099 };

            var results = pProds.Find();

            Assert.That(results, Is.EqualTo(expectedResult));
        }
    }
}
