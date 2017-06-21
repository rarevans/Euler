

#include "PowerDigitSum/CharacterSequence.h"

size_t CharacterSequence::sumDigits(const char* s)
{
    size_t sum = 0;

    while (s != nullptr && *s != 0)
    {

        if (*s >= '0' && *s <= '9')
        {
            char value = *s - '0';
            sum += value;
        }
        ++s;
    }
    return sum;
}

size_t CharacterSequence::sumDigits(const std::string& s)
{
    return sumDigits(s.c_str());
}
