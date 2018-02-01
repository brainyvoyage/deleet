class Node(object):

    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None
        self.parent = None

    def __str__(self):
        return 'Node({})'.format(self.data)

    def debug_str(self):
        return 'Node({})[L: {}, R: {}]'.format(self.data, self.left, self.right)

    def __eq__(self, other):
        return self.data == other.data
