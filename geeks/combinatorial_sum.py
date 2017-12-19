"""
Given an array of positive integers arr[] and a sum x, find all unique
combinations in arr[] where the sum is equal to x. The same repeated
number may be chosen from arr[] unlimited number of times. Elements in
a combination (a1, a2, …, ak) must be printed in non-descending order.
(ie, a1 <= a2 <= … <= ak). The combinations themselves must be sorted in
ascending order, i.e., the combination with smallest first element should
be printed first. If there is no combination possible the print "Empty"
(without quotes).
"""


def head(x):
    if len(x) > 0:
        return x[0]
    else:
        return []


def tail(x):
    return x[1:len(x)]


def comb_sum(data, total_sum):
    if total_sum == 0:
        return 1
    elif total_sum < 0:
        return 0
    elif len(data) == 0:
        return 0
    else:
        return comb_sum(data, total_sum - head(data)) + comb_sum(tail(data), total_sum)


if __name__ == "__main__":
    data = [1, 2, 3, 4]
    sorted_data = sorted(set(data))
    total = 40
    print(comb_sum(sorted_data, total))
