"""
Construct a special tree from given preorder traversal
Given an array ‘pre[]’ that represents Preorder traversal
of a spacial binary tree where every node has either 0 or 2
children. One more array ‘preLN[]’ is given which has only
two possible values ‘L’ and ‘N’. The value ‘L’ in ‘preLN[]’
indicates that the corresponding node in Binary Tree is a
leaf node and value ‘N’ indicates that the corresponding
node is non-leaf node. Write a function to construct the
tree from the given two arrays.

Example:

Input:  pre[] = {10, 30, 20, 5, 15},  preLN[] = {'N', 'N', 'L', 'L', 'L'}
Output: Root of following tree
          10
         /  \
        30   15
       /  \
      20   5
"""
from geeks.node import Node


class PreorderToTreeConverter(object):
    def __init__(self, preorder_traversal, node_or_leaf):
        assert (len(node_or_leaf) == len(preorder_traversal))
        # for ln in node_or_leaf:
        #     if ln != 'L' or ln != 'N':
        #         assert ()
        self.preorder = preorder_traversal
        self.node_or_leaf = node_or_leaf
        self.root = None

    @staticmethod
    def get_insertion_node(current_root):
        if current_root.parent is None:
            return current_root
        if current_root.left is None:
            return current_root
        elif current_root.right is None:
            return current_root
        else:
            if current_root.parent is None:
                return PreorderToTreeConverter.get_insertion_node(current_root)
            else:
                return PreorderToTreeConverter.get_insertion_node(current_root.parent)

    @staticmethod
    def insert_node(parent, child):
        if parent is None:
            return
        if parent.left is None:
            parent.left = child
        else:
            parent.right = child
        child.parent = parent

    def get_tree(self):
        self.root = Node(self.preorder[0])
        current_root = self.root
        for index in range(1, len(self.preorder)):
            data = Node(self.preorder[index])
            ln = self.node_or_leaf[index]
            insertion_point = PreorderToTreeConverter.get_insertion_node(current_root)
            PreorderToTreeConverter.insert_node(insertion_point, data)
            if ln == 'N':
                current_root = data
            else:
                current_root = PreorderToTreeConverter.get_insertion_node(current_root)
        return self.root


if __name__ == "__main__":
    from geeks.binary_tree_util import breadth_first_search
    pre = [10, 30, 20, 5, 15]
    preLN = ['N', 'N', 'L', 'L', 'L']
    p2t = PreorderToTreeConverter(pre, preLN)
    bfs = breadth_first_search(p2t.get_tree())
    print([x.data for x in bfs])
    pre = [1, 3, 5, 9, 10, 6, 4, 7, 8]
    preLN = ['N', 'N', 'N', 'L', 'L', 'L', 'N', 'L', 'L']
    p2t = PreorderToTreeConverter(pre, preLN)
    bfs = breadth_first_search(p2t.get_tree())
    print([x.data for x in bfs])



