using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SumSquareDiff
{
    class SumOfSquares
    {
        public int Lowest { get; private set; }
        public int Highest { get; private set; }

        public SumOfSquares(int low, int high)
        {
            Lowest = low;
            Highest = high;
        }

        public int Result()
        {
            var sum = 0;

            for (int number = Lowest; number <= Highest; ++number)
            {
                sum += number * number;
            }
            return sum;
        }
    }
}
