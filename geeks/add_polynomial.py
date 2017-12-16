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

# from boundinnerclass import BoundInnerClass


class PolyNomialTerms(object):
    def __init__(self, coeff=0.0, power=0.0):
        self.coeff = coeff
        self.power = power

    def __str__(self):
        rep = ''
        if self.coeff > 0:
            rep = '+ ' + str(self.coeff)
        else:
            rep = '- ' + str(abs(self.coeff))
        if self.coeff != 0.0:
            rep += 'x^' + str(self.power)
        return rep

    def __eq__(self, other):
        return other.coeff == self.coeff and other.power == self.power


class PolyNomial(object):

    def __init__(self):
        self.terms = []

    def __str__(self):
        return ' '.join(str(term) for term in self.terms).strip('+ ')

    def append(self, coeff, power):
        poly_term = PolyNomialTerms(coeff, power)
        self.terms.append(poly_term)

    def insert(self, coeff, power=0):
        poly_term = PolyNomialTerms(coeff, power)
        at = 0
        for at, term in enumerate(self.terms):
            if term.power < poly_term.power:
                break
        if at < len(self.terms) and self.terms[at].power > poly_term.power:
            at = at + 1
        self.terms.insert(at, poly_term)

    def __getitem__(self, index):
        return self.terms[index]

    def __len__(self):
        return len(self.terms)

    def __add__(self, that):
        result = PolyNomial()
        i = 0
        j = 0

        while j < len(that):
            if i > len(self.terms) - 1:
                break
            if self.terms[i].power == that[j].power:
                result.insert(self.terms[i].coeff + that[j].coeff, self.terms[i].power)
                i += 1
                j += 1
            elif self.terms[i].power > that[j].power:
                result.insert(self.terms[i].coeff, self.terms[i].power)
                i += 1
            else:
                result.insert(that[j].coeff, that[j].power)
                j += 1

        while i < len(self.terms):
            result.insert(self.terms[i].coeff, self.terms[i].power)
            i += 1

        while j < len(that):
            result.insert(that[j].coeff, that[j].power)
            j += 1
        return result

    def __eq__(self, other):
        return other.terms == self.terms



if __name__ == "__main__":

    poly1 = PolyNomial()
    poly1.insert(3, 2)
    poly1.insert(-4, 5)
    poly1.insert(3, -8)
    poly1.insert(7, 6)
    poly1.insert(4, 9)
    poly1.insert(2)


    poly2 = PolyNomial()
    poly2.insert(4, 7)
    poly2.insert(-10)

    print(poly1)
    print(poly2)
    print(poly1 + poly2)