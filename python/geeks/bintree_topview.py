"""
Print Nodes in Top View of Binary Tree
Top view of a binary tree is the set of nodes visible when the tree is viewed from the top.
Given a binary tree, print the top view of it. The output nodes can be printed in any order.
Expected time complexity is O(n)

A node x is there in output if x is the topmost node at its horizontal distance. Horizontal
distance of left child of a node x is equal to horizontal distance of x minus 1, and that
of right child is horizontal distance of x plus 1.

       1
    /     \
   2       3
  /  \    / \
 4    5  6   7
Top view of the above binary tree is
4 2 1 3 7

        1
      /   \
    2       3
      \
        4
          \
            5
             \
               6
Top view of the above binary tree is
2 1 3 6
"""

from geeks.constants import MIN_INT64

class Node(object):
    def __init__(self, data):
        self.left = None
        self.right = None
        self.data = data
        self.horizontal_depth = MIN_INT64

    def __str__(self):
        return 'Node[{}]({})'.format(self.horizontal_depth, self.data)

def top_view(root):
    if root is None:
        return root
    from collections import deque
    top_view_map= {}
    depth_queue = deque()
    hd = 0
    root.horizontal_depth = hd
    depth_queue.append(root)

    while len(depth_queue) > 0:
        top = depth_queue.popleft()
        hd = top.horizontal_depth
        if hd not in top_view_map:
            top_view_map[hd] = top

        if top.left is not None:
            top.left.horizontal_depth = hd - 1
            depth_queue.append(top.left)
            # result.append(top.left)
        if top.right is not None:
            top.right.horizontal_depth = hd + 1
            depth_queue.append(top.right)
            # result.append(top.right)
    result = []
    for key in sorted(top_view_map):
        result.append(top_view_map.get(key))
    return result


if __name__ == "__main__":
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

    tv = top_view(root)
    print([str(x) for x in tv])
    print([x.data for x in tv])

    """
    
        1
      /   \
    2       3
      \
        4
          \
            5
             \
               6

    2 1 3 6

    """
    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.right = Node(4)
    root.left.right.right = Node(5)
    root.left.right.right.right = Node(6)

    tv = top_view(root)
    print([str(x) for x in tv])
    print([x.data for x in tv])
