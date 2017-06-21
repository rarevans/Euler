
#include "PowerDigitSum/Number.h"

#include <vector>

using namespace std;

namespace {
    char actualNumber(char stringChar)
    {
        return stringChar - '0';
    }
}

Number::Number()
    : m_num("0")
{}

Number::Number(const char* num)
    : m_num(num)
{}

Number::Number(const string& num)
    : m_num(num)
{}

Number & Number::operator*=(const Number & n)
{
    std::vector<Number> parts;
    string tens;

    for (auto digit = m_num.rbegin(); digit != m_num.rend(); ++digit)
    {
        char multipland = actualNumber(*digit);
        Number number(n.m_num + tens);
        Number multiplied;
        for (auto i = 0; i < multipland; ++i)
        {
            multiplied += number;
        }
        parts.push_back(multiplied);
        tens.append("0");
    }
    Number answer;
    for (auto part : parts)
    {
        answer += part;
    }

    m_num.swap(answer.m_num);

    return *this;
}

Number & Number::operator+=(const Number & n)
{
    string first(this->m_num), second(n.m_num);
    if (first.size() > second.size()) {
        swap(first, second);
    }

    string number;
    auto digit      = first.rbegin();
    auto otherDigit = second.rbegin();
    char tens = 0;

    for (; digit != first.rend() && otherDigit != second.rend(); ++digit, ++otherDigit)
    {
        char top = actualNumber(*digit);
        char bot = actualNumber(*otherDigit);
        char sum = top + bot + tens;
        number.push_back(sum % 10 + '0');
        
        tens = sum / 10;
    }

    while (tens != 0)
    {
        if (otherDigit != second.rend()) {
            tens += actualNumber(*otherDigit);
            ++otherDigit;
        }

        char ones = tens % 10;
        tens /= 10;
        number.push_back(ones + '0');
    }

    number.append(otherDigit, second.rend());

    reverse(number.begin(), number.end());

    m_num = number;
    return *this;
}

Number::operator const std::string&() const
{
    return m_num;
}

Number  operator^(const Number& m, unsigned int n)
{
    Number answer = "1";
    for (size_t i = 0; i < n; ++i)
    {
        answer *= m;
    }
    return answer;
}

Number operator*(const Number& m, const Number& n)
{
    Number answer = m;
    answer *= n;
    return answer;
}

Number operator+(const Number& m, const Number& n)
{
    Number answer = m;
    answer += n;
    return answer;
}

ostream& operator<<(ostream& out, const Number& number)
{
    return out << number.m_num;
}

bool operator==(const Number& one, const Number& another)
{
    return one.m_num == another.m_num;
}