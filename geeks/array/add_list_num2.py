def add(list1, list2):
    common_len, result, carry = min(len(list1), len(list2)), [], 0
    for x, y in zip(reversed(list1), reversed(list2)):
        carry, digit_sum = divmod(x + y + carry, 10)
        result.append(digit_sum)
    if len(list1) > len(list2):
        for x in reversed(list1[: len(list1) - common_len]):
            carry, digit_sum = divmod(x + carry, 10)
            result.append(digit_sum)
    else:
        for x in reversed(list2[: len(list2) - common_len]):
            carry, digit_sum = divmod(x + carry, 10)
            result.append(digit_sum)
    if carry > 0:
        result.append(carry)
    return [x for x in reversed(result)]

if __name__ == "__main__":
    x = add([9, 0, 8, 4, 4, 1, 2], [6, 5, 6])
    print(x)
    x = add([], [6, 9, 8])
    print(x)
