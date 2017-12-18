from unittest import TestCase


class TestFindLeastCommonAncestor(TestCase):
    def test_find_least_common_ancestor(self):
        from geeks.node import Node
        from geeks.binary_tree_util import insert, find_least_common_ancestor
        n1, n2, n3, n4, n7, n5 = Node(1), Node(2), Node(3), Node(4), Node(5), Node(7)
        bst = n4
        bst = insert(bst, n2)
        bst = insert(bst, n7)
        bst = insert(bst, n1)
        bst = insert(bst, n5)
        bst = insert(bst, n3)

        lca = find_least_common_ancestor(bst, n5, n1)
        assert (n4 == lca)
