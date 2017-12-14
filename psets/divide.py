# https://leetcode.com/problems/divide-two-integers/description/
# Divide two integers without using multiplication, division and mod operator.

# If it is overflow, return MAX_INT.


MAX_INT32 = (1 << 31) - 1
MIN_INT32 = -MAX_INT32 - 1


class Divide(object):

    def divide(self, dividend, divisor):
        positive = (dividend < 0) is (divisor < 0)
        dividend, divisor = abs(dividend), abs(divisor)
        res = 0
        while dividend >= divisor:
            temp, i = divisor, 1
            while dividend >= temp:
                dividend -= temp
                res += i
                i <<= 1
                temp <<= 1
        if not positive:
            res = -res
        return min(max(MIN_INT32, res), MAX_INT32)

if __name__ == "__main__":

    d = Divide()
    print(d.divide(-2147483648, 1))
