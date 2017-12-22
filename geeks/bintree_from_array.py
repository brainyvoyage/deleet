"""
Given an array that represents a tree in such a way that
array indexes are values in tree nodes and array values
give the parent node of that particular index (or node).
The value of the root node index would always be -1 as
there is no parent for root. Construct the standard linked
representation of given Binary Tree from this given representation.
Input: parent[] = {1, 5, 5, 2, 2, -1, 3}
Output: root of below tree
          5
        /  \
       1    2
      /    / \
     0    3   4
         /
        6
Explanation:
Index of -1 is 5.  So 5 is root.
5 is present at indexes 1 and 2.  So 1 and 2 are children of 5.
1 is present at index 0, so 0 is child of 1.
2 is present at indexes 3 and 4.  So 3 and 4 are children of 2.
3 is present at index 6, so 6 is child of 3.


Input: parent[] = {-1, 0, 0, 1, 1, 3, 5};
Output: root of below tree
         0
       /   \
      1     2
     / \
    3   4
   /
  5
 /
6
"""

from geeks.node import Node


class ArrayToBinTree(object):
    def __init__(self, data):
        self.array = data
        self.root = None
        self.nodes = [None] * len(data)

    def _create_node(self, key_value):
        if self.nodes[key_value] is None:
            # print('Node: {}, parent: {}'.format(key_value, self.array[key_value]))
            data_node = Node(key_value)
            self.nodes[key_value] = data_node
            parent_index = self.array[key_value]
            if parent_index is -1:
                self.root = data_node
                return self.root
            else:
                parent = self._create_node(parent_index)
                # print('Parent for {} is {}'.format(data_node, parent))
                if parent.left is None:
                    # print('Adding {} to left of parent {}'.format(data_node, parent))
                    parent.left = data_node
                else:
                    parent.right = data_node
                    # print('Adding {} to left of parent {}'.format(data_node, parent))
                # print(data_node, parent)
                # print('-' * 80)
                return data_node

        else:
            return self.nodes[key_value]

    def get_tree(self):
        for i in range(len(self.array)):
            n = self._create_node(i)
            # print('Created node {} with left {} and right {}'.format(n, n.left, n.right))
        if self.root is None:
            print('No root or a bug')
            return None
        else:
            return self.root


if __name__ == "__main__":
    from geeks.binary_tree_util import inorder, breadth_first_search

    data = [-1, 0, 0, 1, 1, 3, 5]
    a2t = ArrayToBinTree(data)
    root = a2t.get_tree()
    # root = array_to_tree([-1, 0, 0, 1, 1, 3, 5])
    io = inorder(root)
    bfs = breadth_first_search(root)
    print('Input: {}'.format(data))
    print('Inorder: {}'.format(io))
    print('BFS: {}'.format([x.data for x in bfs]))

    data = [1, 5, 5, 2, 2, -1, 3]
    a2t = ArrayToBinTree(data)
    root = a2t.get_tree()
    io = inorder(root)
    bfs = breadth_first_search(root)
    print('Input: {}'.format(data))
    print('Inorder: {}'.format(io))
    print('BFS: {}'.format([x.data for x in bfs]))
