"""
Print all possible strings that can be made by placing spaces

Given a string you need to print all possible strings that can be made by placing spaces (zero or one) in between them.

Input:  str[] = "ABC"
Output: ABC
        AB C
        A BC
        A B C
"""
import math

def get_pattern(input_str, pattern):
    assert (len(input_str) == len(pattern))

    res = ''
    for i in range(len(pattern)):
        if pattern[i] == '1':
            res += input_str[i] + ' '
        else:
            res += input_str[i]
    return res

def space_pattern(input_str):
    result = []
    result.append(input_str)
    input_str = list(input_str)

    for i in range(2, 2 ** len(input_str) - 1, 2):
        b = bin(i)[2:]
        pattern = list('0' * (len(input_str) - len(b)) + b)

        result.append(get_pattern(input_str, pattern))
    return result


if __name__ == "__main__":
    result = space_pattern('abcde')
    print(result)
