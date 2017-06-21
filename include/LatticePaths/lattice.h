#pragma once

#include <vector>
#include <list>

class Lattice
{
public:
    Lattice(unsigned char rows, unsigned char columns);

    long long findPaths();
private:
    unsigned char m_rows;
    unsigned char m_columns;
    long long     m_paths;

    void addPaths(unsigned char x, unsigned char y);
};
