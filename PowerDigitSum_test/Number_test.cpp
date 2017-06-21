
#include "PowerDigitSum/Number.h"

#include "boost/test/unit_test.hpp"

BOOST_AUTO_TEST_SUITE(test_txtArithmetic)

BOOST_AUTO_TEST_CASE(equality)
{
    Number one{ "1" };

    BOOST_CHECK_EQUAL(one, one);
}

BOOST_AUTO_TEST_CASE(modify_add)
{
    Number answer{ "39" };
    Number addand{ "67" };
    Number expected{ "106" };

    answer += addand;

    BOOST_CHECK_EQUAL(answer, expected);
}

BOOST_AUTO_TEST_CASE(add)
{
    Number number{ "67" };
    Number addand{ "1759" };
    Number expected{ "1826" };

    Number answer = number + addand;

    BOOST_CHECK_EQUAL(answer, expected);
}

BOOST_AUTO_TEST_CASE(add_commutative)
{
    Number number{ "1759" };
    Number addand{ "67" };
    Number expected{ "1826" };

    Number answer = number + addand;

    BOOST_CHECK_EQUAL(answer, expected);
}

BOOST_AUTO_TEST_CASE(multiply)
{
    Number number{ "39991" };
    Number multipand{ "67" };
    Number expected{ "2679397" };

    Number answer = number * multipand;

    BOOST_CHECK_EQUAL(answer, expected);
}

BOOST_AUTO_TEST_CASE(multiply_commutative)
{
    Number number{ "67" };
    Number multipand{ "39991" };
    Number expected{ "2679397" };

    Number answer = number * multipand;

    BOOST_CHECK_EQUAL(answer, expected);
}



BOOST_AUTO_TEST_CASE(modify_multiply)
{
    Number answer{ "39" };
    Number multipand{ "67" };
    Number expected{ "2613" };

    answer *= multipand;

    BOOST_CHECK_EQUAL(answer, expected);
}

BOOST_AUTO_TEST_CASE(two_squared)
{
    Number expected{ "4" };

    Number twoSquared = Number("2") ^ 2;

    BOOST_CHECK_EQUAL(twoSquared, expected);
}

BOOST_AUTO_TEST_CASE(nine_squared)
{
    Number expected{ "81" };

    Number nineSquared = Number("9") ^ 2;

    BOOST_CHECK_EQUAL(nineSquared, expected);
}



BOOST_AUTO_TEST_CASE(sixteen_bit_numbers)
{
    Number expected = "32768";

    Number answer = Number("2") ^ 15;

    BOOST_CHECK_EQUAL(answer, expected);
}


BOOST_AUTO_TEST_CASE(two_exp_1000)
{
    Number expected = "10715086071862673209484250490600018105614048117055336074437503883703510511249361224931983788156958581275946729175531468251871452856923140435984577574698574803934567774824230985421074605062371141877954182153046474983581941267398767559165543946077062914571196477686542167660429831652624386837205668069376";
    
    Number answer = Number("2") ^ 1000;

    BOOST_CHECK_EQUAL(answer, expected);
}

BOOST_AUTO_TEST_SUITE_END()
