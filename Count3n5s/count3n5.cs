using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Count3n5s
{
    public class Count3n5
    {
        public int Sum { get; set; }

        public int Bound { get; private set; }

        public Count3n5(int upperBound)
        {
            Bound = upperBound;
            if (upperBound < 0)
            {
                throw new Exception("Counting 3s and 5s requires a positive upper bound.");
        }
            if (upperBound > Math.Sqrt((Int32.MaxValue)))
            {
                throw new Exception("Counting 3s and 5s should not a bound too big to add together.");
            }
        }

        public void Count()
        {
            var product3 = 3;
            var product5 = 5;

            for (var multiple = 1; (product3 < Bound || product5 < Bound); ++multiple)
            {
                Sum += product3;

                if (product5 < Bound && (product5 % 3) != 0)
                {
                    Sum += product5;
                }

                product3 += 3;
                product5 += 5;
            }
        }
    }
}
