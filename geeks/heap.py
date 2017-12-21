import math
from collections import deque


def greater_than(x, y):
    return True if x > y else False


def less_than(x, y):
    return True if x < y else False


class Heap(object):
    def __init__(self, data, comparator):
        self._cmp_ = comparator
        if not isinstance(data, deque):
            self.heap = deque(data)
        else:
            self.heap = data
        self.build_heap()

    @staticmethod
    def get_parent(i):
        if i < 1:
            return 0
        else:
            return math.floor((i - 1) / 2)

    @staticmethod
    def get_left_child(i):
        return (i << 1) + 1

    @staticmethod
    def get_right_child(i):
        return (i << 1) + 2

    def __str__(self):
        return ', '.join([str(x) for x in self.heap])

    def __len__(self):
        return len(self.heap)

    def _heapify(self, i):
        left = Heap.get_left_child(i)
        right = Heap.get_right_child(i)
        changed_index = -1
        changed = False
        if left < len(self.heap) and self._cmp_(self.heap[left], self.heap[i]):
            changed_index = left
            changed = True
        if right < len(self.heap) and changed and self._cmp_(self.heap[right], self.heap[changed_index]):
            changed_index = right
            changed = True

        if changed:
            self.heap[i], self.heap[changed_index] = self.heap[changed_index], self.heap[i]
            self._heapify(changed_index)

    def build_heap(self):
        for i in range(len(self.heap) >> 1, -1, -1):
            self._heapify(i)

    def sort(self, asc=False):
        # print(len(self.heap))
        self.build_heap()
        result = []
        for i in range(len(self.heap) - 1, -1, -1):
            # print(i)
            self.heap[0], self.heap[i] = self.heap[i], self.heap[0]
            result.append(self.heap.pop())
            # print(result, len(self.heap), i)
            self._heapify(0)
        if asc:
            self.heap = deque(reversed(result))
        else:
            self.heap = deque(result)

    def top(self):
        return self.heap[0]

    def extract_top(self):
        heap_top = self.heap.popleft()
        self._heapify(0)
        return heap_top

    def change_key(self, index, value):
        if 0 <= index < len(self.heap):
            self.heap[index] = value
        while index > 0 and self._cmp_(self.heap[index], self.heap[Heap.get_parent(index)]):
            self.heap[index], self.heap[Heap.get_parent(index)] = self.heap[Heap.get_parent(index)], self.heap[index]
            index = Heap.get_parent(index)

    def insert(self, value):
        self.heap.append(0)
        self.change_key(len(self.heap) - 1, value)


if __name__ == "__main__":
    max_heap = Heap([2, 8, 4, 14, 1, 7, 19, 9, 10, 3, 16, 19, 18], less_than)
    print(max_heap)
    max_heap.change_key(4, 50)
    print(max_heap)
    max_heap.insert(70)
    print(max_heap)
    print(max_heap.top())
    print(max_heap)
    print(max_heap.extract_top())
    print(max_heap)
    max_heap.sort()
    print(max_heap)
