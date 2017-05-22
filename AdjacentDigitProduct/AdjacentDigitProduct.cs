using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AdjacentDigitProduct
{
    class AdjacentDigitProduct
    {
        public NumberSequence Sequence { get; private set; }
        public uint Length { get; private set; }
        public List<int> Numbers { get; private set; }
        public int Offset { get; private set; }
        public long BestProduct { get; private set; }
        public List<int> BestNumbers { get; private set; }

        public AdjacentDigitProduct(NumberSequence sequence, uint length)
        {
            Sequence = sequence;
            Length = length;
            Offset = 0;
            Numbers = new List<int>();

            while (sequence.HasMore() && Numbers.Count < Length)
            {
                Numbers.Add(sequence.Next());
            }
            BestNumbers = new List<int>(Numbers);
        }

        public long Product()
        {
            long product = (Numbers.Count != 0) ? 1 : 0;

            foreach (var digit in Numbers)
            {
                product *= digit;
            }

            BestProduct = product;

            while (Sequence.HasMore())
            {
                ++Offset;

                var nextDigit = Sequence.Next();

                var firstDigit = Numbers[0];
                Numbers.RemoveAt(0);

                if (firstDigit != 0)
                {
                    product /= firstDigit;
                }
                else
                {
                    product = 1;

                    foreach (var digit in Numbers)
                    {
                        checked { product *= digit; }
                    }
                }

                product *= nextDigit;
                Numbers.Add(nextDigit);
                if (product > BestProduct)
                {
                    BestProduct = product;
                    BestNumbers = new List<int>(Numbers);
                }
            }

            return BestProduct;
        }
    }
}
