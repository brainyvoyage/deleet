def add(list1, list2, result, carry=0):
    if len(list1) == len(list2) == 0:
        result.append(carry) if carry > 0 else ...
        return
    if len(list1) == 0 or len(list2) == 0:
        add(list1, [0], result, carry) if len(list2) == 0 else add([0], list2, result, carry)
        return [x for x in reversed(result)]
    carry, digit_sum = divmod(list1[-1] + list2[-1] + carry, 10)
    result.append(digit_sum)
    add(list1[:-1], list2[:-1], result, carry)
    return [x for x in reversed(result)]

if __name__ == "__main__":
    x = add([9, 0, 8, 4, 4, 1, 2], [5, 9, 8], [])
    print(x)
    x = add([], [6, 9, 8], [])
    print(x)
