from unittest import TestCase


class TestBottomView(TestCase):
    def test_bottom_view(self):
        from geeks.binary_tree_bottom_view import Node, bottom_view
        n20, n8, n22, n5, n3, n4, n25 = Node(20), Node(8), Node(22), Node(5), Node(3), Node(4), Node(25)
        n10, n14 = Node(10), Node(14)
        root = n20
        root.left = n8
        root.right = n22
        root.left.left = n5
        root.left.right = n3
        root.right.left = n4
        root.right.right = n25
        root.left.right.left = n10
        root.left.right.right = n14

        bv = bottom_view(root)

        expected = []
        en5 = Node(5)
        en5.horizontal_depth = -2
        expected.append(en5)
        en10 = Node(10)
        en10.horizontal_depth = -1
        expected.append(en10)

        en4 = Node(4)
        en4.horizontal_depth = 0
        expected.append(en4)

        en14 = Node(14)
        en14.horizontal_depth = 1
        expected.append(en14)

        en2 = Node(25)
        en2.horizontal_depth = 2
        expected.append(en2)

        for x, y in zip(bv, expected):
            assert (x == y)