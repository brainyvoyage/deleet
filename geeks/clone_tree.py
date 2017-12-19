"""
Clone a Binary Tree with Random Pointers where random pointer points to any
random node of the binary tree and can even point to NULL,
clone the given binary tree.
"""


class Node(object):
    def __init__(self, data):
        self.left = None
        self.right = None
        self.data = data
        self.random = None

    def __str__(self):
        if self.left is not None:
            left_data = self.left.data
        else:
            left_data = 'null'
        if self.right is not None:
            right_data = self.right.data
        else:
            right_data = 'null'
        return 'Node({})[{}, {}]:{}'.format(self.data, left_data, right_data, id(self) % 10000)

    def __eq__(self, other):
        return self.data == other.data


def clone_binary_tree(root):
    if root is None:
        return None

    clone_root = Node(0)

    from collections import deque

    original_queue = deque()
    copy_queue = deque()
    original_queue.append(root)
    copy_queue.append(clone_root)

    while len(original_queue) > 0:
        top = original_queue.popleft()
        clone_top = copy_queue.popleft()
        clone_top.data = top.data

        if top.left is not None:
            original_queue.append(top.left)
            clone_top.left = Node(0)
            copy_queue.append(clone_top.left)
        if top.right is not None:
            original_queue.append(top.right)
            clone_top.right = Node(0)
            copy_queue.append(clone_top.right)

    return clone_root

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

    clone = clone_binary_tree(root)

    from geeks.binary_tree_util import breadth_first_search
    bfs_orig = breadth_first_search(root)
    bfs_copy = breadth_first_search(clone)
    print([str(x) for x in bfs_orig])
    print([str(x) for x in bfs_copy])
