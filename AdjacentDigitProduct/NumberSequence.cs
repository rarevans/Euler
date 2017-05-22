using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace AdjacentDigitProduct
{
    class NumberSequence
    {
        public List<short> Sequence { get; private set; }
        private int Offset { get; set; }

        public NumberSequence(string numberSequence)
        {
            if (numberSequence == null)
            {
                throw new Exception("Number sequence can't be null");
            }

            if (!Regex.Match(numberSequence, @"^[0-9]*$").Success)
            {
                throw new Exception("Only digits are allowed in the sequence.");
            }

            Sequence = new List<short>();
            this.Offset = 0;

            for (int index = 1; index <= numberSequence.Length; ++index)
            {
                var digit = int.Parse(numberSequence.Substring(index - 1, 1));

                Sequence.Add((short)digit);
            }
        }

        public bool HasMore()
        {
            return Offset < Sequence.Count;
        }

        public short Next()
        {
            return Sequence[Offset++];
        }
    }
}
