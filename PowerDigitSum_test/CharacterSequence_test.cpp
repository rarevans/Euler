
#include "PowerDigitSum/CharacterSequence.h"
#include "PowerDigitSum/Number.h"

#include <boost/test/unit_test.hpp>

BOOST_AUTO_TEST_SUITE(CharacterSum_test)

BOOST_AUTO_TEST_CASE(sum_empty_characters_is_zero)
{
    auto sum = CharacterSequence::sumDigits("");

    BOOST_CHECK_EQUAL(sum, 0);
}

BOOST_AUTO_TEST_CASE(sum_empty_nullptr_characters_is_zero)
{
    auto sum = CharacterSequence::sumDigits(nullptr);

    BOOST_CHECK_EQUAL(sum, 0);
}

BOOST_AUTO_TEST_CASE(sum_nonnumeric_characters_is_zero)
{
    auto sum = CharacterSequence::sumDigits("abdfdf");

    BOOST_CHECK_EQUAL(sum, 0);
}

BOOST_AUTO_TEST_CASE(sum_of_zeros_is_zero)
{
    auto sum = CharacterSequence::sumDigits("00000000000");

    BOOST_CHECK_EQUAL(sum, 0);
}

BOOST_AUTO_TEST_CASE(sum_of_four_ones_is_four)
{
    auto sum = CharacterSequence::sumDigits("1111");

    BOOST_CHECK_EQUAL(sum, 4);
}

BOOST_AUTO_TEST_CASE(sum_of_nine_ones_is_nine)
{
    auto sum = CharacterSequence::sumDigits("111111111");

    BOOST_CHECK_EQUAL(sum, 9);
}

BOOST_AUTO_TEST_CASE(sum_of_two_exp_1000_is_large)
{
    Number twoExponent1000 = Number("2") ^ 1000;

    auto sum = CharacterSequence::sumDigits(twoExponent1000);

    BOOST_CHECK_EQUAL(sum, 1366);
}

BOOST_AUTO_TEST_SUITE_END()
