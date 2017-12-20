import math


class Heap(object):
    def __init__(self, data):
        self.heap = data

    @staticmethod
    def get_parent(i):
        return math.floor(i/2)

    @staticmethod
    def get_left_child(i):
        return (i << 1) + 1

    @staticmethod
    def get_right_child(i):
        return (i << 1) + 2

    def build_heap(self, max_heap=True):
        if max_heap:
            for i in range(len(self.heap) >> 1, -1, -1):
                self._heapify(i, cmp=lambda x, y: True if x > y else False)
        else:
            for i in range(len(self.heap) >> 1, -1, -1):
                self._heapify(i, cmp=lambda x, y: True if x < y else False)

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

    def sort(self):
        self.build_heap()
        for i in range(len(self.heap) - 1, -1, -1):
            # print(i)
            self.heap[0], self.heap[i] = self.heap[i], self.heap[0]
            x = self.heap.pop()
            print(i, x)
            self._heapify(0, cmp=lambda x, y: True if x > y else False)

    def __str__(self):
        return ', '.join([str(x) for x in self.heap])

if __name__ == "__main__":
    from collections import deque
    heap = Heap(deque([2, 8, 4, 14, 1, 7, 16, 9, 10, 3, 19]))
    # print(heap)
    # heap.build_heap(True)
    # print(heap)
    # heap.build_heap(max_heap=False)
    # print(heap)
    # heap.build_heap(True)
    # print(heap)
    # heap.build_heap(True)
    # print(heap)
    heap.sort()
    # for i in range(6):
    #     heap.build_heap(True)
    #
    #     print(heap)
    #     heap.build_max_heap()
    #     print(heap)
    #     print('**' * 30)
    # heap.build_heap()
    # print(heap)