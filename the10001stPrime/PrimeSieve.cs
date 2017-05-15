using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace the10001stPrime
{
    class PrimeSieve
    {
        private readonly int field;

        public List<int> Primes { get; private set; }
        private int Offset { get; set; }

        public PrimeSieve()
        {
            field = 1000;
            Offset = 0;
            Primes = new List<int>();
            PrepPrimes();
        }

        public PrimeSieve(int sieveSize)
        {
            field = sieveSize;
            Offset = 0;
            Primes = new List<int>();
            PrepPrimes();
        }

        private void PrepPrimes()
        {
            for (int i = 2; i < field; i++)
            {
                bool found = false;
                foreach (var prime in Primes)
                {
                    if ((i % prime) == 0)
                    {
                        found = true;
                        break;
                    }
                }

                if (!found)
                {
                    Primes.Add(i);
                    found = false;
                }
            }
            Offset += field;
        }


        public void FindMore()
        {
            List<int> candidates = new List<int>();

            for (int index = 0; index < field; ++index)
            {
                var candidate = index + Offset;

                bool found = false;

                foreach (var prime in Primes)
                {
                    if (candidate % prime == 0)
                    {
                        found = true;
                        break;
                    }

                }

                if (!found)
                {
                    candidates.Add(candidate);
                }
            }

            Primes.AddRange(candidates);
            Offset += field;
        }
    }
}
