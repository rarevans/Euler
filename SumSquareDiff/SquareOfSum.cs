namespace SumSquareDiff
{
    class SquareOfSum
    {
        public int Lowest { get; private set; }
        public int Highest { get; private set; }

        public SquareOfSum(int low, int high)
        {
            Lowest = low;
            Highest = high;
        }

        public int Result()
        {
            var sum = 0;
            for (int number = Lowest; number <= Highest; ++number)
            {
                sum += number;
            }

            sum = sum * sum;
            return sum;
        }
    }
}
