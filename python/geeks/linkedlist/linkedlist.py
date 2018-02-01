from geeks.linkedlist.node import Node


class LinkedList(object):
    def __init__(self, head_data):
        self.head = Node(head_data)
        self.tail = None

    def insert_right(self, node):
        if self.head is None or node is None:
            return

        if self.tail is None:
            node.left = self.head
            self.head.right = node
            self.tail = node
        else:
            node.left = self.tail
            self.tail.right = node
            self.tail = self.tail.right

    def get_node(self, index):
        if self.head is None:
            return None
        current_index = 0
        current = self.head
        while current_index != index and current is not None:
            current_index += 1
            current = current.right
        if current_index == index:
            return current
        else:
            return None

    def __str__(self):
        if self.head is None:
            return 'Empty linked list'

        current = self.head
        to_string = ''
        while current is not None and current.right is not None:
            to_string += str(current) + ' -> '
            current = current.right
        # if current != self.head:
        to_string += str(current)

        return to_string
