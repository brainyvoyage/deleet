"""
Find all permuted rows of a given row in a matrix
We are given a m*n matrix of positive integers and a row number.
The task is to find all rows in given matrix which are permutations
of given row elements. It is also given that values in every row are distinct.

Examples:

Input : mat[][] = {{3, 1, 4, 2},     ,
                   {1, 6, 9, 3},
                   {1, 2, 3, 4},
                   {4, 3, 2, 1}}
        row = 3
Output: 0, 2
Rows at indexes 0 and 2 are permutations of
row at index 3.
"""

def find_permuted_rows(mat, row):
    num_rows = len(mat)
    assert (row < num_rows)

    hashed_row = set(mat[row])
    result = []
    for r in range(num_rows):
        if r == row:
            continue
        c = set(mat[r])
        if c == hashed_row:
            result.append(r)
    return result

if __name__ == "__main__":
    mat = [
        [3, 1, 4, 2],
        [1, 6, 9, 3],
        [1, 2, 3, 4],
        [4, 3, 2, 1]
    ]
    rows = find_permuted_rows(mat, 3)
    print(rows)