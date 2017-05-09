using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;

namespace Count3n5s
{
    class Count3n5_Test
    {

        [Test]
        public void Ctr_Negative_Fails()
        {
            Assert.Throws<Exception>(delegate {new Count3n5(-4); });
        }

        [Test]
        public void Ctr_LargeBound_Fails()
        {
            Assert.Throws<Exception>(delegate { new Count3n5(Int32.MaxValue); });
        }

        [Test, Sequential]
        public void Count_IsZero(
            [Values(0, 1, 2, 3, 4, 5, 6, 10, 11, 16, 1000, 46340)] int boundary,
            [Values(0, 0, 0, 0, 3, 3, 8, 23, 33, 60, 233168, 501020358)] int result)
        {
            Count3n5 counter = new Count3n5(boundary);

            counter.Count();

            Assert.That(counter.Sum, Is.EqualTo(result));
        }
    }
}
