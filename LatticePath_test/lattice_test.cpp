
#include "LatticePaths/lattice.h"

#include <boost/test/unit_test.hpp>

BOOST_AUTO_TEST_SUITE(lattice_tests)

BOOST_AUTO_TEST_CASE(single_square_lattice)
{
    Lattice square(1, 1);

    auto paths = square.findPaths();

    BOOST_CHECK_EQUAL(paths, 2);
}


BOOST_AUTO_TEST_CASE(single_two_by_two_lattice)
{
    Lattice square(2, 2);

    auto paths = square.findPaths();

    BOOST_CHECK_EQUAL(paths, 6);
}

BOOST_AUTO_TEST_CASE(single_20_by_20_lattice)
{
    Lattice square(20, 20);

    auto paths = square.findPaths();

    BOOST_CHECK_EQUAL(paths, 137846528820);
}

BOOST_AUTO_TEST_SUITE_END()

