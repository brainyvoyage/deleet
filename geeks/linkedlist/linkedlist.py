from geeks.linkedlist.node import Node

class LinkedList(object):
    def __init__(self, head_data):
        self.head = Node(head_data)

    def insert_left(self, node):
        if self.head is None:
            return
        current = self.head
        while current.left is not None:
            current = current.left

        current.left = node

    def get_node(self, index):
        if self.head is None:
            return None
        current_index = 0
        current = self.head
        while current_index != index and current is not None:
            current_index += 1
            current = current.left
        if current_index == index:
            return current
        else:
            return None

    def __str__(self):
        if self.head is None:
            return 'Empty linked list'

        current = self.head
        to_string = ''
        while current is not None and current.left is not None:
            to_string += str(current) + ' -> '
            current = current.left
        # if current != self.head:
        to_string += str(current)

        return to_string