"""
Find the nearest smaller numbers on left side in an array. Given an array of integers, find the nearest smaller
number for every element such that the smaller element is on left side.

Examples:

Input:  arr[] = {1, 6, 4, 10, 2, 5}
Output:         {_, 1, 1,  4, 1, 2}
First element ('1') has no element on left side. For 6,
there is only one smaller element on left side '1'.
For 10, there are three smaller elements on left side (1,
6 and 4), nearest among the three elements is 4.

Input: arr[] = {1, 3, 0, 2, 5}
Output:        {_, 1, _, 0, 2}
"""

def find_smallest(arr):
    small_stack = []

    result = []
    result.append(None)
    small_stack.append(arr[0])

    for i in range(1, len(arr)):
        while len(small_stack) > 0 and small_stack[len(small_stack) - 1] >= arr[i]:
            small_stack.pop()
        if len(small_stack) > 0:
            result.append(small_stack[len(small_stack) - 1])
        else:
            result.append(None)
        small_stack.append(arr[i])

    return [x if x is not None else '_' for x in result]

if __name__ == "__main__":
    arr = [7, 6, 4, 10, 2, 5]
    result = find_smallest(arr)
    print(result)
    print(find_smallest([1, 3, 0, 2, 5]))