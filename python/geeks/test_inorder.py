from unittest import TestCase


class TestInorder(TestCase):
    def test_inorder(self):
        from geeks.binary_tree_util import insert, inorder
        from geeks.node import Node
        bst = Node(9)
        bst = insert(bst, Node(1))
        bst = insert(bst, Node(4))
        bst = insert(bst, Node(10))
        bst = insert(bst, Node(8))
        bst = insert(bst, Node(3))
        bst = insert(bst, Node(5))
        bst = insert(bst, Node(2))
        bst = insert(bst, Node(6))

        expected = [1, 2, 3, 4, 5, 6, 8, 9 ,10]
        assert (expected == inorder(bst))
