using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;

namespace FibonacciSum
{
    class FibonacciSum_Test
    {
        [Test]
        public void Ctr_Succeeds()
        {
            Assert.That(delegate { new Fibonacci(); }, Is.Not.Null);
        }

        [Test]
        public void Next_FirstCall_Correct()
        {
            Fibonacci sum = new Fibonacci();

            var result = sum.Next();

            Assert.That(result, Is.EqualTo(1));
        }

        [Test]
        public void Next_TwoCalls_Correct()
        {
            Fibonacci sum = new Fibonacci();
            sum.Next();

            var result = sum.Next();

            Assert.That(result, Is.EqualTo(2));
        }

        [Test, Sequential]
        public void Next_Correct(
            [Values(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)] int calls,
            [Values(0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89)] int expectedResult)
        {
            Fibonacci fib = new Fibonacci();
            int result = 0;

            for (int i = 0; i < calls; i++)
            {
                result = fib.Next();
            }

            Assert.That(result, Is.EqualTo(expectedResult));
        }


        [Test, Sequential]
        public void Sum_Even_Fibonacci_LessThan(
            [Values(1, 2, 3, 4, 5, 6, 9, 4000000)] int limit,
            [Values(0, 0, 2, 2, 2, 2, 10, 4613732)] int expectedSum)
        {
            Fibonacci fib = new Fibonacci();
            int result = 0;
            int sum = 0;

            while ((result = fib.Next()) < limit)
            {
                if ((result % 2) == 0)
                {
                    sum += result;
                }
            }

            Assert.That(sum, Is.EqualTo(expectedSum));
        }
    }
}
