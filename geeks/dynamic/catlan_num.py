"""
Catalan numbers are a sequence of natural numbers that occurs in many interesting counting problems like following.

Catalan(n) is the sum of catalan(i)*catalan(n-i-1)
"""


# A dynamic programming based function to find nth
# Catalan number
def catlan(n):
    if (n == 0 or n == 1):
        return 1

    memoize = [0 for i in range(n + 1)]

    # Base case
    memoize[0] = 1
    memoize[1] = 1

    for i in range(2, n + 1):
        memoize[i] = 0
        for j in range(i):
            memoize[i] +=  memoize[j] * memoize[i - j - 1]

    return memoize[n]

def binomial_coeff(n, k):
    if k > (n - k):
        k = n - k
    result = 1
    for i in range(k):
        result *= (n - i)
        result /= (i + 1)
    return int(result)

def catlan2(n):
    return int(binomial_coeff(2 * n, n)/(n + 1))
if __name__ == "__main__":
    for i in range(10):
        print(catlan(i))
    print('-' * 20)
    for i in range(10):
        print(catlan2(i))