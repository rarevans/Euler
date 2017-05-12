using NUnit.Framework;

namespace SumSquareDiff
{
    class SquareOfSum_Test
    {
        [Test, Sequential]
        public void Result_Correct(
            [Values(1, 2, 1, 1, 1, 4)] int low,
            [Values(1, 1, 2, 3, 10, 9)] int high,
            [Values(1, 0, 9, 36, 3025, 1521)] int expectedResult)
        {
            SquareOfSum sqSum = new SquareOfSum(low, high);

            var result = sqSum.Result();

            Assert.That(result, Is.EqualTo(expectedResult));
        }
    }
}
