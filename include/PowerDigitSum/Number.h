#pragma once

#include <string>
#include <iosfwd>

class Number
{
public:
    Number();
    Number(const char*        num);
    Number(const std::string& num);

    operator const std::string&() const;

    Number& operator*=(const Number& n);
    Number& operator+=(const Number& n);

    friend bool operator==(const Number&, const Number&);
    friend std::ostream& operator<<(std::ostream&, const Number&);

private:
    std::string m_num;
};

Number operator*(const Number&, const Number&);
Number operator+(const Number&, const Number&);
Number operator^(const Number&, unsigned int);
