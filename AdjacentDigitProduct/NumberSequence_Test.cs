using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;

namespace AdjacentDigitProduct
{
    class NumberSequence_Test
    {
        [Test]
        public void Ctr_NullSequence_Fails()
        {
            Assert.Throws<Exception>( delegate { new NumberSequence(null); });
        }

        [Test]
        public void Ctr_EmptySequence_Succeeds()
        {
            Assert.That(new NumberSequence(String.Empty), Is.Not.Null);
        }

        [Test]
        public void Ctr_NonDigits_Fails(
            [Values( " 1", "1 ", "1 3", "\t", "A", "45aCD5", "0x5")] string testSequence
            )
        {
            Assert.Throws<Exception>(delegate { new NumberSequence(testSequence); });
        }

        [Test]
        public void Ctr_Numbers_Succeeds(
            [Values("1", "2", "56245")] string testSequence)
        {
            Assert.That(new NumberSequence(testSequence), Is.Not.Null);
        }

        [Test]
        public void HasMore_EmptySequence_False()
        {
            NumberSequence sequence = new NumberSequence(String.Empty);

            var hasMore = sequence.HasMore();

            Assert.That(hasMore, Is.False);
        }

        [Test]
        public void HasMore_NonEmptySequence_True()
        {
            NumberSequence sequence = new NumberSequence("1");

            var hasMore = sequence.HasMore();

            Assert.That(hasMore, Is.True);
        }

        [Test]
        public void Next_OneSequence_IsCorrect()
        {
            NumberSequence sequence = new NumberSequence("1");

            var digit = sequence.Next();

            Assert.That(digit, Is.EqualTo(1));
        }

        [Test]
        public void Next_TwoSequence_IsCorrect()
        {
            NumberSequence sequence = new NumberSequence("42");
            sequence.Next();

            var digit = sequence.Next();

            Assert.That(digit, Is.EqualTo(2));
        }
    }
}
