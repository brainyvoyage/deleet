from geeks.linkedlist.node import Node
from geeks.linkedlist.linkedlist import LinkedList


def get_intersection_point(linked_list1, linked_list2):
    current_ll1 = linked_list1.head
    seen = {}

    while current_ll1 is not None:
        seen[current_ll1] = current_ll1
        current_ll1 = current_ll1.left
    current_ll2 = linked_list2.head

    while current_ll2 is not None:
        if current_ll2 in seen:
            return seen[current_ll2]
        else:
            current_ll2 = current_ll2.left
    return None


if __name__ == "__main__":
    ll1 = LinkedList(3)
    for x in [5, 9, 10, 13, 15, 17]:
        ll1.insert_left(Node(x))

    node = ll1.get_node(3)

    ll2 = LinkedList(4)
    for x in [6, 7, 8, 9]:
        ll2.insert_left(Node(x))

    ll2.insert_left(node)
    intersect_point = get_intersection_point(linked_list1=ll1, linked_list2=ll2)

    print('Linked List 1 ==> {}'.format(ll1))
    print('Linked List 2 ==> {}'.format(ll2))
    print('Intersection Point: {}'.format(intersect_point))
