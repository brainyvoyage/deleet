# http://www.geeksforgeeks.org/adding-two-polynomials-using-linked-list/
# Adding two polynomials using Linked List
# 2.5
# Given two polynomial numbers represented by a linked list.
# Write a function that add these lists means add the coefficients
# who have same variable powers.
#
# Example:
#
# Input:
#      1st number = 5x^2 + 4x^1 + 2x^0
#      2nd number = 5x^1 + 5x^0
# Output:
#         5x^2 + 9x^1 + 7x^0
# Input:
#      1st number = 5x^3 + 4x^2 + 2x^0
#      2nd number = 5x^1 + 5x^0
# Output:
#         5x^3 + 4x^2 + 5x^1 + 7x^0


class PolyNomial(object):
    def __init__(self, coeff=0.0, power=0.0):
        self.coeff = coeff
        self.power = power
        self.next = None

    def __str__(self):
        return self._to_string()

    def _to_string(self):
        rep = str(self.coeff) + 'x^' + str(self.power)
        tail = self.next
        while tail is not None:
            if tail.coeff < 0:
                rep += ' - ' + str(abs(tail.coeff)) + 'x^' + str(tail.power)
            else:
                rep += ' + ' + str(tail.coeff) + 'x^' + str(tail.power)
            tail = tail.next
        return rep

if __name__ == "__main__":
    root = PolyNomial(5,4)
    root.next = PolyNomial(-4, 3)
    root.next.next = PolyNomial(3,2)
    root.next.next.next = PolyNomial(2,1)
    print(root)