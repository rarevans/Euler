using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;

namespace PalindromeNumbers
{
    class Palindrome_Test
    {
        [Test]
        public void Ctr_NegativeNumber_Fails()
        {
            Assert.Throws<Exception>(delegate { new Palindrome(-4); });
        }

        [Test, Sequential]
        public void IsPalindromic_IsFalse(
            [Values(12, 21, 45, 112, 443, 10091, 101201)] int number)
        {
            Palindrome p = new Palindrome(number);

            Assert.That(p.IsPalindromic, Is.False);
        }

        [Test, Sequential]
        public void IsPalindromic_IsTrue(
            [Values(0, 1, 2, 5, 6, 7, 11, 33, 101, 414, 9009, 50105)] int number)
        {
            Palindrome p = new Palindrome(number);

            Assert.That(p.IsPalindromic, Is.True);
        }
    }
}
