"""
Position of rightmost set bit.
Write a one line C function to return position of first 1 from right to left, in binary representation of an Integer.
"""

def rightmost_bit(num):
    i = 0
    while num > 0:
        if num & 1 == 1:
            return i + 1
        else:
            i += 1
            num = num >> 1


def rightmost_bit2(num):
    # num and two's compliment
    import math
    return int(math.log2(num & (-num))) + 1

if __name__ == "__main__":
    print(rightmost_bit2(8))