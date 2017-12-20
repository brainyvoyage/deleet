import math
from collections import deque


class Heap(object):
    def __init__(self, data):
        if not isinstance(data, deque):
            self.heap = deque(data)
        else:
            self.heap = data
        self.build_heap()

    @staticmethod
    def get_parent(i):
        if i == 0:
            return 0
        else:
            return math.floor((i - 1)/2)

    @staticmethod
    def get_left_child(i):
        return (i << 1) + 1

    @staticmethod
    def get_right_child(i):
        return (i << 1) + 2

    def __str__(self):
        return ', '.join([str(x) for x in self.heap])

    def _heapify(self, i, cmp):
        left = Heap.get_left_child(i)
        right = Heap.get_right_child(i)
        largest_index = -1
        changed = False
        if left < len(self.heap) and cmp(self.heap[left], self.heap[i]):
            largest_index = left
            changed = True
        if right < len(self.heap) and changed and cmp(self.heap[right], self.heap[largest_index]):
            largest_index = right
            changed = True

        if changed:
            self.heap[i], self.heap[largest_index] = self.heap[largest_index], self.heap[i]
            self._heapify(largest_index, cmp)

    def _max_heapify(self, i):
        self._heapify(i,  cmp=lambda x, y: True if x > y else False)

    def build_heap(self, max_heap=True):
        if max_heap:
            for i in range(len(self.heap) >> 1, -1, -1):
                self._heapify(i, cmp=lambda x, y: True if x > y else False)
        else:
            for i in range(len(self.heap) >> 1, -1, -1):
                self._heapify(i, cmp=lambda x, y: True if x < y else False)

    def sort(self, asc=False):
        # print(len(self.heap))
        self.build_heap(True)
        result = []
        for i in range(len(self.heap) - 1, -1, -1):
            # print(i)
            self.heap[0], self.heap[i] = self.heap[i], self.heap[0]
            result.append(self.heap.pop())
            # print(result, len(self.heap), i)
            self._heapify(0, cmp=lambda x, y: True if x > y else False)
        if asc:
            self.heap = deque(reversed(result))
        else:
            self.heap = deque(result)

    def max(self):
        return self.heap[0]

    def extract_max(self):
        heap_max = self.heap.popleft()
        self._heapify(0, cmp=lambda x, y: True if x > y else False)
        return heap_max

    def increase_key(self, index, increment):
        if 0 <= index < len(self.heap):
            self.heap[index] += increment
        while index > 0 and self.heap[Heap.get_parent(index)] < self.heap[index]:
            self.heap[index], self.heap[Heap.get_parent(index)] = self.heap[Heap.get_parent(index)], self.heap[index]
            index = Heap.get_parent(index)

    def insert(self, value):
        self.heap.append(0)
        self.increase_key(len(self.heap) - 1, value)


if __name__ == "__main__":
    heap = Heap([2, 8, 4, 14, 1, 7, 19, 9, 10, 3, 16, 19, 18])
    print(heap)
    # print(heap.max())
    # heap.build_heap(True)
    # print(heap)
    # heap.build_heap(max_heap=False)
    # print(heap)
    # heap.sort(False)
    # print(heap)
    # for i in range(5):
    #     print(heap.extract_max())
    #

    heap.increase_key(4, 50)
    print(heap)
    heap.insert(70)
    print(heap)
