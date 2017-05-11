using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SmallestMultipleDivision
{
    class SmallestMultiple
    {
        public int Lowest { get; private set; }
        public int Highest { get; private set; }

        public SmallestMultiple(int low, int high)
        {
            if (low >= high)
            {
                throw new Exception("multiple range: low should be less than high");
            }
            Lowest = low;
            Highest = high;
        }

        public int Result()
        {
            var start = Lowest + 1;

            List<int> range = new List<int>();
            while ( start <= Highest)
            {
                range.Add(start++);
            }

            bool found = false;

            var candidate = 0;

            do
            {
                candidate += Lowest;
                found = true;

                foreach (var divisor in range)
                {
                    if (candidate % divisor != 0)
                    {
                        found = false;
                        break;
                    }
                }

            } while (!found);


            return candidate;
        }
    }
}
