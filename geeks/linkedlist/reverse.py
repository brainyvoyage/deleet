"""
Print reverse of a Linked List without actually reversing
Given a linked list, print reverse of it using a recursive function.
For example, if the given linked list is 1->2->3->4, then output should be 4->3->2->1.

Note that the question is only about printing the reverse.
"""
from geeks.linkedlist.linkedlist import LinkedList
from geeks.linkedlist.node import Node


def print_reverse(head_node):
    if head_node is None:
        return
    if head_node.right is None:
        print(head_node)
        return
    else:
        print_reverse(head_node.right)
        print(head_node)


if __name__ == "__main__":
    ll1 = LinkedList(3)
    for x in [5, 9, 10, 13, 15, 17]:
        ll1.insert_right(Node(x))

    print(ll1)
    print_reverse(ll1.head)