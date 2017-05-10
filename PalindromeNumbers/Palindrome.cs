using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PalindromeNumbers
{
    public class Palindrome
    {
        public int Number { get; private set; }

        public bool IsPalindromic { get; private set; }

        public Palindrome(int number)
        {
            if (number < 0)
            {
                throw new Exception("positive numbers only");
            }

            Number = number;
            IsPalindromic = CheckNumber();
        }

        private bool CheckNumber()
        {
            var digits = ExtractDigits(Number);
            List<int> reverse = new List<int>(digits);
            reverse.Reverse();

            for (int i = 0; i < 1 + (digits.Count / 2); i++)
            {
                if (digits[i] != reverse[i])
                    return false;
            }
            return true;
        }

        private List<int> ExtractDigits(int number)
        {
            List<int> digits = new List<int>();

            if (number == 0)
            {
                digits.Add(0);
            }

            while (number > 0)
            {
                var modulo = number % 10;
                number /= 10;
                digits.Add(modulo);
            }

            return digits;

        }
    }
}
