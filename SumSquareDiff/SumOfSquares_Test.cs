using NUnit.Framework;

namespace SumSquareDiff
{
    class SumOfSquares_Test
    {
        [Test, Sequential]
        public void Result_Correct(
            [Values(1, 2, 1, 1, 1, 4)] int low,
            [Values(1, 1, 2, 3, 10, 9)] int high,
            [Values(1, 0, 5, 14, 385, 271)] int expectedResult)
        {
            SumOfSquares sumSq = new SumOfSquares(low, high);

            var result = sumSq.Result();

            Assert.That(result, Is.EqualTo(expectedResult));
        }
    }
}
