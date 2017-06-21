
#include "LatticePaths/lattice.h"
#include "..\include\LatticePaths\lattice.h"
#include "boost/multiprecision/cpp_int.hpp"

#include <iostream>

using namespace std;
using namespace boost::multiprecision;

namespace {

    typedef uint1024_t integer;

    integer factorial(unsigned char n)
    {
        integer result = 1;
        for (size_t i = 1; i <= n; ++i)
        {
            result *= i;
        }
        return result;
    }

    long long combination(unsigned char m, unsigned char n)
    {
        integer result = 1;
        if (false) {
            for (size_t i = 1; i <= m; ++i)
            {
                result *= (m + i) / i;
            }
        }
        else
        {
            result = factorial(m + n) / (factorial(m) * factorial(m + n - m));
        }

        if (result < numeric_limits<long long>::max())
        {
            return result.convert_to<long long>();
        }
        else
        {
            return numeric_limits<long long>::max();
        }
    }
}

Lattice::Lattice(unsigned char rows, unsigned char columns)
    : m_rows(rows)
    , m_columns(columns)
{}

long long Lattice::findPaths()
{
#if 0
    m_paths = 0;
    addPaths(m_rows, m_columns);
#else
    return combination(m_rows, m_columns);
#endif
}

void Lattice::addPaths(unsigned char x, unsigned char y)
{
    if (x == m_rows && y == m_columns)
    {
        ++m_paths;
        return;
    }

    if (y < m_columns)
    {
        addPaths(x, y + 1);
    }

    if (x < m_rows)
    {
        addPaths(x + 1, y);
    }
}
