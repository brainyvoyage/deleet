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


def insert(root, node):
    if root is None:
        return node
    if root.data >= node.data:
        root.left = insert(root.left, node)
    else:
        root.right = insert(root.right, node)
    return  root


def find_minimum(root):
    min_node = root
    while min_node.left is not None:
        min_node = min_node.left
    return min_node


def delete_node(root, node_key):
    if root is None:
        return root

    if root.data > node_key:
        root.left = delete_node(root.left, node_key)

    elif root.data < node_key:
        root.right = delete_node(root.right, node_key)

    else:
        # node_key found
        # if root.left is None and root.right is None:
        #     root = None
        #     return root
        # Node to be deleted has only one child
        # Replace the node with the child and delete the node
        if root.left is None:
            temp = root.right
            root = None
            return temp

        elif root.right is None:

            temp = root.left
            root = None
            return temp
        # Node to be deleted has two child

        # Node with two children: Get the inorder successor
        # (smallest in the right subtree)
        _inorder_successor = find_minimum(root.right)

        # Copy the inorder successor's content to this node
        root.data = _inorder_successor.data

        # Delete the inorder successor
        root.right = delete_node(root.right, _inorder_successor.data)
    return root


def find_least_common_ancestor(root, node1, node2):

    if root is None:
        return root

    if root.data == node1.data or root.data == node2.data:
        return root

    left_lca = find_least_common_ancestor(root.left, node1, node2)
    right_lca = find_least_common_ancestor(root.right, node1, node2)

    if left_lca and right_lca:
        return root

    return left_lca if left_lca is not None else right_lca


def find_level(root_node, node_key):
    def find_level_helper(root, node_key, level):
        if root is None:
            return -1
        if root.data == node_key:
            return level + 1
        if root.data > node_key:
            return find_level_helper(root.left, node_key, level + 1)
        elif root.data < node_key:
            return find_level_helper(root.right, node_key, level + 1)
        else:
            return -1
    return find_level_helper(root_node, node_key, -1)


def inorder_successor(node):
    rt_node = node.right
    while rt_node.left is not None:
        rt_node = rt_node.left
    return rt_node


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

    bst = Node(4)
    bst = insert(bst, Node(2))
    bst = insert(bst, Node(7))
    bst = insert(bst, Node(1))
    bst = insert(bst, Node(5))
    bst = insert(bst, Node(3))
    print('Is valid: {}'.format(is_bst(bst)))
    res = inorder(bst)
    print('In-order = {}'.format(res))
    print('BFS: {}'.format(breadth_first_search(bst)))
    n1, n2 = Node(5), Node(1)
    lca = find_least_common_ancestor(bst, n1, n2)
    print('Least common anccesstor of {} and {} is {}'.format(n1, n2, lca))

    print('BFS: {}'.format(breadth_first_search(bst)))
    bfs = delete_node(bst, 4)
    print('BFS: {}'.format(breadth_first_search(bst)))
    print('Is valid BST: {}'.format(is_bst(bst)))
    level_node_key = 6
    level = find_level(bst, level_node_key)
    print('Level of {} is {}'.format(level_node_key, level))

