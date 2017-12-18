"""
http://www.geeksforgeeks.org/add-greater-values-every-node-given-bst/
Given a Binary Search Tree (BST), modify it so that all greater values in the
given BST are added to every node. For example, consider the following BST.

              50
           /      \
         30        70
        /   \      /  \
      20    40    60   80

The above tree should be modified to following

              260
           /      \
         330        150
        /   \       /  \
      350   300    210   80
"""


from geeks.binary_tree_util import is_bst, breadth_first_search, inorder
from geeks.node import Node


def add_greater(root):
    if root is Node:
        return
    if not is_bst(root):
        print('Not a valid BST')

    def inorder(root_node):
        def inorder_util(node, result):
            if node is None:
                return result
            inorder_util(node.left, result)
            result.append(node)
            inorder_util(node.right, result)
            return result
        return inorder_util(root_node, [])
    ordered = inorder(root)
    total_nodes = len(ordered)
    for index in range(total_nodes - 2, 0, -1):
        if index < total_nodes:
            ordered[index].data += ordered[index + 1].data
    ordered[0].data += ordered[1].data
    return ordered

if __name__ == "__main__":
    root = Node(50)
    root.left = Node(30)
    root.right = Node(70)
    root.left.left = Node(20)
    root.left.right = Node(40)
    root.right.left = Node(60)
    root.right.right = Node(80)
    _ = add_greater(root)
    print('BFS: {}'.format(breadth_first_search(root)))
    print('Inorder: {}'.format(inorder(root)))
