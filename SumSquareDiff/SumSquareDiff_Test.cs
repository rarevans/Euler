using NUnit.Framework;

namespace SumSquareDiff
{
    class SumSquareDiff_Test
    {
        [Test, Sequential]
        public void SquareSum_SumSquare_Diff(
            [Values(1, 3, 1, 1, 1, 1, 1)] int low,
            [Values(1, 1, 2, 3, 4, 10, 100)] int high,
            [Values(0, 0, 4, 22, 70, 2640, 25164150)] int diff
            )
        {
            SumOfSquares sumSq = new SumOfSquares(low, high);
            SquareOfSum sqSum = new SquareOfSum(low, high);

            var result = sqSum.Result() - sumSq.Result();

            Assert.That(result, Is.EqualTo(diff));
        }
    }
}
