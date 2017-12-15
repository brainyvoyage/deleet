from geeks.constants import *
from geeks.node import Node


def is_bst(root_node):
    def is_bst_util(node, bst_min, bst_max):
        if node is None:
            return True

        if bst_min <= node.data > bst_max:
            return False

        return (is_bst_util(node.left, bst_min, bst_max=(node.data - 1)) and
                is_bst_util(node.right, bst_min=node.data + 1, bst_max=bst_max))

    return is_bst_util(root_node, MIN_INT64, MAX_INT64)


def inorder(root_node):
    def inorder_util(node, result):
        if node is None:
            return result

        inorder_util(node.left, result)
        result.append(node.data)
        inorder_util(node.right, result)
        return result
    return inorder_util(root_node, [])


def preorder(root_node):
    def preorder_util(node, result):
        if node is None:
            return result
        result.append(node.data)
        preorder_util(node.left, result)
        preorder_util(node.right, result)
        return result
    return preorder_util(root_node, [])


def postorder(root_node):
    def postorder_util(node, result):
        if node is None:
            return result
        postorder_util(node.left, result)
        postorder_util(node.right, result)
        result.append(node.data)
        return result
    return postorder_util(root_node, [])


def breadth_first_search(root_node):
    result = []
    if root_node is None:
        return
    from collections import deque
    queue = deque()
    queue.append(root_node)

    while len(queue) > 0:
        top = queue.popleft()
        result.append(top.data)
        if top.left is not None:
            queue.append(top.left)
        if top.right is not None:
            queue.append(top.right)
    return result


if __name__ == "__main__":
    root = Node(4)
    root.left = Node(2)
    root.right = Node(5)
    root.left.left = Node(1)
    root.left.right = Node(3)

    valid = is_bst(root)
    print('BST Valid: {}'.format(valid))
    res = inorder(root)
    print('In-order = {}'.format(res))
    res = preorder(root)
    print('Pre-order: {}'.format(res))
    res = postorder(root)
    print('Post-order: {}'.format(res))
    res = breadth_first_search(root)
    print('BFS: {}'.format(res))
