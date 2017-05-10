using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PalindromeNumbers
{
    class PalindromicProducts
    {
        public int NumDigits { get; private set; }

        public PalindromicProducts(int numDigits)
        {
            NumDigits = numDigits;
        }

        public List<int> Find()
        {
            List<int> result = new List<int>();

            var minValue = Math.Pow(Math.Pow(10, NumDigits - 1), 2);
            var maxValue = Math.Pow(Math.Pow(10, NumDigits) - 1, 2);

            Factors factor = new Factors(NumDigits);

            for (int currentValue = (int)maxValue; currentValue > minValue; --currentValue)
            {
                if (new Palindrome(currentValue).IsPalindromic)
                {
                    result = factor.Factor(currentValue);

                    if (result.Count == 2)
                    {
                        result.Add(currentValue);
                        break;
                    }
                }
            }

            return result;
        }
    }
}
