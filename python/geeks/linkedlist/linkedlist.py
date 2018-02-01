from geeks.linkedlist.node import Node


class LinkedList(object):
    def __init__(self, head_data):
        self.head = Node(head_data)
        self.tail = self.head
        self.size = 1

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
        self.size += 1

    def get_node(self, index):
        if self.head is None:
            return None
        current_index = 0
        current = self.head
        while current_index != (index - 1) and current is not None:
            current_index += 1
            current = current.right
        if current_index == (index - 1):
            return current
        else:
            return None

    def pairwise_swap(self):
        if self.size == 1:
            return

    def print_reverse(self):
        if self.tail is None:
            return 'Empty Linked List'
        current = self.tail
        to_string = ''
        while current is not None and current.left is not None:
            to_string += str(current) + ' -> '
            current = current.left
        to_string += str(current)
        return to_string

    def __len__(self):
        return self.size

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
        print(to_string)
        return to_string


if __name__ == "__main__":
    ll1 = LinkedList(3)
    for x in [5, 7]:
        ll1.insert_right(Node(x))
    node = ll1.get_node(3)
    print(ll1)
    ll1.pairwise_swap()
    print(ll1)
