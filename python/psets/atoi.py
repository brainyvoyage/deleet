# https://leetcode.com/problems/string-to-integer-atoi/description/

# Implement atoi to convert a string to an integer.

# Hint: Carefully consider all possible input cases.
# If you want a challenge, please do not see below
# and ask yourself what are the possible input cases.

# Notes: It is intended for this problem to be specified
# vaguely (ie, no given input specs). You are responsible
# to gather all the input requirements up front.


class AsciiToInt(object):

    def my_atoi(self, numeric_str):
        """
        :type numeric_str: str
        :rtype: int
        """
        numeric_str = numeric_str.strip()
        if len(numeric_str) == 0:
            return 0
        signed = False
        signed_multiplier = 1
        if numeric_str[0] == '+':
            signed = True
        elif numeric_str[0] == '-':
            signed = True
            signed_multiplier = -1
        if signed:
            numeric_list = self.get_numeric(numeric_str[1:])
        else:
            numeric_list = self.get_numeric(numeric_str)

        print(numeric_list)
        if signed:
            number = self.get_number(numeric_list, signed_multiplier)
        elif not signed:
            number = self.get_number(numeric_list, 1)
        else:
            return 0
        return number

    def get_numeric(self, numeric_str):
        numeric_list = []
        for char in list(numeric_str):
            numeric = ord(char)
            if 48 <= numeric <= 57:
                numeric_list.append(numeric - 48)
            else:
                return numeric_list
        return numeric_list

    def get_number(self, str_list, sign):
        number = 0
        max = (1 <<31) - 1
        for power, value in enumerate(reversed(str_list)):
            number += pow(10, power) * value
        if number > max and sign > 0:
            number = max
        elif number > max and sign < 0:
            number = max + 1
        if sign > 0:
            return number
        else:
            return -number

if __name__ == "__main__":
    atoi = AsciiToInt()
    print(atoi.my_atoi("-2147483648"))
