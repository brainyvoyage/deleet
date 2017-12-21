"""
Connect n ropes with minimum cost 3.2
There are given n ropes of different lengths, we need to
connect these ropes into one rope. The cost to connect two
ropes is equal to sum of their lengths. We need to connect
the ropes with minimum cost.

For example if we are given 4 ropes of lengths 4, 3, 2 and 6. We
can connect the ropes in following ways.
1) First connect ropes of lengths 2 and 3. Now we have three ropes of lengths 4, 6 and 5.
2) Now connect ropes of lengths 4 and 5. Now we have two ropes of lengths 6 and 9.
3) Finally connect the two ropes and all ropes have connected.

Total cost for connecting all ropes is 5 + 9 + 15 = 29. This is the optimized
cost for connecting ropes. Other ways of connecting ropes would always have
same or more cost. For example, if we connect 4 and 6 first
(we get three strings of 3, 2 and 10), then connect 10 and 3 (we get two strings of 13 and 2).
Finally we connect 13 and 2. Total cost in this way is 10 + 13 + 15 = 38.
"""

from geeks.heap import less_than
from geeks.heap import Heap


def get_cost(rope_segments):
    min_heap = Heap(rope_segments, less_than)
    cost = 0
    while len(min_heap) > 1:
        smallest_seg = min_heap.extract_top()
        second_small_seg = min_heap.extract_top()
        cost += smallest_seg + second_small_seg
        min_heap.insert(smallest_seg + second_small_seg)
    return cost

if __name__ == "__main__":
    print(get_cost([4, 3, 2, 6]))
