"""
http://www.geeksforgeeks.org/bottom-view-binary-tree/
Bottom View of a Binary Tree

Given a Binary Tree, we need to print the bottom view from left to right.
A node x is there in output if x is the bottommost node at its horizontal
distance. Horizontal distance of left child of a node x is equal to horizontal
distance of x minus 1, and that of right child is horizontal distance of x plus 1


                     20
                   /    \
                 8       22
               /   \      \
             5      3      25
                   /  \
                 10   14
For the above tree the output should be 5, 10, 3, 14, 25.

If there are multiple bottom-most nodes for a horizontal distance from root,
then print the later one in level traversal. For example, in the below
diagram, 3 and 4 are both the bottom-most nodes at horizontal distance 0,
we need to print 4.

                      20
                    /    \
                  8       22
                /   \    /   \
              5      3 4     25
                    / \
                  10    14
For the above tree the output should be 5, 10, 4, 14, 25.
"""


class Node(object):
    def __init__(self, data):
        from geeks.constants import MAX_INT64
        self.left = None
        self.right = None
        self.data = data
        self.horizontal_depth = MAX_INT64

    def __str__(self):
        return 'Node[{}]({})'.format(self.horizontal_depth, self.data)

    def __eq__(self, other):
        return self.horizontal_depth == other.horizontal_depth and self.data == other.data


def bottom_view(root):

    if root is None:
        return

    from collections import deque
    node_queue = deque()
    depth_map = dict()

    hd = 0
    node_queue.append(root)
    root.horizontal_depth = hd

    while len(node_queue) > 0:
        current_node = node_queue.popleft()
        hd = current_node.horizontal_depth
        depth_map[hd] = current_node
        if current_node.left is not None:
            current_node.left.horizontal_depth = hd - 1
            node_queue.append(current_node.left)
        if current_node.right is not None:
            current_node.right.horizontal_depth = hd + 1
            node_queue.append(current_node.right)

    result = []
    for key in sorted(depth_map.keys()):
        result.append(depth_map[key])
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

    bv = bottom_view(root)
    for x in bv:
        print(x)
