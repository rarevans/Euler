using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FibonacciSum
{
    public class Fibonacci
    {
        public int Previous { get; private set; }
        public int Current { get; private set; }

        public Fibonacci()
        {
            Previous = 0;
            Current = 1;
        }

        public int Next()
        {
            var result = Previous + Current;
            Previous = Current;
            Current = result;
            return result;
        }
    }
}
