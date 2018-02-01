"""
Given an array A[] and a number x, check for pair in A[] with sum as x
Write a C program that, given an array A[] of n numbers and another
number x, determines whether or not there exist two elements in S
whose sum is exactly x.
"""

def sum_exists(nums, total):
    diff_set = set()
    result = []
    for n in nums:
        diff = total - n
        if n in diff_set:
            result.append((n, diff))
        else:
            diff_set.add(diff)
    return result


if __name__ == "__main__":
    nums = [8, 38, 2, 54, -42, 19, 10, 85, 4]
    total = 12
    result = sum_exists(nums, total)
    print(result)