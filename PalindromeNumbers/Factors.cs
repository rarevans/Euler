using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PalindromeNumbers
{
    class Factors
    {
        public int MinFactor { get; private set; }
        public int MaxFactor { get; private set; }

        public Factors(int digits)
        {
            MinFactor = (int)Math.Pow(10, digits - 1);
            MaxFactor = (int)Math.Pow(10, digits) - 1;
        }

        public List<int> Factor(int product)
        {
            List<int> result = new List<int>();

            var factor1 = (int)Math.Floor(Math.Sqrt(product));
            while (factor1 >= MinFactor)
            {
                var factor2 = product / factor1;
                if (product % factor1 == 0 && factor2 <= MaxFactor)
                {
                    result.Add(factor1);
                    result.Add(factor2);
                    break;
                }
                --factor1;
            }

            return result;
        }
    }
}
