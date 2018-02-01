def add(a, b):
    def sum_digit(x, y, carry=0):
        digit_sum = x + y + carry
        if digit_sum == 10:
            carry = 1
            digit_sum = 0
        elif digit_sum > 10:
            carry = 1
            digit_sum -= 10
        else:
            carry = 0
        return digit_sum, carry
    result = []
    carry = 0
    short = min(len(a), len(b))
    for i in range(1, short + 1):
        digit_sum, carry = sum_digit(a[-i], b[-i], carry=carry)
        result.append(digit_sum)
    if len(a) > len(b):
        for j in range(len(a) - short, 0, -1):
            digit_sum, carry = sum_digit(a[j - 1], 0, carry=carry)
            result.append(digit_sum)
    else:
        for j in range(len(b) - short, 0, -1):
            digit_sum, carry = sum_digit(b[j - 1], 0, carry=carry)
            result.append(digit_sum)
    if carry > 0:
        result.append(carry)
    return([x for x in reversed(result)])

if __name__ == "__main__":
    print(add([9, 0, 8, 4, 4, 1, 2], [6, 5, 6]))
    print(add([6, 5, 6], [9, 0, 8, 4, 4, 1, 2]))
    print(add([], [6, 9, 8]))
    print(add([9, 9, 9, 9], [1]))

